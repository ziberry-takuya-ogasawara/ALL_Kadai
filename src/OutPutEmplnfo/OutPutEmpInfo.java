package OutPutEmplnfo;
import java.io.UnsupportedEncodingException;
//2020/06/10 ogasawara takuya
public class OutPutEmpInfo {

	//フィールド変数
	private static int DefEmpNumber = 999999999;
	private static String tab= "\t:";
	private static String templeteName = "名前"+tab;
	private static String templeteNumber = "社員番号"+tab;

	public static void main(String args[])
			throws UnsupportedEncodingException {
		//サポートされていない文字コードの例外処理が起こりえることを明示

		//未入力処理
		if(args.length == 0) {
			empInfo();
			System.exit(0);
		}

		//二つ目以降のデータは無視
		String[] nameAndNumber = new String[2];
		for(int i = 0 ; i<args.length ; i++) {
			if(i < 2) {
				nameAndNumber[i] = args[i];
			}
		}

		String name = null;
		int number = 0;

		//入力数１
		if(args.length == 1) {
			if(JudgmentName(args[0])) {
				name = args[0];
				empInfo(name);
			}else {
				System.out.println("名前は全角文字列で入力してください。");
			}
		}
		//入力数２
		else if(args.length == 2) {
			String[] x = JudgmentNameAndNumber(nameAndNumber);
			name = x[0];
			number = Integer.parseInt(x[1]);
			empInfo(name,number);
		}
		//入力数３
		else if(args.length >= 3) {
			String[] x = JudgmentNameAndNumber(nameAndNumber);
			name = x[0];
			number = Integer.parseInt(x[1]);
			empInfo(name,number,args[2]);
		}
	}

	public static String[] JudgmentNameAndNumber(String[] x)
			throws UnsupportedEncodingException {

		//index1にname index2にnumber
		String[] NameAndNunber = new String[2];
		String name = null;
		String number = null;

		for(int i = 0 ; i<2 ; i++) {
			//名前の判定
			if(JudgmentName(x[i])) {
				name = x[i];
			}
			//数値の判定
			try {
				Integer.parseInt(x[i]);
				if(JudgmentNumber(x[i])) {
					number = x[i];
				}
			}catch(NumberFormatException e) {
				//無視
			}
		}
		//エラー処理
		if(name == null || number == null) {
			if(name == null) {
				System.out.println("名前は全角文字列で入力してください。");
			}
			if(number == null) {
				System.out.println("社員番号は半角数字で入力してください。");
			}
			System.exit(0);
		}
		NameAndNunber[0] = name;
		NameAndNunber[1] = number;
		return NameAndNunber;
	}


	//引数が全角かどうかを判断
	public static boolean JudgmentName(String x)
			throws UnsupportedEncodingException {
		//サポートされていない文字コードの例外処理が起こりえることを明示

		//文字数に対してバイト数が二倍なら全角と判断
		if(x.getBytes("UTF-8").length ==( x.length()*3)) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean JudgmentNumber(String x)
			throws UnsupportedEncodingException {
		//サポートされていない文字コードの例外処理が起こりえることを明示{

		//文字数とバイト数が一致することで全て半角であると判断。
		if(x.getBytes("UTF-8").length ==x.length()) {
			//int型変換が成功することで数値であることを判断
			try {
				Integer.parseInt(x);
				return true;
			}catch(NumberFormatException e){
				//半角カナ等が混じってしまった場合を想定
				return false;
			}
		}else {
			return false;
		}

	}

	//入力値の設定なし
	public static void empInfo() {
		System.out.println("入力値が設定されていません。引数を設定の上、再度実行してください。");
	}
	//入力値一つ
	public static void empInfo(String name) {
		System.out.println("社員番号の設定が無かったためデフォルト値を設定します。");
		System.out.println(templeteName+name);
		System.out.println(templeteNumber+DefEmpNumber);
	}
	//入力値二つ
	public static void empInfo(String name ,int number) {
		System.out.println(templeteName+name);
		System.out.println(templeteNumber+number);
	}
	//入力値三つ以上
	public static void empInfo(String name ,int number,String x) {
		System.out.println("引数が多く設定されているため、余計な引数を無視します。");
		System.out.println(templeteName+name);
		System.out.println(templeteNumber+number);
	}

}
