package com.txm.androtest.dialog;

import com.txm.androtest.R;
import com.txm.androtest.R.id;
import com.txm.androtest.R.layout;
import com.txm.androtest.R.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class DialogSampleActivity extends Activity implements DialogInterface.OnDismissListener{

	static final int DIALOG_SUPER = 0;
	static final int DIALOG_ALERT = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_sample);
		
		Button btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(getCheckdDialogId());
			}
		});
		Button btn2 = (Button)findViewById(R.id.button2);
		btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dismissDialog(getCheckdDialogId());
			}
		});
	}
	
	private int getCheckdDialogId(){
		int id = 0;
		RadioButton r0 = (RadioButton)findViewById(R.id.radio0);
		if(r0.isChecked())
			id = DIALOG_SUPER;
		else
			id = DIALOG_ALERT;
		return id;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialog_sample, menu);
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
	
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		switch(id) {
		case DIALOG_SUPER:
			dialog = new Dialog(this);
			dialog.setTitle("dialog title");
			dialog.setOnDismissListener(this);
			break;
		case DIALOG_ALERT:
			dialog = new AlertDialog.Builder(this)
			.setTitle("alert dialog title")
			.setMessage("hello alert dialog!!")
			.setPositiveButton("yes", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.dismiss();
				}
			})
			.setNegativeButton("no", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			})
			.create();
			dialog.setOnDismissListener(this);
			break;
		default:
			dialog = null;
		}
		return dialog;
		
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		// TODO Auto-generated method stub
		
	}
}
