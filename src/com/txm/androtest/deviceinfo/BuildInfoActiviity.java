package com.txm.androtest.deviceinfo;

import com.txm.androtest.R;
import com.txm.androtest.R.id;
import com.txm.androtest.R.layout;
import com.txm.androtest.R.menu;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BuildInfoActiviity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_build_info_activiity);
    
    //ListViewのセット
    ListView listView = new ListView(this);
    setContentView(listView);
    
  //データの追加
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1);
    adapter.add("BOARD : " + Build.BOARD);
    adapter.add("BOOTLOADER : " + Build.BOOTLOADER);
    adapter.add("CPU_ABI : " + Build.CPU_ABI);
    adapter.add("CPU_ABI2 : " + Build.CPU_ABI2);
    adapter.add("DEVICE : " + Build.DEVICE);
    adapter.add("DISPLAY : " + Build.DISPLAY);
    adapter.add("FINGERPRINT : " + Build.FINGERPRINT);
    adapter.add("HARDWARE : " + Build.HARDWARE);
    adapter.add("HOST : " + Build.HOST);
    adapter.add("ID : " + Build.ID);

    adapter.add("MANUFACTURER : " + Build.MANUFACTURER);
    adapter.add("MODEL : " + Build.MODEL);
    adapter.add("PRODUCT : " + Build.PRODUCT);
    adapter.add("RADIO : " + Build.RADIO);
    adapter.add("SERIAL : " + Build.SERIAL);
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      String[] str32 =  Build.SUPPORTED_32_BIT_ABIS;
      String[] str64 =  Build.SUPPORTED_64_BIT_ABIS;
      String[] str =  Build.SUPPORTED_ABIS;

      adapter.add("SUPPORTED_32_BIT_ABIS : " + str32[0]);
      adapter.add("SUPPORTED_64_BIT_ABIS : " + str64[0]);
      adapter.add("SUPPORTED_ABIS : " + str[0]); 
    }
    adapter.add("TIME : " + Build.TIME);
    adapter.add("TYPE : " + Build.TYPE);
    adapter.add("USER : " + Build.USER);
    
    listView.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.build_info_activiity, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
