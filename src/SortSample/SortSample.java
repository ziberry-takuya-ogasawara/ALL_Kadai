package SortSample;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Pattern;
public class SortSample {

	public static void main(String args[])
			throws UnsupportedEncodingException {

		Sort(args);

	}

	//引数が全角かどうかを判断
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


	//引数をソートし、六番目の引数を出力する。
	//引数が６でない場合は指定の動作を行う。
	public static void Sort(String[] SortList)
			throws UnsupportedEncodingException {

		//引数のサイズ確認
		if(SortList.length != 6) {
			System.out.println("設定された引数の値が正しくありません。確認の上再度実行してください。");
			return;
		}
		//引数index[5]の数字確認
		int selectNumber ;
		try {
			selectNumber = Integer.parseInt(SortList[5]);

			if(selectNumber >5 || selectNumber <1){
				System.out.println(" 6番目の引数は１～５までの数値を入力してください。");
				return;
			}
			//全角の判別
			 if(JudgmentforZenkaku(SortList[5])) {
				 System.out.println("6番目の引数は数字で設定してください。");
				 return;
			 }

		}catch(NumberFormatException e) {
			System.out.println("6番目の引数は数字で設定してください。");
			return;
		}
		//配列から数値を除去
		String[] SortListForOutNumber = new String[5];
		int y = SortList.length-1;
		for(int i = 0 ; i<y ; i++) {
			SortListForOutNumber[i] = SortList[i];
		}

		//ソート先頭に数字・文字は五十音順にソート
		Arrays.sort(SortListForOutNumber);
		//結果表示
		System.out.println(selectNumber+"の値は、 "+SortListForOutNumber[--selectNumber]+" です。");
	}

}
