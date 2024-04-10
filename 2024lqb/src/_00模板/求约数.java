package _00模板;
import java.util.*;

public class 求约数 {
	static int N = 1010000;
	static int[] st = new int[N];
	static ArrayList<Integer> yue = new ArrayList<Integer>();
	
	static void getYue(int x) {
		for(int i=2;i<=x/i;i++) {
			if(x%i==0) {
				yue.add(i);
				if(x/i!=i)
					yue.add(x/i);
			}	
		}
		yue.sort((a,b)->(a-b));
		
	}
	public static void main(String[] args) {
		getYue(12);
		for(Integer x:yue)
			System.out.println(x);
	}
}
