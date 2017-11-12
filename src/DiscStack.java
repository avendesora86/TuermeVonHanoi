import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * Created by shari on 12.11.2017.
 */
public class DiscStack extends VBox{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   private DiscStack (String name, double width, double hight){
       super();
       this.name = name;
       setAlignment(Pos.BOTTOM_CENTER);
       setPrefWidth(150);
       setPrefHeight(300);
       setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
               + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
               + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
   }

   public static DiscStack create(String name, double width, double height){
       return new DiscStack(name, width, height);
   }
}
