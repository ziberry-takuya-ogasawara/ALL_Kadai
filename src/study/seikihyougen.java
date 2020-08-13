package study;

import java.util.regex.Pattern;

public class seikihyougen {

	public static void main(String args[]) {

		String str  ="85a";

	boolean answer = Pattern.compile("[a-z]+").matcher(str).find();
	System.out.println(str.matches("[a-z0-9]+"));
	System.out.println(str.matches("[a-z]"));
	System.out.print(answer);

	}

}
