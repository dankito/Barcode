package net.dankito.barcode.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import net.dankito.barcode.R;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ganymed on 06/12/16.
 */

public class ReadBarcodeFragment extends Fragment {

  protected static final int CAMERA_PERMISSION_REQUEST_CODE = 2703;


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
    if(isCameraPermissionGranted()) {
      new IntentIntegrator(getActivity()).setOrientationLocked(false).initiateScan();
    }
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



  protected boolean isCameraPermissionGranted() {
    if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(getActivity(), new String[]{ Manifest.permission.CAMERA },
          CAMERA_PERMISSION_REQUEST_CODE);

      return false; // permissions are asynchronously requested, so return false for now and wait for result in onRequestPermissionsResult()
    }
    else {
      return true;
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    switch(requestCode) {
      case CAMERA_PERMISSION_REQUEST_CODE: {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) { // permission was granted, yay!
         startBarcodeReading();
        }
      }
    }
  }

}
