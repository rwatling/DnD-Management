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
		 PC newCharacter = new PC();
		 
		 ImageView logo = getDnDLogo();
		 
		 BorderPane bottomBtnPane = new BorderPane();
		 
		 Text backText = new Text("<- Back");
		 backText.setFont(getFont());
		 Button back = new Button("", backText);
		 back.setOnAction(e -> {
			window.setScene(startScreen);
		 });
		 
		 Text nextText = new Text("Next ->");
		 nextText.setFont(getFont());
		 Button next = new Button("", nextText);
		 
		 bottomBtnPane.setLeft(back);
		 bottomBtnPane.setRight(next);
		 
		 int row = 0;
		 GridPane newCharPane = new GridPane();
		 newCharPane.setHgap(16);
		 newCharPane.setVgap(16);
		 newCharPane.setPadding(new Insets(32, 32, 32, 32));
		 
		 Text basicInfo = new Text("Basic Information");
		 basicInfo.setFont(getFont(28));
		 newCharPane.addRow(row++, basicInfo);
		 
		 Text charNameText = new Text("Character Name: ");
		 charNameText.setFont(getFont());
		 TextField charName = getGenericTextField();
		 Text levelText = new Text("Level: ");
		 levelText.setFont(getFont());
		 TextField level = getGenericTextField();
		 newCharPane.addRow(row++, charNameText, charName, levelText, level);
		 
		 Text raceText = new Text("Race: ");
		 raceText.setFont(getFont());
		 ComboBox<String> raceCombo = new ComboBox<String>();
		 raceCombo.getItems().addAll("Dwarf", "Elf", "Halfling", "Human", "Dragonborn", "Gnome", "Half-Elf", "Half-Orc", "Tiefling");
		 Text genderText = new Text("Gender: ");
		 genderText.setFont(getFont());
		 TextField gender = getGenericTextField();
		 newCharPane.addRow(row++, raceText, raceCombo, genderText, gender);
		 
		 Text alignment = new Text("Alignment:");
		 alignment.setFont(getFont());
		 newCharPane.addRow(row, alignment);
		 
		 GridPane innerAlignmentGP = new GridPane();
		 Text lg = new Text("Lawful Good   ");
		 lg.setFont(getFont(12));
		 Button lawfulGood = new Button("", lg);
		 Text ng = new Text("Neutral Good");
		 ng.setFont(getFont(12));
		 Button neutralGood = new Button("", ng);
		 Text cg = new Text("Chaotic Good   ");
		 cg.setFont(getFont(12));
		 Button chaoticGood = new Button("", cg);
		 innerAlignmentGP.addRow(0, lawfulGood, neutralGood, chaoticGood);
		 
		 Text ln = new Text("Lawful Neutral");
		 ln.setFont(getFont(12));
		 Button lawfulNeutral = new Button("", ln);
		 Text n = new Text("Neutral     ");
		 n.setFont(getFont(12));
		 Button neutral = new Button("", n);
		 Text cn = new Text("Chaotic Neutral");
		 cn.setFont(getFont(12));
		 Button chaoticNeutral = new Button("", cn);
		 innerAlignmentGP.addRow(1, lawfulNeutral, neutral, chaoticNeutral);
		 
		 Text le = new Text("Lawful Evil   ");
		 le.setFont(getFont(12));
		 Button lawfulEvil = new Button("", le);
		 Text ne = new Text("Neutral Evil");
		 ne.setFont(getFont(12));
		 Button neutralEvil = new Button("", ne);
		 Text ce = new Text("Chaotic Evil   ");
		 ce.setFont(getFont(12));
		 Button chaoticEvil = new Button("", ce);
		 innerAlignmentGP.addRow(2, lawfulEvil, neutralEvil, chaoticEvil);
		 newCharPane.addRow(row, innerAlignmentGP);
		 
		 Text sizeText = new Text("Size: ");
		 sizeText.setFont(getFont());
		 ArrayList<String> sizes = new ArrayList<String>();
		 ComboBox<String> size = new ComboBox<String>();
		 size.getItems().addAll("Small", "Medium", "Large");
		 newCharPane.addRow(row++, sizeText, size);
		 
		 Text hairText = new Text("Hair: ");
		 hairText.setFont(getFont());
		 TextField hair = getGenericTextField();
		 newCharPane.addRow(row, hairText, hair);
		 
		 Text ageText = new Text("Age: ");
		 ageText.setFont(getFont());
		 TextField age = getGenericTextField();
		 newCharPane.addRow(row, ageText, age);
		 
		 Text subTypeText = new Text("Subtype: ");
		 subTypeText.setFont(getFont());
		 TextField subType = getGenericTextField();		 
		 
		 ScrollPane scroll = new ScrollPane(newCharPane);
		 root.setCenter(scroll);
		 root.setTop(logo);
		 root.setAlignment(logo, Pos.CENTER);
		 root.setBottom(bottomBtnPane);
		 Scene scene = new Scene(root, WIDTH, HEIGHT);
		 return scene;
	 }
	 
	 private Font getFont() {
		 return new Font("Consolas", 20);
	 }
	 
	 private Font getFont(double size) {
		 return new Font("Consolas", size);
	 }
	 
	 private ImageView getDnDLogo() {
		 Image logo = new Image("D&D_Logo.PNG", WIDTH/2, HEIGHT/8, true, true);
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