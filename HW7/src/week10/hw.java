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
		System.out.println("��ƫظm��......");
		System.out.println("�q���q15~55����Ƥ��A�üƨ��X5�Ӥ����ƪ����X....");
		while(tset.size()<5) {
			int randnum = (int)(Math.random()*40)+15;
			if(tset.contains(randnum)==false)
				tset.add(randnum);
		}
		alist.addAll(tset);
		System.out.println("alist �ثe�������e�G"+alist);
		System.out.println("���J15,30,55�T�Ӥ���...");
		insert(alist, 15);
		insert(alist, 30);
		insert(alist, 55);
		System.out.println("alist �ثe�������e�G"+alist);
		System.out.println("�N���ޭȬ�4���������e�אּ9999�C");
		alist.set(4,9999);
		System.out.println("alist �ثe�������e�G"+alist);
	}
}
