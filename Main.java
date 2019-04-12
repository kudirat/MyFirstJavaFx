/**
 * Filename:   Main.java
 * Project:    MyFirstJavaFx    
 * Authors:    Kudirat Alimi Lecture 004
 *
 * Semester:   Spring 2019
 * Course:     CS400
 * 
 * Due Date:   04/12/19
 * Version:    1.0
 * 
 * Credits:    N/A
 * 
 * Bugs:       TODO: Done button and ComboBox isn't programmed to do anything. No bugs but a side note. 
 */

package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.scene.media.*;


public class Main extends Application {
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			//layout that will be used to place UI elements and items
			BorderPane root = new BorderPane();
			
			//setTop - label will be added to roots top
			Label greetingLabel = new Label("CS400 MyFirstJavaFX");
			root.setTop(greetingLabel);
			//greetingLabel.
			
			//setBottom - the 'Done!' button will be added to the roots bottom
			Button bottomButton = new Button("Done!");
			root.setBottom(bottomButton);
			
			//setCenter - the imageView will be added to the root's center, and we'll be able to view an image			
			ImageView myPic = new ImageView (new Image ("p5pic.jpg")); //add quotations
			
			//myPic.setRotate(90); //commented out in case I need it

			//commands used to adjust the size of the image
			myPic.setFitHeight(300);
			myPic.setFitWidth(300);
			
			//myPic.setPreserveRatio(true); //no need to preserve ratio as of now
			
			root.setCenter(myPic);
			
			//setLeft - sets the roots left with a comboBox that shows a selection of Strings
			ComboBox<String> newComboBox = new ComboBox<>();
			newComboBox.getItems().addAll(
					"I came to America by winning a lottery",
					"I was raised in NYC and Nigeria",
					"I can speak English, Yoruba, and a bit of Japanese and Spanish.");
			
			//sets the text of the comboBox
			newComboBox.setPromptText("Fun Facts About Me!");
			root.setLeft(newComboBox);
		
			
			//setRight - sets roots right with a media player that will play a string of funny Panda Cheese commercials
			Media myMedia = new Media(new File("C:/Users/deepl/Videos/pandacheese.mp4").toURI().toString());
		
			MediaPlayer newPlayer = new MediaPlayer(myMedia);
			//will automatically play the video once program is ran
			newPlayer.setAutoPlay(true);
			MediaView mediaView = new MediaView(newPlayer);
		
			newPlayer.play();
			root.setRight(mediaView);
			//root.setRight(newPlayer);
			
			//this is creating a new scene with the root as well ratios. 
			Scene scene = new Scene(root,800,800);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Kudirat's First JavaFX program");
			primaryStage.show();
			
			//These fields haven't been used in my program
//			TextField textField = new TextField();
//			TextArea newArea = new TextArea();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
