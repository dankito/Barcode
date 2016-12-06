package net.dankito.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import net.dankito.qrcode.adapter.MainActivityTabsAdapter;
import net.dankito.qrcode.fragments.ReadBarcodeFragment;

public class MainActivity extends AppCompatActivity {

  protected MainActivityTabsAdapter mainActivityTabsAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mainActivityTabsAdapter = new MainActivityTabsAdapter(this);

    ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
    viewPager.setAdapter(mainActivityTabsAdapter);

    TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
    tabLayout.setupWithViewPager(viewPager);

  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    ReadBarcodeFragment readBarcodeFragment = mainActivityTabsAdapter.getReadBarcodeFragment();
    if(readBarcodeFragment != null && readBarcodeFragment.handlesActivityResult(requestCode, resultCode, data)) {

    }

    super.onActivityResult(requestCode, resultCode, data);
  }
}
