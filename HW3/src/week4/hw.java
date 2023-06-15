package week4;
import java.util.Random;

public class hw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("本期四星彩開獎號碼如下：\n");
		Random r = new Random();
		for(int i = 0;i<4;i++)
		{
			System.out.print(r.nextInt(9));
			System.out.print(' ');
		}
	}

}
