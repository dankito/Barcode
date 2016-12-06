package net.dankito.qrcode.util;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by ganymed on 06/12/16.
 */

public class BarcodeGenerator {

  public Bitmap generateQRCode(BarcodeGenerateOptions options) {
    BarcodeFormat barcodeFormat = getBarcodeFormat(options);
    Writer writer = createWriter(barcodeFormat);
    Map<EncodeHintType, Object> hintMap = generateHints(options);
    BitMatrix matrix = null;

    try {
      matrix = writer.encode(options.getTextToEncode(), barcodeFormat, options.getImageWidth(), options.getImageHeight(), hintMap);
    } catch (WriterException ex) {
      ex.printStackTrace();
    }

    Bitmap bitmap = Bitmap.createBitmap(options.getImageWidth(), options.getImageWidth(), Bitmap.Config.RGB_565);
    for (int x = 0; x < options.getImageWidth(); x++){
      for (int y = 0; y < options.getImageHeight(); y++){
        bitmap.setPixel(x, y, matrix.get(x,y) ? Color.BLACK : Color.WHITE);
      }
    }
    return bitmap;
  }

  protected Writer createWriter(BarcodeFormat barcodeFormat) {
    switch(barcodeFormat) {
      case QR_CODE:
        return new QRCodeWriter();
    }

    return null;
  }

  protected BarcodeFormat getBarcodeFormat(BarcodeGenerateOptions options) {
    switch(options.getBarcodeType()) {
      case QRCode:
        return BarcodeFormat.QR_CODE;
    }

    return null;
  }

  protected Map<EncodeHintType, Object> generateHints(BarcodeGenerateOptions options) {
    Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);

    hintMap.put(EncodeHintType.CHARACTER_SET, options.getCharacterEncoding());

    return hintMap;
  }

}
