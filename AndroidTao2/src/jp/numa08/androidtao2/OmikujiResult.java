package jp.numa08.androidtao2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 *   おみくじ結果Activity`
 * 
 * @author numanuma08
 * 
 */
public class OmikujiResult extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(final Bundle siState) {
		super.onCreate(siState);
		// TODO Auto-generated method stub
		setContentView(R.layout.result);
		final String omikuji = getIntent().getStringExtra(
				getString(R.string.omikuji_key));
		final TextView omikujiText = (TextView) findViewById(R.id.omikuji_result);
		omikujiText.setText(omikuji);
	}

}
