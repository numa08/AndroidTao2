package jp.numa08.androidtao2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nact);
		TextView resultText = (TextView) findViewById(R.id.result_message);
		String kuji = getIntent().getStringExtra("kuji");
		resultText.setText(kuji);
	}
}
