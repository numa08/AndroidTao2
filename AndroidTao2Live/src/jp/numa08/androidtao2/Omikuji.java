package jp.numa08.androidtao2;

public class Omikuji {
	private static final int KITI = 0;
	private static final int DAI_KITI = KITI + 1;
	private static final int DAI_KYOU = KITI + 2;

	public String runKuji() {
		int omikuji = (int) (Math.random() * 10.0) % 3;
		String result;
		if (omikuji == KITI) {
			result = "�g";
		} else if (omikuji == DAI_KITI) {
			result = "��g";
		} else if (omikuji == DAI_KYOU) {
			result = "�勥";
		} else {
			result = "�Ȃɂ�������������";
		}
		return result;
	}
}
