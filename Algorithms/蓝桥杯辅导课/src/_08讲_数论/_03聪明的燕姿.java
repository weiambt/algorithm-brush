package _08讲_数论;
import java.util.*;
import java.math.*;
import java.io.*;

public class _03聪明的燕姿 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int n,m;
		static HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
		static void divide(int x) {
			for(int i=2;i<=x/i;i++) {
				if(x%i==0) {
					int cnt = 0;
					while(x%i==0) {
						cnt++;
						x/=i;
					}
					mp.put(i,cnt);
				}
			}
			if(x>1) 
				mp.put(x,1);
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = (int)2e9-1;
			divide(n);
			for(Integer key:mp.keySet())
				System.out.println(key+" "+mp.get(key));
		}

}
