package me.sean.minesweeper;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Represents a GUI View of the Minesweeper game
 * 
 * @author Sean Droll
 */
public class View extends Application implements Observer {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final int MINES = 20;
    private static int TILE_SIZE = 25;

    private Game game;
    private GridPane gridPane;
    private Stage primaryStage;

    @Override
    public void init() {
        game = new Game(WIDTH, HEIGHT, MINES);
        game.addObserver(this);
        initGridPane();
    }

    /**
     * Creates the initial layout of the gridpane that shows the board
     */
    private void initGridPane() {
        this.gridPane = new GridPane();
        for(int i = 0; i < HEIGHT; i++) {
            for(int j = 0; j < WIDTH; j++) {
                Button btn = new Button();
                final int x = j;
                final int y = i;
                btn.setOnMouseClicked(event -> {
                    if(event.getButton().equals(MouseButton.PRIMARY)) {
                        game.pick(x, y);
                    } else if(event.getButton().equals(MouseButton.SECONDARY)) {
                        game.flag(x, y);
                    }
                });
                btn.setMinHeight(TILE_SIZE);
                btn.setMinWidth(TILE_SIZE);
                BackgroundImage backgroundImage = new BackgroundImage(new Image(getClass().getResource(Value.BLANK.getPath()).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(TILE_SIZE, TILE_SIZE, false, false, false, false));
                Background background = new Background(backgroundImage);
                btn.setBackground(background);
                gridPane.add(btn, j, i);
            }
        }
    }

    /**
     * Updates the gridpane to match the new layout on the board
     */
    private void updateGridpane() {
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
            Button btn = (Button) node;
            int x = GridPane.getRowIndex(node);
            int y = GridPane.getColumnIndex(node);
            Value tile = game.getIcon(y, x);
            BackgroundImage backgroundImage = new BackgroundImage(new Image(getClass().getResource(tile.getPath()).toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(TILE_SIZE, TILE_SIZE, false, false, false, false));
            Background background = new Background(backgroundImage);
            btn.setBackground(background);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Scene scene = new Scene(gridPane);
        this.primaryStage.setScene(scene);
        this.primaryStage.setTitle("Minesweeper");
        this.primaryStage.show();
    }

    @Override
    public void update(String message) {
        updateGridpane();
    }

}
