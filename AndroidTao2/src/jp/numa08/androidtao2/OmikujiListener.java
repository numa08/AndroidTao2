package jp.numa08.androidtao2;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * おみくじボタンのリスナークラス
 * 
 * @author numanuma08
 * 
 */
public class OmikujiListener implements OnClickListener {

	private final transient AndroidTao2Activity activity;

	/**
	 * コンストラクタ
	 * 
	 * @param activity
	 */
	public OmikujiListener(final AndroidTao2Activity activity) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
	}

	@Override
	public void onClick(final View view) {
		// TODO おみくじクラスからおみくじを引く
		final Omikuji omikuji = new Omikuji();
		// TODO 結果文字列をActivityに返す
		activity.runedOmikuji(omikuji.runOmikuji(), view.getId());
	}
}
