package _202302.acwing._104;


import java.util.*;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int[] st = new int[N];
	static long a,b;
	static long count(long u) {
		if(u==0) return 1;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while(u>0) {
			nums.add((int) (u%2));
			u/=2;
		}
		int n = nums.size();
		int cnt = 0,res = 0;
		for(int i=n-1;i>=0;i--) {
			int x = nums.get(i);
			if(x==0) {
				cnt++;
				if(cnt>1)
					break;
				if(i==0) res++;
			}
			else {
				if(cnt==0)
					res += i;
				else if(cnt==1)
					res++;
			}
			System.out.println(i+" "+res);
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		a = sc.nextLong();
		b = sc.nextLong();
		System.out.println(count(b)-count(a-1));
		
	}
}

