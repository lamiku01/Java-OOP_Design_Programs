package Homework4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.NumberFormat;

public class problem2 extends Application{
	
	GridPane grid;
	Label lblMessage, lblTip, lblResult;
	TextField txtAmount;
	RadioButton b0,b15,b18,b20;
	ToggleGroup group;
	Button calculate;
	double amount = 0, tip = 0, salesTax = 0, billAmount = 0;
	final double SALES_TAX = 0.08;
	
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	
	public void start(Stage primaryStage) {
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(15);
		grid.setVgap(15);
		
		lblMessage = new Label("Please enter food charge: ");
		txtAmount = new TextField();
		txtAmount.setMaxWidth(60);
		grid.add(lblMessage, 0, 0);
		grid.add(txtAmount, 1, 0);
		
		lblTip = new Label("Please select tip amount: ");
		grid.add(lblTip,0,1);
		
		b0 = new RadioButton("0%");
		b15 = new RadioButton("15%");
		b18 = new RadioButton("18%");
		b20 = new RadioButton("20%");
		
		group = new ToggleGroup();
		b0.setToggleGroup(group);
		b15.setToggleGroup(group);
		b18.setToggleGroup(group);
		b20.setToggleGroup(group);
		grid.add(b0, 0, 2);
		grid.add(b15, 1, 2);
		grid.add(b18, 2, 2);
		grid.add(b20, 3, 2);
		
		calculate = new Button("Calculate");
		grid.add(calculate, 1, 3);
		
		lblResult = new Label();
		grid.add(lblResult, 1, 4);
		
		primaryStage.setTitle("Bill Calculator");
		grid.setStyle("-fx-background-color: lavender");
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.setWidth(510);
		primaryStage.setHeight(310);
		primaryStage.show();
		
		calculate.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				amount = Double.parseDouble(txtAmount.getText());
				if(b0.isSelected())
					tip = 0;
				else if (b15.isSelected())
					tip = .15;
				else if (b18.isSelected())
					tip = .18;
				else if (b20.isSelected())
					tip = .20;
				
				tip = amount*tip;
				salesTax = amount*SALES_TAX;
				billAmount = amount + tip + salesTax;
				
				String result = "Total food charge: " + fmt.format(amount) + "\nTip Amount: " +fmt.format(tip) + "\nSales Tax: " + fmt.format(salesTax) + "\nTotal Bill Amount: " + fmt.format(billAmount);
				lblResult.setText(result);
			}
		});
	}
	public static void main(String[] args) {
		
		launch(args);
		
	}
}
