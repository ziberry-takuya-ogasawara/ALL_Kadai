package Triangre;
import java.util.*;
/*
 * 入力した三つの辺からどの三角形かを判断し結果を出力する。
 */
public class triangre {

	//入力した値を保持する配列
	private static ArrayList<Integer>triangreLength = new ArrayList<Integer>();
	private static int smallLength = 0;
	private static int middleLength = 0;
	private static int bigLength = 0;

	public static void main(String args[]) {
		//三角形の辺の長さを設定。
		setLength();
		//各辺の大きさを比較する。
		comparison();
		//三角形として成立するかの判定||非成立の場合終了
		judgmentTriangre();
		//該当の三角形を判定し出力
		judgmentTriangreType();
	}

	/*
	 * 三つの辺の長さを入力し、取得するメソッド
	 */
	public static void setLength() {
		Scanner sc = new Scanner(System.in);

		System.out.println("三角形の辺の長さを三つ入力してください");
		System.out.println("qを入力で決定");

		while(true) {
			System.out.print(">");
			String x = sc.next();
			if(x.equals("q")) {
				//入力値が足りない処理
				if(triangreLength.size() < 3) {
					System.out.println("入力値が足りません。入力値を見直してください。");
				}else {
				break;
				}
			}
			//三つ以上入力した際の処理
			else if(triangreLength.size() >= 3 ) {
				System.out.println("入力値に4個以上設定されました、入力値を見直して下さい。");
			}else {
			//入力した値をIntegerに変換し配列に格納
			triangreLength.add(Integer.valueOf(x));
			}
		}
		sc.close();
	}

	public static void comparison() {
		int length1 = triangreLength.get(0);
		int length2 = triangreLength.get(1);
		int length3 = triangreLength.get(2);

		//一番大きい辺を特定
		if(length1 > length2) {
			if(length1 > length3) {
				bigLength = length1;
			}
		}else if(length2 > length3) {
			bigLength = length2;
		}else {
			bigLength = length3;
		}
		//一番小さい辺を特定
		if(length1 < length2) {
			if(length1 < length3) {
				smallLength = length1;
			}
		}else if(length2 < length3) {
			smallLength = length2;
		}else {
			smallLength = length3;
		}
		//真ん中の辺を特定
		if(length1 > length2) {
			if(length1 < length3) {
				middleLength = length1;
			}
		}else if(length2 < length3) {
			middleLength = length2;
		}else {
			middleLength = length3;
		}

	}

	public static void judgmentTriangre() {
		if(smallLength+middleLength < bigLength) {
			System.out.println(smallLength+","+middleLength+","+bigLength);
			System.out.println("上記入力値では三角形になりません。");
			System.exit(0);
		}
	}

	public static void judgmentTriangreType() {
		int EquilateralTrianglecount = 0;
		if(triangreLength.get(0) == triangreLength.get(1)) {
			EquilateralTrianglecount++;
		}
		if(triangreLength.get(0) == triangreLength.get(2)) {
			EquilateralTrianglecount++;
		}
		if(triangreLength.get(1) == triangreLength.get(2)) {
			EquilateralTrianglecount++;
		}

		int outPutCount = 0;

		//正三角形の判定
		if(EquilateralTrianglecount == 3) {
			System.out.println("正三角形です。");
			outPutCount++;
		}
		else if(EquilateralTrianglecount == 1) {
			System.out.println("二等辺三角形です。");
			outPutCount++;
		}

		//辺の長の対比が１：1：2なら直角三角形。
		if(smallLength == middleLength && smallLength == bigLength/2) {
			System.out.println("直角三角形です。");
			outPutCount++;
		}
		//辺の長の対比が１：２：３なら直角三角形。
		else if(smallLength == middleLength/2 && smallLength == bigLength/3) {
			System.out.println("直角三角形です。");
			outPutCount++;
		}

		if(outPutCount == 0) {
			System.out.println("三角形です。");
		}

	}

}












