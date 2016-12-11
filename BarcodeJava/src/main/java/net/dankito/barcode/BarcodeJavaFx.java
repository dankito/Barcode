package net.dankito.barcode;

import net.dankito.barcode.controller.MainWindowController;
import net.dankito.barcode.localization.BarcodeJavaFxResources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by ganymed on 11/12/16.
 */

public class BarcodeJavaFx extends Application {

  private static final Logger log = LoggerFactory.getLogger(BarcodeJavaFx.class);


  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setResources(BarcodeJavaFxResources.generate());
      loader.setLocation(getClass().getClassLoader().getResource("dialogs/MainWindow.fxml"));
      Parent root = (Parent)loader.load();

      Scene scene = new Scene(root);

      stage.setScene(scene);

      MainWindowController controller = (MainWindowController)loader.getController();
      controller.setStage(stage);

      stage.show();

    } catch(Exception ex) {
      log.error("Could not start MainWindow", ex);
    }
  }

  @Override
  public void stop() throws Exception {
    super.stop();
    System.exit(0);
  }

}
