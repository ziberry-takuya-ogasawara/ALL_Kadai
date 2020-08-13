package MondayCalender;
import java.text.SimpleDateFormat;
import java.util.*;

public class Calender {

	public static void main(String args[]) {

		int year = 0;
		int month = 0;
		Scanner sc = new Scanner(System.in);

		//引数チェック
		if(args.length == 0 || args.length == 2) {
			System.out.println("引数に誤りがあります。確認してください。");
			System.exit(0);
		}

		//todo 引数が年なのか月なのかの判定


		//年の設定
		while(true) {
			try {
				System.out.print("月を入力して下さい>");
				String strYear = sc.next();
				year = Integer.parseInt(strYear);
				if(year >= 1900) {
					break;
				}
				System.out.println("年は1900以降で入力してください。");
			}catch(NumberFormatException e) {
				System.out.println("年が数値ではありません。確認してください。");
			}
		}

		//月の設定
		while(true) {
			try {
				System.out.print("月を入力して下さい>");
				String strMonth = sc.next();
				month = Integer.parseInt(strMonth);
				if(month <= 12 && month >= 1) {
					break;
				}
				System.out.println("月は1～12の数値を入力してください。");
			}catch(NumberFormatException e) {
				System.out.println("月が数値ではありません。確認してください。");
			}
		}
		calender(year,month);
		sc.close();
	}



	//今日のカレンダー
	public static void calender() {

		Date date = new Date(); // 今日の日付
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);

		int year = Integer.parseInt(strDate.substring(0,4));
		int month =Integer.parseInt(strDate.substring(6,7));


		// カレンダーインスタンス作成
		Calendar calender = Calendar.getInstance();

		// カレンダー設定（月 - 1）
		calender.set(year, month - 1, 1);
		// 月初めの曜日インデックス（日曜日 1 ～ 土曜日 7）
		int weekIndex = calender.get(8);
		// 月末を求める
		int monthEndDay = calender.getActualMaximum(Calendar.DATE);

		// カレンダー作成
		System.out.printf("   << %4d年 %2d月 >>\n", year, month);
		System.out.println("  月    火    水    木    金    土    日");

		// 曜日オフセットのスペース
		for (int i = 1; i < weekIndex; i++) {
			System.out.print("   ");
		}

		// 1～月末まで出力
		for (int day = 1; day <= monthEndDay; day++) {
			System.out.printf("%3d", day);

			// 土曜日で改行
			if ((day + weekIndex - 1) % 7 == 0) {
				System.out.println();
			}
		}
	}

	//年月入力時
	public static void calender(int year,int month) {
		// カレンダーインスタンス作成
		Calendar calender = Calendar.getInstance();

		// カレンダー設定（月 - 1）
		calender.set(year, month - 1, 1);
		// 月初めの曜日インデックス（日曜日 1 ～ 土曜日 7）
		int weekIndex = calender.get(8);
		// 月末を求める
		int monthEndDay = calender.getActualMaximum(Calendar.DATE);

		// カレンダー作成
		System.out.printf("   << %4d年 %2d月 >>\n", year, month);
		System.out.println("  月    火    水    木    金    土    日");

		// 曜日オフセットのスペース
		for (int i = 1; i < weekIndex; i++) {
			System.out.print("   ");
		}

		// 1～月末まで出力
		for (int day = 1; day <= monthEndDay; day++) {
			System.out.printf("%3d", day);

			// 土曜日で改行
			if ((day + weekIndex - 1) % 7 == 0) {
				System.out.println();
			}
		}
	}


}
