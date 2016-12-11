package net.dankito.barcode;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.common.BitMatrix;

/**
 * Created by ganymed on 11/12/16.
 */

public class BarcodeGeneratorAndroid extends BarcodeGenerator {

  protected Object createBitmap(BarcodeGenerateOptions options, BitMatrix matrix) {
    Bitmap bitmap = Bitmap.createBitmap(options.getImageWidth(), options.getImageWidth(), Bitmap.Config.RGB_565);
    for (int x = 0; x < options.getImageWidth(); x++){
      for (int y = 0; y < options.getImageHeight(); y++){
        bitmap.setPixel(x, y, matrix.get(x,y) ? Color.BLACK : Color.WHITE);
      }
    }
    return bitmap;
  }

}
