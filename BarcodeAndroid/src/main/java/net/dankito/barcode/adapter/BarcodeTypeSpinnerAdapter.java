package net.dankito.barcode.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.dankito.barcode.BarcodeType;
import net.dankito.barcode.R;

/**
 * Created by ganymed on 07/12/16.
 */

public class BarcodeTypeSpinnerAdapter extends BaseAdapter {

  protected Activity activity;


  public BarcodeTypeSpinnerAdapter(Activity activity) {
    this.activity = activity;
  }


  @Override
  public int getCount() {
    return BarcodeType.values().length;
  }

  @Override
  public Object getItem(int position) {
    return BarcodeType.values()[position];
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup viewGroup) {
    if(convertView == null) {
      convertView = activity.getLayoutInflater().inflate(R.layout.spinner_item_barcode_type, viewGroup, false);
    }

    BarcodeType barcodeType = (BarcodeType)getItem(position);

    TextView txtvwBarcodeTypeName = (TextView)convertView.findViewById(R.id.txtvwBarcodeTypeName);
    txtvwBarcodeTypeName.setText(barcodeType.toString());

    return convertView;
  }
}
