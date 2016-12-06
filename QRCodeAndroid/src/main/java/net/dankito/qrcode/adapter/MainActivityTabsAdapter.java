package net.dankito.qrcode.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ganymed on 06/12/16.
 */

public class MainActivityTabsAdapter extends FragmentPagerAdapter {

  protected Activity activity;


  public MainActivityTabsAdapter(AppCompatActivity activity) {
    super(activity.getSupportFragmentManager());

    this.activity = activity;
  }

  public MainActivityTabsAdapter(FragmentManager fm) {
    super(fm);
  }


  @Override
  public int getCount() {
    return 0;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return super.getPageTitle(position);
  }

  @Override
  public Fragment getItem(int position) {
    return null;
  }

}
