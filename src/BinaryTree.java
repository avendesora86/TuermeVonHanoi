/**
 * Created by shari on 11.11.2017.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;

public class BinaryTree extends Application {

    private Group root;
//    private int HIGHT = 100;
//    private double  angle  = 45;
//    private int originX = 0;
//    private int originY = 0;
//    private int repetition = 7;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Binary Tree");
        root = new Group();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);

        Rectangle panel = new Rectangle(600, 400, Color.WHITESMOKE);
        root.getChildren().add(panel);
        primaryStage.show();
        paintTree(7, 300,400,100,180);

    }

    private void paintTree(int repetition, int originX, int originY, int HIGHT, double angle){
        if (repetition == -1){
            return;
        }
        Point endPoints = calculatePoint(originX, originY, HIGHT, angle);   //Get End point of branch for line to draw
        Line line = new Line(originX, originY, endPoints.x, endPoints.y); //line object representing the branch
        line.setStroke(Color.BLACK); //color set to branch
        line.setStrokeWidth(2); //branch color width
        root.getChildren().add(line); //  add branch
        paintTree(repetition - 1, endPoints.x, endPoints.y, HIGHT / 2, angle - 35); //recursion to draw right branch
        paintTree(repetition - 1, endPoints.x, endPoints.y, HIGHT / 2, angle + 35); //recursion to draw left branch
    }

    public Point calculatePoint(int x, int y, double size, double degree) {
        Point point = new Point(x, y);
        double radians = Math.PI / 180 * degree; // rad = 180°/π   ,1° = π/180° so radians = degrees × π / 180°

        point.x += (int) (size * Math.sin(radians)); //new x point for end of branch
        point.y += (int) (size * Math.cos(radians)); //new y point for end of branch
        return point;
    }
}
