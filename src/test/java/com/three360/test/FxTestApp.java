package com.three360.test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

// TODO log on debug mode
public class FxTestApp extends Application {

	public final Logger logger = Logger.getLogger(FixAtdlGeneratorManualTestApp.class);

	private Spinner<Double> doubleSpinner = new Spinner<>();

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(gridTest());
		primaryStage.setTitle("FX8 Atdl Generator Test Interface");
		primaryStage.show();
	}

	private Scene getTestBaseScene() {
		HBox hBox = new HBox();
		doubleSpinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(FXCollections.observableArrayList(0.0, 0.1)));
		hBox.getChildren().add(doubleSpinner);
		Scene scene = new Scene(hBox, 500, 500);
		return scene;
	}

	private Scene gridTest() {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(20);
		gridPane.add(new Label("dddd"), 0, 0, GridPane.REMAINING, 1);
		gridPane.add(new TextField("xxxx"), 0, 1, GridPane.REMAINING, 1);
		Scene scene = new Scene(gridPane, 500, 500);
		return scene;
	}

	public static void main(String[] args) throws Exception {
		launch(args);

	}
}
