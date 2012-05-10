package jp.numa08.androidtao2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AndroidTao2Activity extends Activity {
	/** Called when the activity is first created. */
	private Omikuji kuji; // おみくじ変数を作る.

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top);
		kuji = new Omikuji();

		// 今日の運勢ボタン
		Button todayButton = (Button) findViewById(R.id.button);
		todayButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				String result = kuji.runKuji();
				showOmikujiDialog(result);
			}
		});

		// 明日の運勢ボタン
		Button tommorowButton = (Button) findViewById(R.id.tommowor_button);
		tommorowButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String result = kuji.runKuji();
				startOmikujiActivity(result);
			}
		});

		// 来週の運勢ボタン
		Button nweekButton = (Button) findViewById(R.id.nweek_button);
		nweekButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String result = kuji.runKuji();
				tweetOmikuji(result);
			}
		});
	}

	/**
	 * おみくじの結果をつぶやく
	 * 
	 * @param kuji
	 *            　おみくじの結果
	 */
	private void tweetOmikuji(String kuji) {
		Uri.Builder uriBuilder = new Uri.Builder();
		uriBuilder.scheme("https");
		uriBuilder.authority("twitter.com");
		uriBuilder.path("/intent/tweet");
		uriBuilder.appendQueryParameter("text", "来週の運勢は" + kuji + "です");
		Intent tweetIntent = new Intent(Intent.ACTION_VIEW, uriBuilder.build());
		startActivity(tweetIntent);
	}

	/**
	 * おみくじの結果を次のActivityで表示する
	 * 
	 * @param kuji
	 *            　おみくじの結果
	 */
	private void startOmikujiActivity(String kuji) {
		Intent intent = new Intent(AndroidTao2Activity.this,
				SecondActivity.class);
		intent.putExtra("kuji", kuji);
		startActivity(intent);
	}

	/**
	 * おみくじの結果をダイアログで表示する
	 * 
	 * @param kuji
	 *            おみくじの結果
	 */
	private void showOmikujiDialog(String kuji) {
		AlertDialog.Builder builder = new Builder(AndroidTao2Activity.this);
		builder.setMessage(kuji);
		builder.show();
	}
}