package com.txm.androtest.webview;

import com.txm.androtest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SimpleWebviewActivity extends Activity {
  WebView webView;
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_webview);
    
    webView = (WebView) findViewById(R.id.web_view);
//    webView.setWebViewClient(new WebViewClient() {
//      public boolean shouldOverrideUrlLoading(WebView view, String urlStr) {
//        // 特定のURLの場合、ダイアログを表示する等
//        Toast toast = Toast.makeText(SimpleWebviewActivity.this, "urlStr : " + urlStr,
//            Toast.LENGTH_SHORT);
//        toast.show();
//
//        return false;
//      }
//    });
    webView.loadUrl("file:///android_res/raw/simple.html");
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
