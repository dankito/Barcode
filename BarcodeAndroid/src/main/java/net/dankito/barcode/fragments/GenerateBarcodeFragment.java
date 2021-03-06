package net.dankito.barcode.fragments;

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
import android.widget.Spinner;

import net.dankito.barcode.BarcodeGenerateOptions;
import net.dankito.barcode.BarcodeGenerationResult;
import net.dankito.barcode.BarcodeGenerator;
import net.dankito.barcode.BarcodeGeneratorAndroid;
import net.dankito.barcode.BarcodeType;
import net.dankito.barcode.R;
import net.dankito.barcode.adapter.BarcodeTypeSpinnerAdapter;
import net.dankito.barcode.util.AlertHelper;

/**
 * Created by ganymed on 06/12/16.
 */

public class GenerateBarcodeFragment extends Fragment {

  protected BarcodeGenerator barcodeGenerator = new BarcodeGeneratorAndroid();

  protected ImageView imgGeneratedBarcode;

  protected EditText edtxtTextToEncode;

  protected Spinner spnBarcodeType;


  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_generate_barcode, container, false);

    imgGeneratedBarcode = (ImageView)view.findViewById(R.id.imgGeneratedBarcode);

    edtxtTextToEncode = (EditText)view.findViewById(R.id.edtxtTextToEncode);
    edtxtTextToEncode.clearFocus();

    spnBarcodeType = (Spinner)view.findViewById(R.id.spnBarcodeType);
    spnBarcodeType.setAdapter(new BarcodeTypeSpinnerAdapter(getActivity()));
    spnBarcodeType.setSelection(getIndexOfDefaultBarcodeType());

    Button btnGenerateBarcode = (Button)view.findViewById(R.id.btnGenerateBarcode);
    btnGenerateBarcode.setOnClickListener(btnGenerateBarcodeClickListener);

    return view;
  }

  protected int getIndexOfDefaultBarcodeType() {
    BarcodeType defaultType = BarcodeType.QR_CODE;
    BarcodeType[] barcodeTypes = BarcodeType.values();

    for(int i = 0; i < barcodeTypes.length; i++) {
      if(defaultType.equals(barcodeTypes[i])) {
        return i;
      }
    }

    return 0;
  }


  protected void generateBarcode() {
    BarcodeType barcodeType = (BarcodeType)spnBarcodeType.getSelectedItem();
    BarcodeGenerateOptions options = new BarcodeGenerateOptions(edtxtTextToEncode.getText().toString(), barcodeType);

    BarcodeGenerationResult generationResult = barcodeGenerator.generateQRCode(options);

    if(generationResult.isSuccessful()) {
      Bitmap bitmap = (Bitmap)generationResult.getGeneratedBarcode();
      imgGeneratedBarcode.setImageBitmap(bitmap);
      hideSoftKeyboard();
    }
    else {
      imgGeneratedBarcode.setImageBitmap(null);
      showBarcodeGenerationError(generationResult);
    }
  }

  protected void hideSoftKeyboard() {
    if(edtxtTextToEncode != null) {
      InputMethodManager imm = (InputMethodManager) edtxtTextToEncode.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(edtxtTextToEncode.getWindowToken(), 0);
    }
  }

  protected void showBarcodeGenerationError(BarcodeGenerationResult generationResult) {
    AlertHelper.showErrorMessage(getActivity(), generationResult.getError(), getString(R.string.error_title_could_not_generate_barcode));
  }


  protected View.OnClickListener btnGenerateBarcodeClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      generateBarcode();
    }
  };

}
