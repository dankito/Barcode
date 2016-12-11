package net.dankito.barcode.localization;

import java.util.ResourceBundle;

/**
 * Created by ganymed on 12/12/16.
 */

public class BarcodeJavaFxResources {

  protected static final String STRING_RESOURCE_BUNDLE_NAME = "Strings";


  public static ResourceBundle generate() {
    return ResourceBundle.getBundle(STRING_RESOURCE_BUNDLE_NAME, new UTF8Control());
  }

}
