package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader= new FXMLLoader(getClass().getResource("/telas/tela.fxml"));
		System.out.println(getClass().getResource("/telas/tela.fxml"));
		Parent root = loader.load();
		
		primaryStage.setTitle("Calculadora - MVC(JavaFX + FXML)");
		Scene scene = new Scene(root, 320, 480);
		
				
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
			
			
			
	}
		
	
	public static void main(String[] args) {
		launch(args);
	}
}
