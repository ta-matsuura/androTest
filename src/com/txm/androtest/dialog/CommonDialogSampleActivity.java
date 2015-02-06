package com.txm.androtest.dialog;

import com.txm.androtest.R;
import com.txm.androtest.R.id;
import com.txm.androtest.R.layout;
import com.txm.androtest.R.menu;
import com.txm.androtest.dialog.CommonDialogFragment.CommonDialogInterface;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CommonDialogSampleActivity extends Activity 
	implements
	CommonDialogInterface.onClickListener,
	CommonDialogInterface.onItemClickListener,
	CommonDialogInterface.onShowListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_dialog_sample);
		
	    Button btn1 = (Button)findViewById(R.id.button1);
	    btn1.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	openDialogMessageType();
	        }	    	
	    });
	    Button btn2 = (Button)findViewById(R.id.button2);
	    btn2.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	openDialogOriginalView();
	        }	    	
	    });
	    Button btn3 = (Button)findViewById(R.id.button3);
	    btn3.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	openDialogListItems();
	        }	    	
	    });
	    Button btn4 = (Button)findViewById(R.id.button4);
	    btn4.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	openNormalDialog();
	        }	    	
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.common_dialog_sample, menu);
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
	
	// title & message
	private void openDialogMessageType() {
	    Bundle args = new Bundle();
	    args.putInt(CommonDialogFragment.FIELD_TITLE, R.string.app_name);
	    args.putInt(CommonDialogFragment.FIELD_MESSAGE, R.string.hello_world);
	    args.putInt(CommonDialogFragment.FIELD_LABEL_POSITIVE, android.R.string.ok);
	    CommonDialogFragment dialogFragment = new CommonDialogFragment();
	    dialogFragment.setArguments(args);
	    dialogFragment.show(getFragmentManager(), "dialog1");
	}
	// original view
	private void openDialogOriginalView() {
	    Bundle args = new Bundle();
	    args.putInt(CommonDialogFragment.FIELD_TITLE, R.string.app_name);
	    // 自分で定義したレイアウト
	    args.putInt(CommonDialogFragment.FIELD_LAYOUT, R.layout.dlg_progress_layout);
	    args.putInt(CommonDialogFragment.FIELD_LABEL_POSITIVE, android.R.string.ok);
	    args.putInt(CommonDialogFragment.FIELD_LABEL_NEGATIVE, android.R.string.cancel);
	    CommonDialogFragment dialogFragment = new CommonDialogFragment();
	    dialogFragment.setArguments(args);
	    dialogFragment.show(getFragmentManager(), "dialog2");
	}

	// list items
	private void openDialogListItems() {
	    Bundle args = new Bundle();
	    args.putInt(CommonDialogFragment.FIELD_TITLE, R.string.app_name);
	    // 定義されてる文字なら
	    args.putIntArray(CommonDialogFragment.FIELD_LIST_ITEMS, new int[] {R.string.item1, R.string.item2});
	    // ソースで動的に文字列をつくるなら
	    args.putStringArray(CommonDialogFragment.FIELD_LIST_ITEMS_STRING, new String[] {"item a", "item b"});
	    args.putInt(CommonDialogFragment.FIELD_LABEL_NEGATIVE, android.R.string.cancel);
	    args.putInt(CommonDialogFragment.FIELD_LABEL_NEUTRAL, android.R.string.selectAll);

	    CommonDialogFragment dialogFragment = new CommonDialogFragment();
	    dialogFragment.setArguments(args);
	    dialogFragment.show(getFragmentManager(), "dialog3");
	}
	
	// list items
	private void openNormalDialog() {
	    Bundle args = new Bundle();
	    args.putInt(CommonDialogFragment.FIELD_TITLE, R.string.app_name);
	    args.putInt(CommonDialogFragment.FIELD_MESSAGE, R.string.example);
	    args.putInt(CommonDialogFragment.FIELD_LABEL_NEGATIVE, android.R.string.cancel);
	    args.putInt(CommonDialogFragment.FIELD_LABEL_POSITIVE, android.R.string.yes);

	    CommonDialogFragment dialogFragment = new CommonDialogFragment();
	    dialogFragment.setArguments(args);
	    dialogFragment.show(getFragmentManager(), "dialog4");
	}

	@Override
	public void onDialogShow(String tag, Dialog dialog) {
		// TODO Auto-generated method stub
        if ( ! "dialog2".equals(tag)) {
            return;
        }
 	}

	@Override
	public void onDialogItemClick(String tag, Dialog dialog, String title, int which) {
		// TODO Auto-generated method stub
        // title には押されたリストアイテムのもの
        // which には押されたリストアイテムのindex
        if ( ! "dialog3".equals(tag)) {
        	Toast.makeText(this, tag + "  " + title + "が押された", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getString(R.string.item1).equals(title)) {
            // item 1 がおされた
        	Toast.makeText(this, tag + "  " + title + "が押された", Toast.LENGTH_SHORT).show();
        } else if ("item a".equals(title)) {
            // item a がおされた
        	Toast.makeText(this, tag + "  " + title+ "が押された", Toast.LENGTH_SHORT).show();
        } else if (which == 3) {
            // 4番目 item b がおされた
        	Toast.makeText(this, tag + "  " + title + "が押された", Toast.LENGTH_SHORT).show();
        }
	}

	@Override
	public void onDialogButtonClick(String tag, Dialog dialog, int which) {
		// TODO Auto-generated method stub
        if ("dialog2".equals(tag)) {
            // dialog 2のクリック
            if (DialogInterface.BUTTON_POSITIVE == which) {
                // ok ボタンがおされた
            	Toast.makeText(this, tag + "  " + which + "が押された", Toast.LENGTH_SHORT).show();
            } else if (DialogInterface.BUTTON_NEGATIVE == which) {
                // cancel ボタンがおされた
            	Toast.makeText(this, tag + "  " + which + "が押された", Toast.LENGTH_SHORT).show();
            }
        }		
	}

	@Override
	public void onTest() {
		// TODO Auto-generated method stub
		
	}
}
