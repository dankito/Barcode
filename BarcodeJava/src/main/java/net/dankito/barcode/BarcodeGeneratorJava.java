package net.dankito.barcode;

import com.google.zxing.common.BitMatrix;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Created by ganymed on 11/12/16.
 */

public class BarcodeGeneratorJava extends BarcodeGenerator {

  @Override
  protected Object createBitmap(BarcodeGenerateOptions options, BitMatrix matrix) {
    int width = matrix.getWidth();

    BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
    image.createGraphics();

    Graphics2D graphics = (Graphics2D) image.getGraphics();
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, width, width);
    graphics.setColor(Color.BLACK);

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < width; j++) {
        if (matrix.get(i, j)) {
          graphics.fillRect(i, j, 1, 1);
        }
      }
    }

    return image;
  }

}
