/**
 * Created by shari on 03.11.2017.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TuermeVonHanoiFX extends Application {

    private final int WIDTH = 650;
    private final int HEIGHT = 350;
    private final int NUMBER_OF_DISCS = 6;
    private final Rectangle blau = new Rectangle(20,20, Color.BLUE);
    private final Rectangle rot = new Rectangle(30,20, Color.RED);
    private final Rectangle braun = new Rectangle(40,20, Color.BROWN);
//    private final Rectangle schwarz = new Rectangle(50,20, Color.BLACK);
//    private final Rectangle gelb = new Rectangle(60,20, Color.YELLOW);
//    private final Rectangle grün = new Rectangle(70,20, Color.GREEN);



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Türme von  Hanoi");
        Group root = new Group();

        VBox vBox = new VBox(10);
        ComboBox<Rectangle> disc = new ComboBox<Rectangle>();
//        disc.getItems().addAll(blau,rot,braun,schwarz,gelb,grün);

        disc.setPromptText("Wähle eine Scheibe:  ");

//        ComboBox<> place = new ComboBox<>();

        HBox main = new HBox(10);
        VBox platz1 = new VBox();
        platz1.getChildren().addAll(rot,braun,blau);

        VBox hilfsplatz = new VBox();

        VBox platz2 = new VBox();

        Button btn = new Button("Los!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                platz1.getChildren().remove(rot);
                platz2.getChildren().add(rot);
            }
        });
        vBox.getChildren().addAll(disc,btn);

        main.getChildren().addAll(vBox,platz1,hilfsplatz,platz2);
        root.getChildren().addAll(main);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }
}
