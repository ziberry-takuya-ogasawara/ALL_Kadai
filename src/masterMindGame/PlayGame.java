package masterMindGame;

import java.util.Scanner;

public class PlayGame {

	public void Play() {

		//挑戦回数のカウント変数
		int challenginCount = 0;
		Scanner sc = new Scanner(System.in);
		Motion motion = new Motion();

		//1以上10未満のランダムな四桁の数値を生成
		int[] randomNumbers = motion.randomNumberCreater();
		while(true) {
			//回答を入力
			int[] anserNumbers = motion.inputAnser(sc);
			//数値のみの一致回数を判定
			int partialMatchCount = motion.partialMatch(randomNumbers,anserNumbers);
			//数値と位置の一致回数を判定
			int perfectMatchingcount = motion.perfectMatching(randomNumbers,anserNumbers);
			//挑戦回数をカウント
			challenginCount++;
			//クリア判定
			if(perfectMatchingcount == 4) {
				System.out.println(challenginCount+"回でクリアです。");
				break;
			}
			System.out.println("場所と値が同じ数:"+perfectMatchingcount);
			System.out.println("値がだけが同じ数:"+partialMatchCount);
		}
		sc.close();
	}
}
