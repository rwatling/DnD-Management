import java.util.Scanner;
import java.util.ArrayList;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
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
	 PC newPC = null;
	 @Override
	 public void start(Stage primaryStage) {
		 window = primaryStage;
		 
		 startScreen = createStartScreen();
		 newCharScene = createPCScreen(null); 
		 
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
	 
	 private Scene createPCScreen(PC character) {
		 BorderPane root = new BorderPane();
		 if (character == null) {
			 newPC = new PC();
		 } else {
			 newPC = character;
		 }
		 
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
		 
		 //Character Name and Level
		 Text charNameText = new Text("Character Name: ");
		 charNameText.setFont(getFont());
		 TextField charName = getGenericTextField();
		 if (newPC.getName() != null) {
			 charName.setText(newPC.getName());
			 charName.setDisable(true);
		 }
		 charName.setOnAction(e -> {
			 String name = charName.getText();
			 if (!name.isEmpty()) {
				 newPC.setName(name);
				 charName.setDisable(true);
				 
				 PrintWriter pw = null;
				 try {
					 pw = new PrintWriter(new FileOutputStream(new File(namesFile), true)); //true to append
					 pw.println(name);
					 pw.close();
				 } catch (FileNotFoundException ex) {
					 ex.printStackTrace();
				 }
			 }
		 });		 
		 
		 Text levelText = new Text("Level: ");
		 levelText.setFont(getFont());
		 TextField level = getGenericTextField();
		 level.setText("1");
		 level.setEditable(false);
		 newCharPane.addRow(row++, charNameText, charName, levelText, level);
		 
		 //Race and Gender
		 Text raceText = new Text("Race: ");
		 raceText.setFont(getFont());
		 ComboBox<String> raceCombo = new ComboBox<String>();
		 String[] allRaces = newPC.getAllRaces();
		 for (int i =0; i < allRaces.length; i++) {
			 raceCombo.getItems().add(allRaces[i]);
		 }
		 raceCombo.setPrefSize(WIDTH/4, 16);
		 raceCombo.setOnAction(e -> {
			 newPC.setRace(raceCombo.getValue());
			 
			 ArrayList<String> languages = newPC.getLanguages();
			 for (int i = 0; i < languages.size(); i++) {
				 Text langText = new Text(languages.get(i));
				 Text langSpace = new Text(" ");
			 }
			 refresh();
		 });
		 if (newPC.pcRace != null) {
			 raceCombo.setValue(newPC.getRaceTitle());
		 }
		 
		 Text genderText = new Text("Gender: ");
		 genderText.setFont(getFont());
		 TextField gender = getGenericTextField();
		 gender.setOnAction(e -> {
			 newPC.setGender(gender.getText());
		 });
		 if (newPC.getGender() != null) {
			 gender.setText(newPC.getGender());
		 }
		 newCharPane.addRow(row++, raceText, raceCombo, genderText, gender);
		 
		 //Alignment
		 Text alignment = new Text("Alignment:");
		 alignment.setFont(getFont());
		 newCharPane.addRow(row, alignment);
		 
		 GridPane innerAlignmentGP = new GridPane();
		 Text lg = new Text("Lawful Good");
		 lg.setFont(getFont(12));
		 Button lawfulGood = new Button("", lg);
		 lawfulGood.setOnAction(e -> {
			 newPC.setAlignment(lg.getText());
		 });
		 
		 Text ng = new Text("Neutral Good");
		 ng.setFont(getFont(12));
		 Button neutralGood = new Button("", ng);
		 neutralGood.setOnAction(e -> {
			 newPC.setAlignment(ng.getText());
		 });
		 
		 Text cg = new Text("Chaotic Good");
		 cg.setFont(getFont(12));
		 Button chaoticGood = new Button("", cg);
		 chaoticGood.setOnAction(e -> {
			 newPC.setAlignment(cg.getText());
		 });
		 innerAlignmentGP.addRow(0, lawfulGood, neutralGood, chaoticGood);
		 //--------------------------------------------------------------------------
		 
		 Text ln = new Text("Lawful Neutral");
		 ln.setFont(getFont(12));
		 Button lawfulNeutral = new Button("", ln);
		 lawfulNeutral.setOnAction(e -> {
			 newPC.setAlignment(ln.getText());
		 });
		 
		 Text n = new Text("Neutral");
		 n.setFont(getFont(12));
		 Button neutral = new Button("", n);
		 neutral.setOnAction(e -> {
			 newPC.setAlignment(n.getText());
		 });
		 
		 Text cn = new Text("Chaotic Neutral");
		 cn.setFont(getFont(12));
		 Button chaoticNeutral = new Button("", cn);
		 chaoticNeutral.setOnAction(e -> {
			 newPC.setAlignment(cn.getText());
		 });
		 innerAlignmentGP.addRow(1, lawfulNeutral, neutral, chaoticNeutral);
		 //--------------------------------------------------------------------------
		 
		 Text le = new Text("Lawful Evil");
		 le.setFont(getFont(12));
		 Button lawfulEvil = new Button("", le);
		 lawfulEvil.setOnAction(e -> {
			 newPC.setAlignment(le.getText());
		 });
		 
		 Text ne = new Text("Neutral Evil");
		 ne.setFont(getFont(12));
		 Button neutralEvil = new Button("", ne);
		 neutralEvil.setOnAction(e -> {
			 newPC.setAlignment(ne.getText());
		 });
		 
		 Text ce = new Text("Chaotic Evil");
		 ce.setFont(getFont(12));
		 Button chaoticEvil = new Button("", ce);
		 chaoticEvil.setOnAction(e -> {
			 newPC.setAlignment(ce.getText());
		 });
		 innerAlignmentGP.addRow(2, lawfulEvil, neutralEvil, chaoticEvil);
		 newCharPane.addRow(row, innerAlignmentGP);
		 
		 //Size
		 Text sizeText = new Text("Size: ");
		 sizeText.setFont(getFont());
		 ArrayList<String> sizes = new ArrayList<String>();
		 ComboBox<String> size = new ComboBox<String>();
		 size.getItems().addAll("Small", "Medium", "Large");
		 size.setPrefSize(WIDTH/4, 16);
		 size.setOnAction(e -> {
			 newPC.setSize(size.getValue());
		 });
		 if (newPC.getSize() != null) {
			 size.setValue(newPC.getSize());
		 }
		 newCharPane.addRow(row++, sizeText, size);
		 
		 //Hair and Age
		 Text hairText = new Text("Hair: ");
		 hairText.setFont(getFont());
		 TextField hair = getGenericTextField();
		 hair.setOnAction( e -> {
			 newPC.setHair(hair.getText());
		 });
		 if (newPC.getHair() != null) {
			 hair.setText(newPC.getHair());
		 }
		 
		 newCharPane.addRow(row, hairText, hair);
		 
		 Text ageText = new Text("Age: ");
		 ageText.setFont(getFont());
		 TextField age = getGenericTextField();
		 age.setOnAction( e -> {
			 newPC.setAge(age.getText());
		 });
		 if (newPC.getAge() != 0) {
			 age.setText(""+newPC.getAge());
		 }
		 newCharPane.addRow(row++, ageText, age);
		 
		 //Class and Background
		 Text classTitle = new Text("Class");
		 classTitle.setFont(getFont());
		 newCharPane.addRow(row, classTitle);
		 
		 ComboBox<String> classCombo = new ComboBox<String>();
		 String[] allClasses = newPC.getAllClasses();
		 for (int i = 0; i < allClasses.length; i++) {
			 classCombo.getItems().addAll(allClasses[i]);
		 }
		 classCombo.setPrefSize(WIDTH/4, 16);
		 classCombo.setOnAction(e -> {
			 newPC.setClass(classCombo.getValue());
			 refresh();
		 });
		 
		 if (newPC.pcClass != null) {
			 classCombo.setValue(newPC.getClassTitle());
		 }
		 newCharPane.addRow(row, classCombo);
		 
		 Text backgroundText = new Text("Background");
		 backgroundText.setFont(getFont());
		 ComboBox<String> backgroundCombo = new ComboBox<String>();
		 String[] allBackgrounds = newPC.getAllBackgrounds();
		 for (int i = 0; i < allBackgrounds.length; i++) {
			 backgroundCombo.getItems().addAll(allBackgrounds[i]);
		 }
		 backgroundCombo.setPrefSize(WIDTH/4, 16);
		 backgroundCombo.setOnAction(e -> {
			newPC.setBackground(backgroundCombo.getValue());
			refresh();
		 });
		 
		 if (newPC.pcBackground != null) {
			 backgroundCombo.setValue(newPC.getBackgroundTitle());
		 }
		 newCharPane.addRow(row++, backgroundText, backgroundCombo);
		 
		 //Spacer
		 Text spacer1 = getRowSpacer();
		 newCharPane.addRow(row++, spacer1);
		 
		 //Ability Scores and Saving Throws Titles
		 Text abilityTitle = new Text("Ability Scores");
		 abilityTitle.setFont(getFont(28));
		 
		 Text spacer5 = getRowSpacer();	//Not actually a row spacer but a column spacer
		 
		 Text savingTitle = new Text("Saving Throw");
		 savingTitle.setFont(getFont(28));
		 newCharPane.addRow(row++, abilityTitle, spacer5, savingTitle);
		 
		 //Ability Scores and Saving Throws
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
		 RadioButton[][] abilityRadioButtons = new RadioButton[6][6];
		 
		 for (int i = 0; i < 6; i++) {
			 for (int j = 0; j < 6; j++) {
				 abilityRadioButtons[i][j] = new RadioButton();
				 if (i == 0) {
					 abilityRadioButtons[i][j].setToggleGroup(strToggleGroup);
				 } else if (i == 1) {
					 abilityRadioButtons[i][j].setToggleGroup(dexToggleGroup);
				 } else if (i == 2) {
					 abilityRadioButtons[i][j].setToggleGroup(conToggleGroup);
				 } else if (i == 3) {
					 abilityRadioButtons[i][j].setToggleGroup(intelToggleGroup);
				 } else if (i == 4) {
					 abilityRadioButtons[i][j].setToggleGroup(wisToggleGroup);
				 } else if (i == 5) {
					 abilityRadioButtons[i][j].setToggleGroup(chaToggleGroup);
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
					 abilityPane.add(abilityRadioButtons[i-1][j-1], j, i);
				 }
			 }
		 }
		 
		 GridPane savingPane = new GridPane();
		 savingPane.setHgap(16);
		 savingPane.setVgap(16);
		 Text savingThrowDirections = new Text("(Check if proficient)");
		 savingThrowDirections.setFont(getFont(16));
		 savingPane.addRow(0, savingThrowDirections);
		 
		 String[] allSavingThrows = newPC.getAllSavingThrows();
		 ArrayList<CheckBox> savingThrowCheckBoxes = new ArrayList<>();
		 for (int i = 0; i < allSavingThrows.length; i++) {
			 Text t = new Text(allSavingThrows[i]);
			 t.setFont(getFont());
			 CheckBox cb = new CheckBox();
			 cb.setOnAction(e-> {
				 newPC.setSavingThrowProficiency(t.getText(), cb.isSelected());
			 });
			 savingThrowCheckBoxes.add(cb);
			 savingPane.addRow(i+1, t, cb);
		 }
		 Text spacer4 = getRowSpacer();
		 newCharPane.addRow(row++, abilityPane, spacer4, savingPane);
		 
		 //Spacer
		 Text spacer3 = getRowSpacer();
		 newCharPane.addRow(row++, spacer3);
		 
		 //Skills Title
		 Text skillsHeader = new Text("Skill Proficiency");
		 skillsHeader.setFont(getFont(28));
		 newCharPane.addRow(row++, skillsHeader);
		 
		 //Skills
		 String[] allSkills = newPC.getAllSkills();
		 ArrayList<CheckBox> skillCheckBoxes = new ArrayList<>();
		 for (int i = 0; i < allSkills.length; i++) {
			 Text skill = new Text(allSkills[i]);
			 skill.setFont(getFont());
			 CheckBox cb = new CheckBox();
			 cb.setOnAction(e -> {
				 newPC.setSkillProficiency(skill.getText(), cb.isSelected());
			 });
			 skillCheckBoxes.add(cb);
			 newCharPane.addRow(row++, skill, cb);
		 }
		 
		 int backToBottom = row; //We reset the row after we add the languages
		 row -= allSkills.length + 1;
		 
		 //Languages Title
		 Text languagesTitle = new Text("Languages");
		 languagesTitle.setFont(getFont(28));
		 Text spacer6 = getRowSpacer();
		 newCharPane.addRow(row++, spacer6, languagesTitle);
		 
		 //Add Languages
		 ArrayList<String> languages = newPC.getLanguages();
		 for (int i = 0; i < languages.size(); i++) {
			 Text langText = new Text(languages.get(i));
			 langText.setFont(getFont());
			 newCharPane.addRow(row++, langText);
		 }
		 
		 Text langDirections = new Text("Add other languages as a comma separated list");
		 langDirections.setFont(getFont(16));
		 newCharPane.addRow(row++, langDirections);
		 
		 
		 TextField addMoreLangs = getGenericTextField();
		 addMoreLangs.setOnAction(e -> {
			 Scanner scan = new Scanner(addMoreLangs.getText());
			 scan.useDelimiter(",");
			 while (scan.hasNext()) {
				 String s = scan.next();
				 s = s.replaceAll(" ", "");
				 newPC.addLanguage(s);
			 }
			 refresh();
		 });
		 newCharPane.addRow(row++, addMoreLangs);
		 
		//reset
		 row = backToBottom;
		 row++;	//spacer
		 
		 // Weapons and Armor
		 Text weaponArmorTitle = new Text("Weapon and Armor");
		 weaponArmorTitle.setFont(getFont(28));
		 newCharPane.addRow(row++, weaponArmorTitle);
		 
		 ArrayList<String> weaponArmorProfs = newPC.getProficiencies();
		 for (int i = 0; i < weaponArmorProfs.size(); i++) {
			 Text t = new Text(weaponArmorProfs.get(i));
			 t.setFont(getFont());
			 newCharPane.addRow(row++, t);
		 }
		 
		 Text weaponArmorDirections = new Text("Add other weapon/armor proficiencies as a comma separated list");
		 langDirections.setFont(getFont(16));;
		 newCharPane.addRow(row++, weaponArmorDirections);
		 
		 TextField addMoreProfs = getGenericTextField();
		 addMoreProfs.setOnAction(e -> {
			 Scanner scan = new Scanner(addMoreProfs.getText());
			 scan.useDelimiter(",");
			 while (scan.hasNext()) {
				 String s = scan.next();
				 s = s.replaceAll(" ", "");
				 newPC.addWeaponArmorProfs(s);
			 }
			 refresh();
		 });
		 newCharPane.addRow(row++, addMoreProfs);
		 
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
			 try {
				spellScene = createSpellScreen(newPC);
				window.setScene(spellScene);
			 } catch (NullPointerException ex) {
				 System.out.println("Character not finished");
			 }
		 });
		 
		 bottomBtnPane.setLeft(back);
		 bottomBtnPane.setRight(next);	
		 
		 root.setBottom(bottomBtnPane);
		 Scene scene = new Scene(root, WIDTH, HEIGHT);
		 return scene;
	 }
	 
	 private void refresh() {
		 newCharScene = createPCScreen(newPC);
		 window.setScene(newCharScene);
	 }
	 
	 private Scene createSpellScreen(PC newPC) {
		 BorderPane root = new BorderPane();
		 
		 //Top------------------------------------------------------
		 ImageView logo = getDnDLogo();
		 root.setTop(logo);
		 root.setAlignment(logo, Pos.CENTER);
		 
		 //Center------------------------------------------------------
		 //Row 0
		 int row = 0;
		 GridPane spellPane = new GridPane();
		 spellPane.setHgap(16);
	   	 spellPane.setVgap(16);
		 spellPane.setPadding(new Insets(32, 32, 32, 32));
		 
		 Text className = new Text("Class: " + newPC.getClassTitle());
		 className.setFont(getFont(28));
		 spellPane.addRow(row++, className);
		 //Row 1
		 int numCantrips = 0;
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Druid" || newPC.getClassTitle() == "Warlock") {
			numCantrips = 2;
		 }
		 else if (newPC.getClassTitle() == "Cleric" || newPC.getClassTitle() == "Wizard") {
			numCantrips = 3;
		 }
		 else if (newPC.getClassTitle() == "Sorcerer") {
			numCantrips = 4;
		 }
		 Text cantrips = new Text("Cantrips: choose " + numCantrips);
		 cantrips.setFont(getFont(24));
		 spellPane.addRow(row++, cantrips);
		 
		 //Row 2
		 GridPane cantripPane = new GridPane();
		 cantripPane.setHgap(16);
		 cantripPane.setVgap(16);
		 int cantripCount = 0;
		 
		 if (newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Wizard") {
			Text acidSplash = new Text("Acid Splash ");
			acidSplash.setFont(getFont(20));
			cantripPane.add(acidSplash, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Warlock" || newPC.getClassTitle() == "Wizard") {
			Text bladeWard = new Text("Blade Ward ");
			bladeWard.setFont(getFont(20));
			cantripPane.add(bladeWard, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Warlock" || newPC.getClassTitle() == "Wizard") {
			Text chillTouch = new Text("Chill Touch ");
			chillTouch.setFont(getFont(20));
			cantripPane.add(chillTouch, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Wizard") {
			Text dancingLights = new Text("Dancing Lights ");
			dancingLights.setFont(getFont(20));
			cantripPane.add(dancingLights, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Druid") {
			Text druidcraft = new Text("Druidcraft ");
			druidcraft.setFont(getFont(20));
			cantripPane.add(druidcraft, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Warlock") {
			Text eldritchBlast = new Text("Eldritch Blast ");
			eldritchBlast.setFont(getFont(20));
			cantripPane.add(eldritchBlast, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Wizard") {
			Text fireBolt = new Text("Fire Bolt ");
			fireBolt.setFont(getFont(20));
			cantripPane.add(fireBolt, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Warlock" || newPC.getClassTitle() == "Wizard") {
			Text friends = new Text("Friends ");
			friends.setFont(getFont(20));
			cantripPane.add(friends, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Cleric" || newPC.getClassTitle() == "Druid") {
			Text guidance = new Text("Guidance ");
			guidance.setFont(getFont(20));
			cantripPane.add(guidance, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Cleric" || newPC.getClassTitle() == "Sorcerer" ||  newPC.getClassTitle() == "Wizard") {
			Text light = new Text("Light ");
			light.setFont(getFont(20));
			cantripPane.add(light, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Warlock" || newPC.getClassTitle() == "Wizard") {
			Text mageHand = new Text("Mage Hand ");
			mageHand.setFont(getFont(20));
			cantripPane.add(mageHand, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Cleric" || newPC.getClassTitle() == "Druid" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Wizard") {
			Text mending = new Text("Mending ");
			mending.setFont(getFont(20));
			cantripPane.add(mending, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Wizard") {
			Text message = new Text("Message ");
			message.setFont(getFont(20));
			cantripPane.add(message, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Warlock" || newPC.getClassTitle() == "Wizard") {
			Text minorIllusion = new Text("Minor Illusion ");
			minorIllusion.setFont(getFont(20));
			cantripPane.add(minorIllusion, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Druid" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Warlock" || newPC.getClassTitle() == "Wizard") {
			Text poisonSpray = new Text("Poison Spray ");
			poisonSpray.setFont(getFont(20));
			cantripPane.add(poisonSpray, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Warlock" || newPC.getClassTitle() == "Wizard") {
			Text prestidigitation = new Text("Prestidigitation ");
			prestidigitation.setFont(getFont(20));
			cantripPane.add(prestidigitation, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Druid") {
			Text produceFlame = new Text("Produce Flame ");
			produceFlame.setFont(getFont(20));
			cantripPane.add(produceFlame, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Wizard") {
			Text rayOfFrost = new Text("Ray of Frost ");
			rayOfFrost.setFont(getFont(20));
			cantripPane.add(rayOfFrost, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Cleric" || newPC.getClassTitle() == "Druid") {
			Text resistance = new Text("Resistance ");
			resistance.setFont(getFont(20));
			cantripPane.add(resistance, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Cleric") {
			Text sacredFlame = new Text("Sacred Flame ");
			sacredFlame.setFont(getFont(20));
			cantripPane.add(sacredFlame, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Druid") {
			Text shillelagh = new Text("Shillelagh ");
			shillelagh.setFont(getFont(20));
			cantripPane.add(shillelagh, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Wizard") {
			Text shockingGrasp = new Text("Shocking Grasp ");
			shockingGrasp.setFont(getFont(20));
			cantripPane.add(shockingGrasp, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Cleric") {
			Text spareTheDying = new Text("Spare the Dying ");
			spareTheDying.setFont(getFont(20));
			cantripPane.add(spareTheDying, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Cleric") {
			Text thaumaturgy = new Text("Thaumaturgy ");
			thaumaturgy.setFont(getFont(20));
			cantripPane.add(thaumaturgy, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Druid") {
			Text thornWhip = new Text("Thorn Whip ");
			thornWhip.setFont(getFont(20));
			cantripPane.add(thornWhip, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard" || newPC.getClassTitle() == "Sorcerer" || newPC.getClassTitle() == "Warlock" || newPC.getClassTitle() == "Wizard") {
			Text trueStrike = new Text("True Strike ");
			trueStrike.setFont(getFont(20));
			cantripPane.add(trueStrike, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 if (newPC.getClassTitle() == "Bard") {
			Text viciousMockery = new Text("Vicious Mockery ");
			viciousMockery.setFont(getFont(20));
			cantripPane.add(viciousMockery, cantripCount++, 0);
			
			RadioButton btn = new RadioButton();
			cantripPane.add(btn, cantripCount++, 0);
		 }
		 
		 spellPane.addRow(row++, cantripPane);
		 //Row 3
		 int numSpells = 0;
		 if (newPC.getClassTitle() == "Bard") {
			numSpells = 4;
		 }
		 else {
			 numSpells = 2;
		 }
		 Text spells = new Text("Spells: choose " + numSpells);
		 spells.setFont(getFont(24));
		 spellPane.addRow(row++, spells);
		 
		 
		 ScrollPane scroll = new ScrollPane(spellPane);
		 root.setCenter(scroll);
		 
		 //Bottom-----------------------------------------------------
		 BorderPane bottomBtnPane = new BorderPane();
		 
		 Text backText = new Text("<- Back");
		 backText.setFont(getFont());
		 Button back = new Button("", backText);
		 back.setOnAction(e -> {
			window.setScene(newCharScene);
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
	 
	 private Text getRowSpacer() {
		 Text temp = new Text(" ");
		 temp.setFont(getFont());
		 return temp;
	 }
 }