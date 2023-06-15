package week11;
class ThreadG extends Thread
{
	score Score;
	int N;
	public ThreadG(score s, int n)
	{
		this.Score = s;
		this.N = n;
	}
	public void run() 
	{
		Score.change(N);
		
	}
}

class score{
	int S;
	public score(int SC) {
		this.S = SC;
	}
	public synchronized void change(int s){
		int d_s = this.S;
		System.out.println("葛來分多學院目前總分 ："+d_s);
		if(s>=0)
			System.out.println("葛來分多加分："+s+"分");
		else
			System.out.println("葛來分多扣分："+s+"分");
		System.out.println("分數紀錄中 .....");
		try {
		Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		d_s += s;
		if(d_s < 0)
			d_s = 0;
		System.out.println("葛來分多學院分數計算後： "+d_s+" 分\n");
		this.S = d_s;
	}
}

public class HW {
	public static void main(String[] args) {
		score s = new score(0);
		ThreadG th1=new ThreadG(s, 5);
		ThreadG th2=new ThreadG(s, 2);
		ThreadG th3=new ThreadG(s, -8);
		ThreadG th4=new ThreadG(s, 10);
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		try {
			th1.join();
			th2.join();
			th3.join();
			th4.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		
		System.out.println("--------------------------------------");
		System.out.println("葛來分多學院最終分數： "+s.S+"分");
	}
}
