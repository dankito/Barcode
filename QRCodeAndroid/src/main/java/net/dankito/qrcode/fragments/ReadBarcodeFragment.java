package net.dankito.qrcode.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;

import net.dankito.qrcode.R;

/**
 * Created by ganymed on 06/12/16.
 */

public class ReadBarcodeFragment extends Fragment {

  protected EditText edtxtDecodedBarcode;


  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_read_barcode, container, false);

    edtxtDecodedBarcode = (EditText)view.findViewById(R.id.edtxtDecodedBarcode);

    Button btnReadBarcode = (Button)view.findViewById(R.id.btnReadBarcode);
    btnReadBarcode.setOnClickListener(btnReadBarcodeClickListener);

    return view;
  }


  protected void startBarcodeReading() {
    new IntentIntegrator(getActivity()).setOrientationLocked(false).initiateScan();
  }


  protected View.OnClickListener btnReadBarcodeClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      startBarcodeReading();
    }
  };

}
