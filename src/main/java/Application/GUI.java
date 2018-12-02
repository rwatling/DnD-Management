import java.util.Scanner;
import java.util.ArrayList;

import java.io.PrintWriter;
import java.io.FileOutputStream;
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

//import main.java.*;

public class GUI extends Application {
	 public static void main (String[] args) {
		 launch(args);
	 }
	 
	 
	 double WIDTH = 1400;
	 double HEIGHT = 840;
	 Scene startScreen;
	 Scene newCharScene;
	 Scene spellScene;
	 Stage window;
	 String namesFile = "PC_Names.txt";
	 @Override
	 public void start(Stage primaryStage) {
		 window = primaryStage;
		 
		 startScreen = createStartScreen();
		 newCharScene = createPCScreen();
		 spellScene = createSpellScreen();
		 
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
			 scan = new Scanner(new File(namesFile));
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
		 PC newPC = new PC();
		 
		 //Top------------------------------------------------------
		 ImageView logo = getDnDLogo();
		 root.setTop(logo);
		 root.setAlignment(logo, Pos.CENTER);
		 
		 //Center------------------------------------------------------
		 //Row 0
		 int row = 0;
		 GridPane newCharPane = new GridPane();
		 newCharPane.setHgap(16);
		 newCharPane.setVgap(16);
		 newCharPane.setPadding(new Insets(32, 32, 32, 32));
		 
		 Text basicInfo = new Text("Basic Information");
		 basicInfo.setFont(getFont(28));
		 newCharPane.addRow(row++, basicInfo);
		 
		 //Row 1
		 Text charNameText = new Text("Character Name: ");
		 charNameText.setFont(getFont());
		 TextField charName = getGenericTextField();
		 
		 Text levelText = new Text("Level: ");
		 levelText.setFont(getFont());
		 TextField level = getGenericTextField();
		 newCharPane.addRow(row++, charNameText, charName, levelText, level);
		 
		 //Row 2
		 Text raceText = new Text("Race: ");
		 raceText.setFont(getFont());
		 ComboBox<String> raceCombo = new ComboBox<String>();
		 String[] allRaces = newPC.getAllRaces();
		 for (int i =0; i < allRaces.length; i++) {
			 raceCombo.getItems().add(allRaces[i]);
		 }
		 
		 Text genderText = new Text("Gender: ");
		 genderText.setFont(getFont());
		 TextField gender = getGenericTextField();
		 newCharPane.addRow(row++, raceText, raceCombo, genderText, gender);
		 
		 //Row 3
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
		 
		 //Row 4
		 Text hairText = new Text("Hair: ");
		 hairText.setFont(getFont());
		 TextField hair = getGenericTextField();
		 newCharPane.addRow(row, hairText, hair);
		 
		 Text ageText = new Text("Age: ");
		 ageText.setFont(getFont());
		 TextField age = getGenericTextField();
		 newCharPane.addRow(row++, ageText, age);
		 
		 //Row 5
		 Text classTitle =   new Text("Class");
		 classTitle.setFont(getFont());
		 newCharPane.addRow(row, classTitle);
		 
		 ComboBox<String> classCombo = new ComboBox<String>();
		 String[] allClasses = newPC.getAllClasses();
		 for (int i = 0; i < allClasses.length; i++) {
			 classCombo.getItems().addAll(allClasses[i]);
		 }
		 newCharPane.addRow(row++, classCombo);
		 
		 //Row 7
		 Text abilityTitle = new Text("Ability Scores");
		 abilityTitle.setFont(getFont(28));
		 newCharPane.addRow(row++, abilityTitle);
		 
		 //Row 8 ability score selection
		 GridPane abilityPane = new GridPane();
		 abilityPane.setHgap(16);
		 abilityPane.setVgap(16);
		 
		 Text dummyText = new Text(" ");
		 Text fifteen = new Text("15");
		 fifteen.setFont(getFont());
		 Text fourteen = new Text("14");
		 fourteen.setFont(getFont());
		 Text thirteen = new Text("13");
		 thirteen.setFont(getFont());
		 Text twelve = new Text("12");
		 twelve.setFont(getFont());
		 Text ten = new Text("10");
		 ten.setFont(getFont());
		 Text eight = new Text("8");
		 eight.setFont(getFont());
		 abilityPane.addRow(0, dummyText, fifteen, fourteen, thirteen, twelve, ten, eight);
		 
		 Text str = new Text("Strength");
		 str.setFont(getFont());
		 Text dex = new Text("Dexterity");
		 dex.setFont(getFont());
		 Text con = new Text("Constution");
		 con.setFont(getFont());
		 Text intel = new Text("Intelligence");
		 intel.setFont(getFont());
		 Text wis = new Text("Wisdom");
		 wis.setFont(getFont());
		 Text cha = new Text("Charisma");
		 cha.setFont(getFont());
		 
		 ToggleGroup strToggleGroup = new ToggleGroup();
		 ToggleGroup dexToggleGroup = new ToggleGroup();
		 ToggleGroup conToggleGroup = new ToggleGroup();
		 ToggleGroup intelToggleGroup = new ToggleGroup();
		 ToggleGroup wisToggleGroup = new ToggleGroup();
		 ToggleGroup chaToggleGroup = new ToggleGroup();
		 RadioButton[][] radioButtons = new RadioButton[6][6];
		 
		 for (int i = 0; i < 6; i++) {
			 for (int j = 0; j < 6; j++) {
				 radioButtons[i][j] = new RadioButton();
				 if (i == 0) {
					 radioButtons[i][j].setToggleGroup(strToggleGroup);
				 } else if (i == 1) {
					 radioButtons[i][j].setToggleGroup(dexToggleGroup);
				 } else if (i == 2) {
					 radioButtons[i][j].setToggleGroup(conToggleGroup);
				 } else if (i == 3) {
					 radioButtons[i][j].setToggleGroup(intelToggleGroup);
				 } else if (i == 4) {
					 radioButtons[i][j].setToggleGroup(wisToggleGroup);
				 } else if (i == 5) {
					 radioButtons[i][j].setToggleGroup(chaToggleGroup);
				 }
			 }
		 }
		 
		 for (int i = 0; i < 7; i++) {
			 for (int j = 0; j < 7; j++) {
				 if (j == 0) {
					 if (i == 1) {
						 abilityPane.add(str, j, i);
					 } else if (i == 2) {
						 abilityPane.add(dex, j, i);
					 } else if (i == 3) {
						 abilityPane.add(con, j, i);
					 } else if (i == 4) {
						 abilityPane.add(intel, j, i);
					 } else if (i == 5) {
						 abilityPane.add(wis, j, i);
					 } else if (i == 6) {
						 abilityPane.add(cha, j, i);
					 }
				 } else if (i > 0 && j > 0){
					 abilityPane.add(radioButtons[i-1][j-1], j, i);
				 }
			 }
		 }
		 
		 newCharPane.addRow(row++, abilityPane);
		 
		 ScrollPane scroll = new ScrollPane(newCharPane);
		 root.setCenter(scroll);
		 
		 //Bottom-----------------------------------------------------
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
		 next.setOnAction( e -> {
			window.setScene(startScreen);
		 });
		 
		 bottomBtnPane.setLeft(back);
		 bottomBtnPane.setRight(next);		 
		 
		 root.setBottom(bottomBtnPane);
		 Scene scene = new Scene(root, WIDTH, HEIGHT);
		 return scene;
	 }
	 
	 private Scene createSpellScreen() {
		 return null;
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