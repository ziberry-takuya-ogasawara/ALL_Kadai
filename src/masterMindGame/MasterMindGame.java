package masterMindGame;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * 各桁が重複しない四桁の数字を生成。その後キーボードからの入力値と比較し、<br>
 * 数値と桁の位置がすべて一致した場合にシステムを終了。
 * @author takuya
 * @version 1.1
 */
public class MasterMindGame {
/**
 * システム実行
 * @param args
 */
	public static void main(String[] args) {
		//MasterMindGame
		PlayGame playGame = new PlayGame();
		playGame.Play();
	}

}
