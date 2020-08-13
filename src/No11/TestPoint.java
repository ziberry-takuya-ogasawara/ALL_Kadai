package No11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author ogasawara
 * @version 1.0
 *
 */
public class TestPoint {

	public static void main(String args[]) {

		ArrayList<KyoukaTennsu>objList = input();
		Display(objList);
	}

	public static ArrayList<KyoukaTennsu> input(){
		String keyin = null;
		String name = null;
		ArrayList<KyoukaTennsu>objList = new ArrayList<KyoukaTennsu>();

		x:while(true) {
			KyoukaTennsu obj = new KyoukaTennsu();

			//教科入力
				System.out.println("教科は");
				keyin = keyin();

				 if(JudgmentChange(keyin)) {
						System.out.println("氏名");
						name = keyin();
						obj.setName(name);
						continue;
					}

				if(JudgmentEnd(keyin)) {
					break x;
				}
				//重複がある場合処理終了
				if(objList.size() != 0) {
					if(JudgmentKyoukaZyuuhuku(keyin,objList)) {
						System.out.println("既に登録されている教科の為、処理を終了します。");
						System.exit(0);
					}
				}
				obj.setKyouka(keyin);

				//点数入力
			while(true) {
				System.out.println("点数は");
				keyin = keyin();

				if(JudgmentChange(keyin)) {
					System.out.println("氏名");
					name = keyin();
					obj.setName(name);
					continue;
				}

				if(JudgmentEnd(keyin)) {
					break x;
				}
				try {
					int x = Integer.parseInt(keyin);
					if(x >= 101) {
						System.out.println("入力点数が100点を超えています。0~100までの数値を入力してください。");
						continue;
					}else if(x <= -1) {
						System.out.println("入力点数が0点よりも小さいです。0~100までの数値を入力してくだい。");
						continue;
					}
					//半角チェック 全角なら実行
					if(!JudgmentZenkaku(keyin)) {
						System.out.println("入力数値が全角です。");
						continue;
					}
					obj.setTennsu(keyin);
					break;
				}catch(NumberFormatException e) {
					System.out.println("数値を入力してください。");
					continue;
				}
			}
			if(name == null) {
				System.out.println("氏名");
				name = keyin();
				obj.setName(name);
			}else {
				obj.setName(name);
			}

			objList.add(obj);
		}
		return objList;
	}


	public static void Display(ArrayList<KyoukaTennsu>objList) {
		String kyouka = null;
		String tennsu = null;
		String name = null;
		String tab = "\t:";
		for(int i = 0 ; i<objList.size() ; i++ ) {
			kyouka = objList.get(i).getKyouka();
			tennsu = objList.get(i).getTennsu();
			name = objList.get(i).getName();
			System.out.println(name+tab+kyouka+tab+tennsu);
		}
	}

	/**キーボード入力をし
	 * @return String キーボード入力
	 */
	public static String keyin() {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String keyin = null;

		try {
			keyin = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keyin;
	}

	/**
	 * 全角半角を区別せずに引数と入力教科の重複を判定する。
	 * 重複の場合true,非重複の場合はfalse
	 * @param keyin
	 * @return boolean
	 */
	public static boolean JudgmentKyoukaZyuuhuku(String keyin,ArrayList<KyoukaTennsu>objList) {

		for(int i = 0 ; i < objList.size() ;i++ ) {
			if(objList.get(i).getKyouka().equalsIgnoreCase(keyin)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 全角半角を区別せずに"change"と比較し、一致した場合true,不一致ならfalse
	 * @param String keyin
	 * @return boolean
	 */
	public static boolean JudgmentChange(String keyin) {

		if(keyin.equalsIgnoreCase("change")) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 全角半角を区別せずに"end"と比較し、一致した場合true,不一致ならfalse
	 * @param String keyin
	 * @return boolean
	 */
	public static boolean JudgmentEnd(String keyin) {

		if(keyin.equalsIgnoreCase("end")) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 引数がすべて半角ならtrue,それ以外はfalse
	 * @param keyin
	 * @return boolean
	 */
	public static boolean JudgmentZenkaku(String keyin) {

		if(Pattern.compile("^[0-9]+$").matcher(keyin).find()) {
			return true;
		}else {
			return false;
		}

	}


}
