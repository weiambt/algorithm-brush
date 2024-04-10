package _00模板;
import java.util.*;

public class 分解质因数 {
	static TreeMap<Integer,Integer> mp = new TreeMap<Integer, Integer>();
	static void divide(int x) {
		for(int i=2;i<=x/i;i++) {
			if(x%i==0) {
				int cnt = 0;
				while(x%i==0) {
					x /= i;
					cnt += 1;
				}
				mp.put(i,cnt);
			}
		}
		if(x>1)
			mp.put(x,1);
	}
	public static void main(String[] args) {
		divide(12);
		for(Integer a:mp.keySet())
			System.out.println(a+" "+mp.get(a));
	}
}
