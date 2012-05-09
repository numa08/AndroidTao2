package jp.numa08.androidtao2;

/**
 * おみくじクラス
 * 
 * @author numanuma08
 * 
 */
public class Omikuji {
	// private static final String TAG = "Omikuji";
	private static final int KITI = 0;
	private static final int DAI_KITI = 1;
	private static final int DAI_KYO = 2;

	/**
	 * おみくじを引く
	 * 
	 * @return
	 */
	public String runOmikuji() {
		final int omikuji = (int) (Math.random() * 10.0) % 3;
		String result;
		switch (omikuji) {
		case Omikuji.KITI:
			result = "吉";
			break;
		case Omikuji.DAI_KITI:
			result = "大吉";
			break;
		case Omikuji.DAI_KYO:
			result = "大凶";
			break;
		default:
			result = "残念^^;";
			break;
		}
		return result;
	}
}
