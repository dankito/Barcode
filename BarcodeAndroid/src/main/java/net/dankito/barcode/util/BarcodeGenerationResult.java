package net.dankito.barcode.util;

import android.graphics.Bitmap;

/**
 * Created by ganymed on 07/12/16.
 */

public class BarcodeGenerationResult {

  protected boolean isSuccessful;

  protected String error;

  protected Bitmap generatedBarcode;


  public BarcodeGenerationResult(String error) {
    this.error = error;
    this.isSuccessful = false;
  }

  public BarcodeGenerationResult(Bitmap generatedBarcode) {
    this.generatedBarcode = generatedBarcode;
    this.isSuccessful = true;
  }


  public boolean isSuccessful() {
    return isSuccessful;
  }

  public String getError() {
    return error;
  }

  public Bitmap getGeneratedBarcode() {
    return generatedBarcode;
  }


  @Override
  public String toString() {
    return "Is successful? " + isSuccessful();
  }

}
