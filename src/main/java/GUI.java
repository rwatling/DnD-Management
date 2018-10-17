import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.control.Button;

public class GUI extends Application {
	 public static void main (String[] args) {
		 launch(args);
	 }
	 
	 
	 double WIDTH = 1400;
	 double HEIGHT = 840;
	 @Override
	 public void start(Stage primaryStage) {
		 
		 Image logo = new Image("D&D_Logo.PNG", WIDTH, HEIGHT/5, true, true);
		 ImageView imageView = new ImageView(logo);
		 
		 Text t = new Text("Choose Character File");
		 t.setFont(new Font("Consolas", 48));
		 Button fileBtn = new Button("", t);
		 
		 BorderPane root = new BorderPane();
		 root.setTop(imageView);
		 root.setAlignment(imageView, Pos.CENTER);
		 root.setCenter(fileBtn);
		 root.setAlignment(fileBtn, Pos.CENTER);
		 
		 Scene scene = new Scene(root, WIDTH, HEIGHT);
		 primaryStage.setTitle("D&D Manager");
		 primaryStage.setScene(scene);
		 primaryStage.show();
	 }
 }