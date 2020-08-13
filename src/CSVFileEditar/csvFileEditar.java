package CSVFileEditar;
import java.io.*;
import java.util.*;
public class csvFileEditar {

	private static ArrayList<String>input_CSVList = new ArrayList<String>();


	public static void main(String args[]) {
		inputCSV();
		exportCsv();
	}


	public static void inputCSV() {
		try {
			// Fileクラスに読み込むファイルを指定する
			File file = new File("C:\\files/input.csv");
			// ファイルが存在するか確認する
			if (file.exists()) {
				//文字コードを指定して読み込み
				BufferedReader readForinput_csv =
						new BufferedReader(new InputStreamReader(new FileInputStream(file),"Shift-JIS"));

				/*読み込んだcsvをreadLine()で一行ずつ読み込む。
				 * readLine()で読み込みがなくなる　＝　null がかえってくるまでループ
				*/
				String data;
				while ((data = readForinput_csv.readLine()) != null) {
					String str = String.valueOf(data);
					input_CSVList.add(str);
				}

				for(int i = 0 ; i < input_CSVList.size(); i++) {
					System.out.println(input_CSVList.get(i));
				}

				// ファイルクローズ
				readForinput_csv.close();

			} else {
				System.out.print("ファイルは存在しません");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}



	public static void exportCsv(){

		try {

			//テストの為今は直節入力
			String[] prodaktcodeList = {"99999999","88888888"};
			String[] prodaktNunber = {"99","88"};

			// 出力ファイルの作成
			PrintWriter p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:\\files/output.csv", false),"Shift-JIS")));

			// ヘッダーを指定する　今はテスト段階
			p.print("プロダクトコード");
			p.print(",");
			p.print("プロダクト管理番号");

			p.println();
			// 内容をセットする
			for(int i = 0; i < prodaktcodeList.length; i++){
				p.print(prodaktcodeList[i]);
				p.print(",");
				p.print(prodaktNunber[i]);
				p.println();    // 改行
			}
			// ファイルに書き出し閉じる
			p.close();
			System.out.println("ファイル出力完了！");
		} catch (Exception e) {
			System.out.println(e);
		}

	}


}
