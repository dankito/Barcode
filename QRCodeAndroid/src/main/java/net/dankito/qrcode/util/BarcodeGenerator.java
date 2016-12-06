package net.dankito.qrcode.util;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Created by ganymed on 06/12/16.
 */

public class BarcodeGenerator {

  public static final int DEFAULT_IMAGE_HEIGHT = 500;

  public static final int DEFAULT_IMAGE_WIDTH = 500;


  public Bitmap generateQRCode(String textToEncode) {
    return generateQRCode(textToEncode, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
  }

  public Bitmap generateQRCode(String textToEncode, int width, int height) {
    Writer writer = new QRCodeWriter();
    BitMatrix matrix = null;

    try {
      matrix = writer.encode(textToEncode, BarcodeFormat.QR_CODE, width, height);
    } catch (WriterException ex) {
      ex.printStackTrace();
    }

    Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
    for (int x = 0; x < width; x++){
      for (int y = 0; y < height; y++){
        bmp.setPixel(x, y, matrix.get(x,y) ? Color.BLACK : Color.WHITE);
      }
    }
    return bmp;

//    return QRCode.from("Hello World").withCharset("UTF-8")
//        .to(ImageType.PNG).bitmap();
  }
}
