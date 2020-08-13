package No10;

/**
 *
 * @author ogasawara
 *@version 1.0
 */
public class KyoukaTennsu {

	private String kyouka = null;
	private String tennsu = null;

	/**
	 *
	 * @param kyouka セッターメソッド
	 */
	public void setKyouka(String kyouka) {
		this.kyouka = kyouka;
	}
	/**
	 *
	 * @return String kyouka ゲッターメソッド
	 */
	public String getKyouka() {
		return kyouka;
	}

	/**
	 *
	 * @param tennsu セッターメソッド
	 */
	public void setTennsu(String tennsu){
		this.tennsu = tennsu;
	}
	/**
	 *
	 * @return String tennsu ゲッターメソッド
	 */
	public String getTennsu() {
		return tennsu;
	}


}
