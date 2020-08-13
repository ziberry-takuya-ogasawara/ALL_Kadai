package ChkilnputNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/*
 * 入力した数値を比較し、結果をコメントで出力するゲームです。
 */
public class ChkilnputNumber {

	public static void main(String args[]) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try {
			ArrayList<Integer>NumberList = new ArrayList<Integer>();

			System.out.println("引数を入力してください。");
			System.out.println("q(半角)で決定します。");
			System.out.println("入力は一つでも構いません");
			while(true) {
				try {

					//入力
					System.out.print(">");
					String strNumber = br.readLine();
					//qの場合決定選択のためbreak
					if(strNumber.equals("q")) {
						if(NumberList.size() > 2) {
							System.out.println("二回目以降の入力が行われました。値の入力回数は二回までです。");
							System.exit(0);
						}
						break;
					}
					int Number = Integer.parseInt(strNumber);
					if(JudgmentforZenkaku(strNumber)) {
						System.out.println("数値を入力してください。");
					}else if(strNumber.equals("")) {
						System.out.println("数値を入力してください。");
					}
					NumberList.add(Number);
				}catch(NumberFormatException e) {
					System.out.println("数値を入力してください。");
				}
			}
			if(NumberList.size() == 0) {
				System.out.println("入力値が設定されていません。引数を確認うえ再度実行してください。");
				System.exit(0);
			}else {
				//入力が一つの場合
				if(NumberList.size() == 1) {
					int x = NumberList.get(0);
					Comparison obj = new Comparison(x);
					obj.outPrintMassege();
				}
				//入力が二つの場合
				else {
					int x = NumberList.get(0);
					int y = NumberList.get(1);
					Comparison obj = new Comparison(x,y);
					obj.outPrintMassege();
				}
			}
		}catch(Exception e) {
			System.out.print(e+"です。");
		}

	}

	public static boolean JudgmentforZenkaku(String x)
			throws UnsupportedEncodingException {
		//サポートされていない文字コードの例外処理が起こりえることを明示
		//文字数に対してバイト数が二倍なら全角と判断
		if(x.getBytes("UTF-8").length ==( x.length()*3)) {
			return true;
		}else {
			return false;
		}
	}

}


