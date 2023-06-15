package week7;
import java.util.*;

interface IPass {
	final int Collage_pass = 60;
	final int Graduate_pass = 70;
	String pass();
}

class Collage implements IPass{
	private int score;
	Collage(int score) {
		this.score = score;
	}
	public String pass() {
		if(this.score >= Collage_pass)
			return "及格";
		else
			return "不及格";
	}
	
}

class Graduate implements IPass{
	private int score;
	Graduate(int score) {
		this.score = score;
	}
	public String pass() {
		if(this.score >= Graduate_pass)
			return "及格";
		else
			return "不及格";
	}
}


public class HW{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("輸入學期分數：");
		int score = scn.nextInt();
		scn.close();
		Collage c = new Collage(score);
		Graduate g = new Graduate(score);
		System.out.println("大學成績： "+c.pass());
		System.out.println("研究所大學成績： "+g.pass());
	}
}