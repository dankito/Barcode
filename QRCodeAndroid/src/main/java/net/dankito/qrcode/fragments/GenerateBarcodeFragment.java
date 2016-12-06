package net.dankito.qrcode.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    Button btnGenerateBarcode = (Button)view.findViewById(R.id.btnGenerateBarcode);
    btnGenerateBarcode.setOnClickListener(btnGenerateBarcodeClickListener);

    return view;
  }



  protected void generateBarcode() {
    imgGeneratedBarcode.setImageBitmap(barcodeGenerator.generateQRCode(edtxtTextToEncode.getText().toString()));
  }


  protected View.OnClickListener btnGenerateBarcodeClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      generateBarcode();
    }
  };

}
