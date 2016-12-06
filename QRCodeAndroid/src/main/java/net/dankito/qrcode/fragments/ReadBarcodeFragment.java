package net.dankito.qrcode.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import net.dankito.qrcode.R;

import static android.app.Activity.RESULT_OK;

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

    FloatingActionButton fabReadBarcode = (FloatingActionButton) view.findViewById(R.id.fabReadBarcode);
    fabReadBarcode.setOnClickListener(fabReadBarcodeClickListener);

    return view;
  }


  protected void startBarcodeReading() {
    new IntentIntegrator(getActivity()).setOrientationLocked(false).initiateScan();
  }

  public boolean handlesActivityResult(int requestCode, int resultCode, Intent data) {
    if(resultCode == RESULT_OK) {
      IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
      if(result != null) {
        retrievedBarcodeScanningResults(result.getContents(), result.getFormatName(), result.getBarcodeImagePath());
      }
    }

    return false;
  }

  protected void retrievedBarcodeScanningResults(String contents, String formatName, String barcodeImagePath) {
    edtxtDecodedBarcode.setText(contents);
  }


  protected View.OnClickListener fabReadBarcodeClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      startBarcodeReading();
    }
  };

}
