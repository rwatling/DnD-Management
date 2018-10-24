import java.util.Scanner;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GUI extends Application {
	 public static void main (String[] args) {
		 launch(args);
	 }
	 
	 
	 double WIDTH = 1400;
	 double HEIGHT = 840;
	 Scene startScreen;
	 Scene newCharScene;
	 Stage window;
	 @Override
	 public void start(Stage primaryStage) {
		 window = primaryStage;
		 
		 startScreen = createStartScreen();
		 newCharScene = createPCScreen();
		 
		 window.setScene(startScreen);
		 window.setTitle("D&D Manager");
		 window.show();
	 }
	 
	 
	 private Scene createStartScreen() {
		 BorderPane root = new BorderPane();
		 
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
		 t.setFont(getFont());
		 
		 Button dummy = new Button("");
		 dummy.setPrefSize(50, 24);
		 dummy.setVisible(false);
		 
		 Text t1 = new Text("Open");
		 t1.setFont(getFont());
		 Button openBtn = new Button("", t1);
		 
		 Button dummy1 = new Button("");
		 dummy1.setPrefSize(50, 24);
		 dummy1.setVisible(false);
		 
		 Text t2 = new Text("New Character");
		 t2.setFont(getFont());
		 Button newPCBtn = new Button("",t2);
		 newPCBtn.setOnAction(event -> {
			 window.setScene(newCharScene);
		 });
		 
		 choosePane.getChildren().addAll(t, nameCombo, dummy, openBtn, dummy1, newPCBtn);
		 choosePane.setAlignment(Pos.CENTER);
		 
		 ImageView logo = getDnDLogo();
		 
		 root.setTop(logo);
		 root.setAlignment(logo, Pos.CENTER);
		 root.setCenter(choosePane);
		 
		 Scene scene = new Scene(root, WIDTH, HEIGHT);
		 return scene;
	 }
	 
	 private Scene createPCScreen() {
		 BorderPane root = new BorderPane();
		 
		 ImageView logo = getDnDLogo();
		 
		 GridPane newCharPane = new GridPane();
		 newCharPane.setHgap(16);
		 newCharPane.setVgap(16);
		 newCharPane.setPadding(new Insets(16, 16, 16, 16));
		 
		 Text charNameText = new Text("Character Name: ");
		 charNameText.setFont(getFont());
		 TextField charName = getGenericTextField();
		 Text levelText = new Text("Level: ");
		 levelText.setFont(getFont());
		 TextField level = getGenericTextField();
		 newCharPane.addRow(0, charNameText, charName, levelText, level);
		 
		 Text raceText = new Text("Race: ");
		 raceText.setFont(getFont());
		 TextField race = getGenericTextField();
		 Text genderText = new Text("Gender: ");
		 genderText.setFont(getFont());
		 TextField gender = getGenericTextField();
		 newCharPane.addRow(1, raceText, race, genderText, gender);
		 
		 Text alignment = new Text("Alignment:");
		 alignment.setFont(getFont());
		 newCharPane.addRow(2, alignment);
		 
		 GridPane innerAlignmentGP = new GridPane();
		 Text lg = new Text("Lawful Good   ");
		 lg.setFont(getFont());
		 Button lawfulGood = new Button("", lg);
		 Text ng = new Text("Neutral Good");
		 ng.setFont(getFont());
		 Button neutralGood = new Button("", ng);
		 Text cg = new Text("Chaotic Good   ");
		 cg.setFont(getFont());
		 Button chaoticGood = new Button("", cg);
		 innerAlignmentGP.addRow(0, lawfulGood, neutralGood, chaoticGood);
		 
		 Text ln = new Text("Lawful Neutral");
		 ln.setFont(getFont());
		 Button lawfulNeutral = new Button("", ln);
		 Text n = new Text("Neutral     ");
		 n.setFont(getFont());
		 Button neutral = new Button("", n);
		 Text cn = new Text("Chaotic Neutral");
		 cn.setFont(getFont());
		 Button chaoticNeutral = new Button("", cn);
		 innerAlignmentGP.addRow(1, lawfulNeutral, neutral, chaoticNeutral);
		 
		 Text le = new Text("Lawful Evil   ");
		 le.setFont(getFont());
		 Button lawfulEvil = new Button("", le);
		 Text ne = new Text("Neutral Evil");
		 ne.setFont(getFont());
		 Button neutralEvil = new Button("", ne);
		 Text ce = new Text("Chaotic Evil   ");
		 ce.setFont(getFont());
		 Button chaoticEvil = new Button("", ce);
		 innerAlignmentGP.addRow(2, lawfulEvil, neutralEvil, chaoticEvil);
		 
		 newCharPane.addRow(2, innerAlignmentGP);
		 
		 Text sizeText = new Text("Size: ");
		 sizeText.setFont(getFont());
		 ArrayList<String> sizes = new ArrayList<String>();
		 sizes.add("Small");
		 sizes.add("Medium");
		 sizes.add("Large");
		 ComboBox<String> size = new ComboBox<String>();
		 size.getItems().addAll(sizes);
		 
		 newCharPane.addRow(2, sizeText, size);
		 
		 ScrollPane scroll = new ScrollPane(newCharPane);
		 root.setCenter(scroll);
		 root.setTop(logo);
		 root.setAlignment(root.getTop(), Pos.CENTER);
		 Scene scene = new Scene(root, WIDTH, HEIGHT);
		 return scene;
	 }
	 
	 private Font getFont() {
		 return new Font("Consolas", 24);
	 }
	 
	 private ImageView getDnDLogo() {
		 Image logo = new Image("D&D_Logo.PNG", WIDTH, HEIGHT/8, true, true);
		 ImageView imageView = new ImageView(logo);
		 return imageView;
	 }
	 
	 private TextField getGenericTextField() {
		 TextField tf = new TextField();
		 tf.setPrefSize(WIDTH/4, 16);
		 tf.setFont(getFont());
		 
		 return tf;
	 }
 }