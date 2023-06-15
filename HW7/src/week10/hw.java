package week10;
import java.util.*;

public class hw {
	public static void insert(ArrayList<Object> alist, int n){
		int i;
		for(i =0; i<alist.size();i++) {
			if((int)alist.get(i) > n)
				break;
		}
		alist.add(i,n);
	}
	public static void main(String[] args) {
		var tset = new TreeSet<>();
		var alist = new ArrayList<>();
		int i;
		System.out.println("資料建置中......");
		System.out.println("電腦從15~55的整數中，亂數取出5個不重複的號碼....");
		while(tset.size()<5) {
			int randnum = (int)(Math.random()*40)+15;
			if(tset.contains(randnum)==false)
				tset.add(randnum);
		}
		alist.addAll(tset);
		System.out.println("alist 目前元素內容："+alist);
		System.out.println("插入15,30,55三個元素...");
		insert(alist, 15);
		insert(alist, 30);
		insert(alist, 55);
		System.out.println("alist 目前元素內容："+alist);
		System.out.println("將索引值為4的元素內容改為9999。");
		alist.set(4,9999);
		System.out.println("alist 目前元素內容："+alist);
	}
}
