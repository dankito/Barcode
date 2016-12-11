package net.dankito.barcode;

/**
 * Created by ganymed on 07/12/16.
 */

public enum BarcodeType {

  /** Aztec 2D barcode format. */
  AZTEC("Aztec"),

  /** CODABAR 1D format. */
  CODABAR("CODABAR"),

  /** Code 39 1D format. */
  CODE_39("Code 39"),

  /** Code 128 1D format. */
  CODE_128("Code 128"),

  /** Data Matrix 2D barcode format. */
  DATA_MATRIX("Data Matrix"),

  /** EAN-8 1D format. */
  EAN_8("EAN-8"),

  /** EAN-13 1D format. */
  EAN_13("EAN-13"),

  /** ITF (Interleaved Two of Five) 1D format. */
  ITF("ITF (Interleaved Two of Five)"),

  /** PDF417 format. */
  PDF_417("PDF417"),

  /** QR Code 2D barcode format. */
  QR_CODE("QR Code"),

  /** UPC-A 1D format. */
  UPC_A("UPC-A"),

  /** UPC/EAN extension format. Not a stand-alone format. */
  UPC_EAN_EXTENSION("UPC/EAN extension");


  private String name;

  BarcodeType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }


  @Override
  public String toString() {
    return getName();
  }

}
