package week9;
import java.util.*;


class BankException extends Exception{
	public void showError() {
		System.out.println("帳號設定錯誤!");
	}
}

class Bbank
{
   public static void isNegative(int b) throws BankException
   {
      if(b<0)
      {
         throw new BankException();
      }
      else
    	  System.out.println();
   }

}

public class HW {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("設定 Jack 的帳戶!");
		System.out.print("帳戶編號：");
		String ID = scn.next();
		System.out.print("客戶姓名：");
		String name = scn.next();
		System.out.print("帳戶餘額：");
		int balance = scn.nextInt();
		try {
			Bbank.isNegative(balance);
		}
		catch(BankException e)
		{
			e.showError();
		}
		scn.close();
		
	      }
}
