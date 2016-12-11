package net.dankito.barcode.controller;

import net.dankito.barcode.BarcodeGenerateOptions;
import net.dankito.barcode.BarcodeGenerationResult;
import net.dankito.barcode.BarcodeGenerator;
import net.dankito.barcode.BarcodeGeneratorJava;
import net.dankito.barcode.BarcodeType;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author cdankl
 */
public class MainWindowController implements Initializable {


  protected BarcodeGenerator barcodeGenerator = new BarcodeGeneratorJava();


  protected Stage stage = null;



  @FXML
  GridPane grdpnMainMenu;


  @FXML
  protected Tab tabGenerate;

  @FXML
  protected TextField txtfldTextToEncode;

  @FXML
  protected Button btnGenerateBarcode;

  @FXML
  protected ImageView imgvwGeneratedBarcode;


  @FXML
  protected Tab tabRead;



  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }

  protected void setupControls() {

  }

  protected void setupMainMenu() {

  }

  public void setStage(Stage stage) {
    this.stage = stage;


  }


  @FXML
  protected void handleMenuItemFileCloseAction(ActionEvent event) {
    stage.close();
  }

  @FXML
  protected void handleButtonGenerateBarcode(ActionEvent event) {
    BarcodeGenerateOptions options = new BarcodeGenerateOptions(txtfldTextToEncode.getText(), BarcodeType.QR_CODE);
    BarcodeGenerationResult result = barcodeGenerator.generateQRCode(options);

    if(result.isSuccessful()) {
      Image image = (Image) result.getGeneratedBarcode();
      imgvwGeneratedBarcode.setImage(image);
    }
  }

}
