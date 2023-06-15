package test;
import java.util.*;
public class hw1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("請輸入計概成績：");
		int score1 =  Integer.parseInt(scn.next());
		System.out.print("請輸入Java成績：");
		int score2 = Integer.parseInt(scn.next());
		System.out.print("請輸入電子學成績：");
		int score3 = Integer.parseInt(scn.next());
		scn.close();
		float avg = (float)(score1 + score2 + score3)/ 3;
		System.out.printf("平均分數 =%6.2f" ,avg);
	}

}
