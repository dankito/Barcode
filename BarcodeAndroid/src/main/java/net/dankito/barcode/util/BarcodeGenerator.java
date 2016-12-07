package net.dankito.barcode.util;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEANWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by ganymed on 06/12/16.
 */

public class BarcodeGenerator {

  public BarcodeGenerationResult generateQRCode(BarcodeGenerateOptions options) {
    try {
      BarcodeFormat barcodeFormat = getBarcodeFormat(options);
      Writer writer = createWriter(barcodeFormat);
      Map<EncodeHintType, Object> hintMap = generateHints(options);

      BitMatrix matrix = writer.encode(options.getTextToEncode(), barcodeFormat, options.getImageWidth(), options.getImageHeight(), hintMap);

      Bitmap bitmap = Bitmap.createBitmap(options.getImageWidth(), options.getImageWidth(), Bitmap.Config.RGB_565);
      for (int x = 0; x < options.getImageWidth(); x++){
        for (int y = 0; y < options.getImageHeight(); y++){
          bitmap.setPixel(x, y, matrix.get(x,y) ? Color.BLACK : Color.WHITE);
        }
      }

      return new BarcodeGenerationResult(bitmap);
    } catch (Exception e) {
      return new BarcodeGenerationResult(e.getLocalizedMessage());
    }
  }

  protected Writer createWriter(BarcodeFormat barcodeFormat) {
    switch(barcodeFormat) {
      case AZTEC:
        return new AztecWriter();
      case CODABAR:
        return new CodaBarWriter();
      case CODE_39:
        return new Code39Writer();
      case CODE_128:
        return new Code128Writer();
      case DATA_MATRIX:
        return new DataMatrixWriter();
      case EAN_8:
        return new EAN8Writer();
      case EAN_13:
        return new EAN13Writer();
      case ITF:
        return new ITFWriter();
      case PDF_417:
        return new PDF417Writer();
      case QR_CODE:
        return new QRCodeWriter();
      case UPC_A:
        return new UPCAWriter();
      case UPC_EAN_EXTENSION:
        return new UPCEANWriter() {
          @Override
          public boolean[] encode(String contents) {
            return new boolean[0];
          }
        };
    }

    return null;
  }

  protected BarcodeFormat getBarcodeFormat(BarcodeGenerateOptions options) {
    switch(options.getBarcodeType()) {
      case AZTEC:
        return BarcodeFormat.AZTEC;
      case CODABAR:
        return BarcodeFormat.CODABAR;
      case CODE_39:
        return BarcodeFormat.CODE_39;
      case CODE_128:
        return BarcodeFormat.CODE_128;
      case DATA_MATRIX:
        return BarcodeFormat.DATA_MATRIX;
      case EAN_8:
        return BarcodeFormat.EAN_8;
      case EAN_13:
        return BarcodeFormat.EAN_13;
      case ITF:
        return BarcodeFormat.ITF;
      case PDF_417:
        return BarcodeFormat.PDF_417;
      case QR_CODE:
        return BarcodeFormat.QR_CODE;
      case UPC_A:
        return BarcodeFormat.UPC_A;
      case UPC_EAN_EXTENSION:
        return BarcodeFormat.UPC_EAN_EXTENSION;
    }

    return null;
  }

  protected Map<EncodeHintType, Object> generateHints(BarcodeGenerateOptions options) {
    Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);

    hintMap.put(EncodeHintType.CHARACTER_SET, options.getCharacterEncoding());

    return hintMap;
  }

}
