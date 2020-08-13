package Seiseki;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
//2020/06/10 ogasawara takuya
import java.util.*;
public class Seiseki {

	public static void main(String srgs[])
			throws UnsupportedEncodingException {
		//点数を入力し合計と平均を出力するメソッド
		seiseki();
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

	public static void seiseki()
			throws UnsupportedEncodingException {
		//リソース
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String[] kamoku = {"国語","数学","社会","理科","英語"};
		int[] seiseki = new int[5];
		int gokei = 0;
		double heikin = 0.00;

		//点数の入力
		for(int i = 0 ; i<kamoku.length ; i++) {
			while(true) {
				try {
					System.out.print(kamoku[i]+"の点数＝");
					String strScore = null;
					try {
						strScore = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					int score = Integer.parseInt(strScore);

					if(JudgmentforZenkaku(strScore)) {
						System.out.println("数字ではありませんもう一度入力してください。");
					}
					else if(strScore.equals("")){
						System.out.println("数字ではありませんもう一度入力してください。");
					}else if(score > 100) {
						System.out.println("１教科の満点は100点までです。100以下の数字を入力してください。");
					}else if(score < 0) {
						System.out.println("マイナスの点数です。もう一度入力してください。");
					}else {
						gokei += score;
						seiseki[i] = score;
						break;
					}
				}catch(NumberFormatException e ) {
					System.out.println("数字ではありませんもう一度入力してください。");
				}
			}
		}
		//平均点の算出
		double x  = (double)gokei/kamoku.length;
		BigDecimal bd1 = new BigDecimal(x);
		//小数点第一位で切り捨て
		BigDecimal bd2= bd1.setScale(1,RoundingMode.DOWN);
		heikin = bd2.doubleValue();

		//出力
		System.out.println("合計："+gokei+"点です。");
		System.out.println("平均点："+heikin+"点です。");
	}

}
