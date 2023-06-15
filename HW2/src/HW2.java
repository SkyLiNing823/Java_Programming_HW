import java.util.*;
public class HW2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = -1;
		int sum = 0;
		while(true) {
			sum = 0;
			System.out.print("請輸入正整數，計算1到該數的總合(輸入0結束)：");
			n =  scn.nextInt();
			if(n == 0)
				break;
			for(int i = 1; i <= n; i++)
				sum += i;
			System.out.printf("1 到 %d 的總合 = %d\n", n, sum);
		}
		scn.close();
	}

}
