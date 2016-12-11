package net.dankito.barcode;

/**
 * Created by ganymed on 07/12/16.
 */

public class BarcodeGenerationResult {

  protected boolean isSuccessful;

  protected String error;

  protected Object generatedBarcode;


  public BarcodeGenerationResult(String error) {
    this.error = error;
    this.isSuccessful = false;
  }

  public BarcodeGenerationResult(Object generatedBarcode) {
    this.generatedBarcode = generatedBarcode;
    this.isSuccessful = true;
  }


  public boolean isSuccessful() {
    return isSuccessful;
  }

  public String getError() {
    return error;
  }

  public Object getGeneratedBarcode() {
    return generatedBarcode;
  }


  @Override
  public String toString() {
    return "Is successful? " + isSuccessful();
  }

}
