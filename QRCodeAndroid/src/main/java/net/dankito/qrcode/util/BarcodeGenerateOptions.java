package net.dankito.qrcode.util;

/**
 * Created by ganymed on 07/12/16.
 */

public class BarcodeGenerateOptions {

  public static final int DEFAULT_IMAGE_HEIGHT = 500;

  public static final int DEFAULT_IMAGE_WIDTH = 500;


  protected String textToEncode;

  protected BarcodeType barcodeType;

  protected int imageWidth = DEFAULT_IMAGE_WIDTH;

  protected int imageHeight = DEFAULT_IMAGE_HEIGHT;


  public BarcodeGenerateOptions(String textToEncode, BarcodeType barcodeType) {
    this(textToEncode, barcodeType, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
  }

  public BarcodeGenerateOptions(String textToEncode, BarcodeType barcodeType, int imageWidth, int imageHeight) {
    this.textToEncode = textToEncode;
    this.barcodeType = barcodeType;
    this.imageWidth = imageWidth;
    this.imageHeight = imageHeight;
  }


  public String getTextToEncode() {
    return textToEncode;
  }

  public void setTextToEncode(String textToEncode) {
    this.textToEncode = textToEncode;
  }

  public BarcodeType getBarcodeType() {
    return barcodeType;
  }

  public void setBarcodeType(BarcodeType barcodeType) {
    this.barcodeType = barcodeType;
  }

  public int getImageWidth() {
    return imageWidth;
  }

  public void setImageWidth(int imageWidth) {
    this.imageWidth = imageWidth;
  }

  public int getImageHeight() {
    return imageHeight;
  }

  public void setImageHeight(int imageHeight) {
    this.imageHeight = imageHeight;
  }


  @Override
  public String toString() {
    return getBarcodeType() + " from " + getTextToEncode();
  }

}
