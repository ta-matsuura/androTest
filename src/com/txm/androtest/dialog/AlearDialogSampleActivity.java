package com.txm.androtest.dialog;

import com.txm.androtest.R;
import com.txm.androtest.R.id;
import com.txm.androtest.R.layout;
import com.txm.androtest.R.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AlearDialogSampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alear_dialog_sample);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("sample title");
        alertDialogBuilder.setMessage("sample message!! hello alear dialog!");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                		Toast.makeText(getApplicationContext(), "called onClick(1)", Toast.LENGTH_LONG).show();

                    }
                });
        // アラートダイアログのキャンセルが可能かどうかを設定します
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "positive", new DialogInterface.OnClickListener() {
        	@Override
			public void onClick(DialogInterface dialog, int which) {
        		Toast.makeText(getApplicationContext(), "called onClick(2)", Toast.LENGTH_LONG).show();
			}
		});
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "negative", new DialogInterface.OnClickListener() {
        	@Override
			public void onClick(DialogInterface dialog, int which) {
        		Toast.makeText(getApplicationContext(), "called onClick(3)", Toast.LENGTH_LONG).show();
			}
		});
        // アラートダイアログを表示します
        alertDialog.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alear_dialog_sample, menu);
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
