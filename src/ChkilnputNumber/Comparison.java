package ChkilnputNumber;
/*
 * コンストラクタによってオブジェクト作成時に数値の比較を行い、
 * 対応したコメントを作成します。
 * outPrintMassegeメソッドを呼び出すことでコメントを取得します。
 */
public class Comparison {

	private String ClassMassege = null;

	Comparison(int x) {

		DefNumber objDefNumber = new DefNumber();
		int DefNumber = objDefNumber.getDefNumber();
		String massege = null;
		String DefMassege = "入力された値とデフォルト値を比較し、";
		if(x>DefNumber) {
			massege = DefMassege+"大きい値は"+x+"です。";
		}else if(x<DefNumber) {
			massege = DefMassege+"大きい値は"+DefNumber+"です。";
		}else if(x == DefNumber) {
			massege = DefMassege+"値は等しいです。";
		}
		ClassMassege = massege;
	}

	Comparison(int x,int y){
		String massege = null;
		if(x>y) {
			massege = "大きい値は"+x+"です。";
		}else if(x<y) {
			massege = "大きい値は"+y+"です。";
		}else if(x == y) {
			massege = "値は等しいです。";
		}
		ClassMassege = massege;
	}

	public void outPrintMassege() {
		System.out.println(ClassMassege);
	}


}