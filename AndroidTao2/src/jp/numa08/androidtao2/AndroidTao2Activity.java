package jp.numa08.androidtao2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * メインのActivity ボタンが３つあるよ
 * 
 * @author numanuma08
 * 
 */
public class AndroidTao2Activity extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(final Bundle sIState) {
		super.onCreate(sIState);
		setContentView(R.layout.main);

		final OmikujiListener listener = new OmikujiListener(this);
		configButton(listener);
	}

	/**
	 * ボタンの初期設定だよ
	 * 
	 * @param listener
	 *            リスナークラス
	 */
	private void configButton(final OmikujiListener listener) {
		final Button todayButton = (Button) findViewById(R.id.today);
		// todayButton.setOnClickListener(listener);
		todayButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				runedOmikuji("小吉", v.getId());
			}
		});
		final Button tommorowButton = (Button) findViewById(R.id.tommorow);
		tommorowButton.setOnClickListener(listener);
		final Button yesterdayButton = (Button) findViewById(R.id.yesterday);
		yesterdayButton.setOnClickListener(listener);
	}

	/**
	 * おみくじのコールバックメソッド
	 * 
	 * @param kuji
	 *            　引いたおみくじ
	 * @param viewId
	 *            おされたボタン
	 */
	public void runedOmikuji(final String kuji, final int viewId) {
		switch (viewId) {
		case R.id.today:
			// TODO ダイアログの表示
			final AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(kuji);
			builder.setPositiveButton("やったー", new OnClickListener() {

				@Override
				public void onClick(final DialogInterface dialog,
						final int which) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});
			builder.show();
			break;
		case R.id.tommorow:
			// TODO Activityの起動
			final Intent intent = new Intent(this, OmikujiResult.class);
			intent.putExtra(getString(R.string.omikuji_key), kuji);
			startActivity(intent);
			break;
		case R.id.yesterday:
			// TODO TwitterのURLを開く
			Uri.Builder uriBuilder = new Builder();
			uriBuilder.scheme("https");
			uriBuilder.authority("twitter.com");
			uriBuilder.path("/intent/tweet");
			uriBuilder.appendQueryParameter("text", "昨日の運勢は" + kuji + "だよ");
			final Intent tweetIntent = new Intent(Intent.ACTION_VIEW,
					uriBuilder.build());
			startActivity(tweetIntent);
			break;
		default:
			break;
		}
	}
}