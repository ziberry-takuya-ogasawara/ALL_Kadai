package masterMindGame;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Motion {
	/**
	 *
	 * @return randomNumbers int[]型 1～9までの数値で構成され、各桁が重複しない四桁の数値。
	 */
	public int[] randomNumberCreater() {
		//1以上10未満のランダムな数字を生成。
		Random random = new Random();
		int[] randomNumbers = new int[4];

		//一桁目を生成
		randomNumbers[0] = random.nextInt(9)+1;
		//二桁目を生成
		while(true) {
			randomNumbers[1] = random.nextInt(9)+1;
			if(randomNumbers[1] == randomNumbers[0]) {
				continue;
			}
			break;
		}
		//三桁目を生成
		while(true) {
			randomNumbers[2] = random.nextInt(9)+1;
			if(randomNumbers[2] == randomNumbers[0] || randomNumbers[2] == randomNumbers[1]) {
				continue;
			}
			break;
		}
		//四桁目を生成
		while(true) {
			randomNumbers[3] = random.nextInt(9)+1;
			if(randomNumbers[3] == randomNumbers[0] || randomNumbers[3] == randomNumbers[1] || randomNumbers[3] == randomNumbers[2]) {
				continue;
			}
			break;
		}
		return randomNumbers;
	}
	/**
	 *
	 * @param sc コンソール入力の為のインスタンス
	 * @return anserNumbers int[]型四桁の数値で構成される回答。
	 */
	public int[] inputAnser(Scanner sc) {
		int[] anserNumbers = new int[4];
		String anser = null;
		//回答を入力
		while(true) {
			System.out.print("四桁の数字を入力してください(1111~9999)>");
			anser = sc.next();
			//エラー処理
			//入力値が数値である判定
			Integer.parseInt(anser);
			//入力数値の桁数判定
			if(anser.length() != 4) {
				System.out.println("四桁の数字ではありません。");
			}else if(!Pattern.matches("[0-9]*$",anser)){
				System.out.println("数字ではありません。数字を入力してください。");
			}else {
				break;
			}
		}
		//入力数字を一桁ずつ格納

		for(int i = 0 ; i<anser.length() ; i++) {
			anserNumbers[i] = Integer.parseInt(anser.substring(i,i+1));
		}
		return anserNumbers;

	}
	/**
	 *
	 * @param randomNumbers RandomNumberCreaterによって生成された正答数字。
	 * @param anserNumbers InputAnserによって入力された回答数字。
	 * @return partialMatchCount int型 値のみの一致数をカウント。
	 */
	public int partialMatch(int[] randomNumbers,int[] anserNumbers) {
		int partialMatchCount = 0;
		//値だけの一致回数をカウント
		for(int i = 0 ; i< randomNumbers.length ; i++) {
			if( randomNumbers[i] == anserNumbers[0] || randomNumbers[i] == anserNumbers[1] || randomNumbers[i] == anserNumbers[2] || randomNumbers[i] == anserNumbers[3])
				partialMatchCount++;
		}
		return partialMatchCount;
	}
	/**
	 *
	 * @param randomNumbers RandomNumberCreaterによって生成された正答数字。
	 * @param anserNumbers InputAnserによって入力された回答数字。
	 * @return perfectMatchungCount int型 値と位置の一致数をカウント。
	 */
	public int perfectMatching(int[] randomNumbers,int[] anserNumbers) {
		int perfectMatchungCount = 0;
		//値と場所が同じ回数をカウント
		for(int i = 0 ; i<randomNumbers.length ; i++) {
			if(randomNumbers[i] == anserNumbers[i]) {
				++perfectMatchungCount;
			}
		}
		return perfectMatchungCount;

	}
}
