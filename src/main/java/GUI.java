import java.util.Scanner;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
		 
		 HBox choosePane = new HBox();
		 Scanner scan = null;
		 ArrayList<String> pcNameList = new ArrayList<String>();
		
		 try {
			 scan = new Scanner(new File("PC_Names.txt"));
		 } catch (FileNotFoundException e){
			 e.printStackTrace();
		 }
		 
		 while(scan.hasNext()) {
			 pcNameList.add(scan.nextLine());
		 }
		 
		 scan.close();
		 ComboBox<String> nameCombo = new ComboBox<String>();
		 nameCombo.getItems().addAll(pcNameList);
		 
		 Text t = new Text("Choose a Character: ");
		 t.setFont(new Font("Consolas", 24));
		 Text t1 = new Text("New Character");
		 t1.setFont(new Font("Consolas", 24));
		 Button newPCBtn = new Button("",t1);
		 Button dummy = new Button("");
		 dummy.setPrefSize(50, 24);
		 dummy.setVisible(false);
		 newPCBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(2), new Insets(0))));
		 choosePane.getChildren().addAll(t, nameCombo, dummy, newPCBtn);
		 choosePane.setAlignment(Pos.CENTER);
		 
		 BorderPane root = new BorderPane();
		 root.setTop(imageView);
		 root.setAlignment(imageView, Pos.CENTER);
		 root.setCenter(choosePane);
		 
		 Scene scene = new Scene(root, WIDTH, HEIGHT);
		 primaryStage.setTitle("D&D Manager");
		 primaryStage.setScene(scene);
		 primaryStage.show();
	 }
 }