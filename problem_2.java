package homework2;

import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;



public class problem_2  extends Application{
	
	private Button lButton, vButton, uButton;
	private FlowPane Pane;
	
	public void start(Stage primaryStage)
	{
		
		lButton = new Button("Length of word");
		lButton.setOnAction(this::processButton);

		vButton = new Button("Number of vowels");
		vButton.setOnAction(this::processButton);

		uButton = new Button("Number of uppercase letters");
		uButton.setOnAction(this::processButton);

		Pane = new FlowPane(lButton, vButton, uButton);
		Pane.setAlignment(Pos.CENTER);
		Pane.setHgap(20);
		Pane.setStyle("-fx-background-color: cyan");

		Scene scene = new Scene(new WordPane(), 500, 150);
		Scene scene1 = new Scene(Pane, 300, 150);


		primaryStage.setTitle("Word Analyzer");
		primaryStage.setScene(scene);
		primaryStage.setScene(scene1)
		primaryStage.show();
	}
	
	public class WordPane extends GridPane
	{
		private Label result;
		private TextField word;
		
		public WordPane()
		{
			Label inputLabel = new Label("Please enter a word: ");
			GridPane.setHalignment(inputLabel, HPos.RIGHT);
			
			result = new Label("---");
			GridPane.setHalignment(result, HPos.CENTER);
		
			word = new TextField();
			word.setPrefWidth(50);
			word.setAlignment(Pos.CENTER);
			word.setOnAction(this::processReturn);
			
			add(inputLabel, 0, 0);
			add(word, 1, 0);
			add(result, 1, 1);
		}
		
	public void processReturn(ActionEvent event)
		{
			String uword = word.getText();
			result.setText(uword);	
		}
	}
	
	public void processButton(ActionEvent event)
	{
		if (event.getSource () == lButton)
			Pane.setStyle("-fx-background-color: crimson");
		if (event.getSource () == vButton)
			Pane.setStyle("-fx-background-color: deepskyblue");
		else
			Pane.setStyle("-fx-background-color: crimson");
	}
}


