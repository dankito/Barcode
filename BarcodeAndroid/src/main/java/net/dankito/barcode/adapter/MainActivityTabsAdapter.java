package net.dankito.barcode.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import net.dankito.barcode.R;
import net.dankito.barcode.fragments.GenerateBarcodeFragment;
import net.dankito.barcode.fragments.ReadBarcodeFragment;

/**
 * Created by ganymed on 06/12/16.
 */

public class MainActivityTabsAdapter extends FragmentPagerAdapter {

  protected Activity activity;


  protected ReadBarcodeFragment readBarcodeFragment = null;

  protected GenerateBarcodeFragment generateBarcodeFragment = null;


  public MainActivityTabsAdapter(AppCompatActivity activity) {
    super(activity.getSupportFragmentManager());

    this.activity = activity;
  }


  @Override
  public int getCount() {
    return 2;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    if(position == 0) {
      return activity.getString(R.string.tab_title_read);
    }
    else if(position == 1) {
      return activity.getString(R.string.tab_title_generate);
    }

    return super.getPageTitle(position);
  }

  @Override
  public Fragment getItem(int position) {
    if(position == 0) {
      if(readBarcodeFragment == null) {
        readBarcodeFragment = new ReadBarcodeFragment();
      }
      return readBarcodeFragment;
    }
    else if(position == 1) {
      if(generateBarcodeFragment == null) {
        generateBarcodeFragment = new GenerateBarcodeFragment();
      }
      return generateBarcodeFragment;
    }

    return null;
  }


  public ReadBarcodeFragment getReadBarcodeFragment() {
    return readBarcodeFragment;
  }

}
