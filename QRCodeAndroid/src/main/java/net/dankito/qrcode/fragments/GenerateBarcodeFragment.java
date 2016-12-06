package net.dankito.qrcode.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import net.dankito.qrcode.R;
import net.dankito.qrcode.util.BarcodeGenerator;

/**
 * Created by ganymed on 06/12/16.
 */

public class GenerateBarcodeFragment extends Fragment {

  protected BarcodeGenerator barcodeGenerator = new BarcodeGenerator();

  protected ImageView imgGeneratedBarcode;

  protected EditText edtxtTextToEncode;


  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_generate_barcode, container, false);

    imgGeneratedBarcode = (ImageView)view.findViewById(R.id.imgGeneratedBarcode);

    edtxtTextToEncode = (EditText)view.findViewById(R.id.edtxtTextToEncode);
    edtxtTextToEncode.clearFocus();

    Button btnGenerateBarcode = (Button)view.findViewById(R.id.btnGenerateBarcode);
    btnGenerateBarcode.setOnClickListener(btnGenerateBarcodeClickListener);

    return view;
  }



  protected void generateBarcode() {
    Bitmap generatedBarcode = barcodeGenerator.generateQRCode(edtxtTextToEncode.getText().toString());
    imgGeneratedBarcode.setImageBitmap(generatedBarcode);

    hideSoftKeyboard();
  }

  protected void hideSoftKeyboard() {
    if(edtxtTextToEncode != null) {
      InputMethodManager imm = (InputMethodManager) edtxtTextToEncode.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(edtxtTextToEncode.getWindowToken(), 0);
    }
  }


  protected View.OnClickListener btnGenerateBarcodeClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      generateBarcode();
    }
  };

}
