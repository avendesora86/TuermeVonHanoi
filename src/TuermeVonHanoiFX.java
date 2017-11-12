/**
 * Created by shari on 03.11.2017.
 */

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import static javafx.geometry.VPos.CENTER;

public class TuermeVonHanoiFX extends Application {

    private final int WIDTH = 640;
    private final int HEIGHT = 350;
    private final int NUMBER_OF_DISCS = 6;
    private final Rectangle blau = new Rectangle(20,20, Color.BLUE);
    private final Rectangle rot = new Rectangle(30,20, Color.RED);
    private final Rectangle braun = new Rectangle(40,20, Color.BROWN);
    private final Rectangle schwarz = new Rectangle(50,20, Color.BLACK);
    private final Rectangle gelb = new Rectangle(60,20, Color.YELLOW);
    private final Rectangle grün = new Rectangle(70,20, Color.GREEN);



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Türme von  Hanoi");
        HBox root = new HBox(20);

        VBox vBox = new VBox(10);
        ComboBox<String> disc = new ComboBox<String>();
        disc.setPromptText("Wähle einen Stapel:  ");

        ComboBox<String> place = new ComboBox<String>();
        place.setPromptText("Wähle einen Stapel:  ");

        HBox controls = new HBox(10);
        HBox discStacks = new HBox(10);

        DiscStack[] disckStacks = new DiscStack[]{
                DiscStack.create("Platz1", 150, 300),
                DiscStack.create("Hilfsplatz", 150, 300),
                DiscStack.create("Platz2", 150, 300)
        };
        disckStacks[0].getChildren().addAll(blau,rot,braun,schwarz,gelb,grün);

        initializeComboBoxItems(disc, place, new String[]{
                disckStacks[0].getName(),
                disckStacks[1].getName(),
                disckStacks[2].getName()
        });

//        disc.valueProperty().addListener(new ChangeListener<String>() {
//            @Override public void changed(ObservableValue ov, String t, String t1) {
//                setComboBoxItems(disc, place);
//            }
//        });

        Button btn = new Button("Los!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int fromIndex = disc.getSelectionModel().getSelectedIndex();
                int toIndex = place.getSelectionModel().getSelectedIndex();
                move(disckStacks[fromIndex],
                        disckStacks[toIndex]);

                initializeComboBoxItems(disc, place, new String[]{
                        disckStacks[0].getName(),
                        disckStacks[1].getName(),
                        disckStacks[2].getName()});
            }
        });

        vBox.getChildren().addAll(disc,place,btn);

        controls.getChildren().addAll(vBox);
        discStacks.getChildren().addAll(disckStacks);
        root.getChildren().addAll(controls,  discStacks);
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }

    public boolean move (VBox from, VBox to){

        if (from.getChildren().isEmpty()){
            System.out.println(false);
            return false;
        }

        if (to.getChildren().isEmpty()){
            Node one = from.getChildren().remove(0);
            to.getChildren().add(0,  one);
            System.out.println(true);
            return true;
        }

        Rectangle fr = (Rectangle)(from.getChildren().get(0));
        Rectangle t = (Rectangle)(to.getChildren().get(0));
        if (fr.widthProperty().getValue() < t.widthProperty().getValue()){
            Node one = from.getChildren().remove(0);
            to.getChildren().add(0,  one);
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }

    public void setComboBoxItems(ComboBox fromCombo, ComboBox toCombo){
        toCombo.getItems().get(fromCombo.getSelectionModel().getSelectedIndex());
    }

    public void initializeComboBoxItems(ComboBox from, ComboBox to, String[] items){
        from.getItems().clear();
        to.getItems().clear();

        for (String s: items) {
            from.getItems().add(s);
            to.getItems().add(s);
        }
    }
}
