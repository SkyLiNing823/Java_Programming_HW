package week5;

class Cstudent{
	public int height;
	public int weight;

	public Cstudent()
    {
        this.height = 150;
        this.weight = 40;
    }
	public Cstudent(int height)
    {
        this.height = 150;
        this.weight = 40;
    }
	public Cstudent(int height, int weight)
    {
        this.height = height;
        this.weight = weight;
    }
	
}
public class hw {
	public static void main(String[] args) {
		Cstudent Peter = new Cstudent();
		System.out.println("Peter的資料>>> 使用Cstudent()建構式");
		System.out.println("身高是:"+ Peter.height+",體重是:"+Peter.weight);
		Cstudent David = new Cstudent(300);
		System.out.println("David的資料>>> 使用Cstudent(300)建構式");
		System.out.println("身高是:"+ David.height+",體重是:"+David.weight);
		Cstudent Mary = new Cstudent(180,78);
		System.out.println("Peter 的資料>>> 使用Cstudent(180,78)建構式");
		System.out.println("身高是:"+ Mary.height+",體重是:"+Mary.weight);
	}

}