package _202302.acwing._101;


import java.util.*;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static String[] ans = new String[N];
	static int n;

	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = sc.nextInt();
		Map<String,Integer> mp = new HashMap<String,Integer>();
		
		for(int i=0;i<n;i++) {
			String s = sc.next();
			mp.put(s,i);

		}
		for(String i:mp.keySet()) {
			ans[mp.get(i)] = i;
		}
		for(int i=n-1;i>=0;i--) {
			if(ans[i]!=null)
				System.out.println(ans[i]);
		}
		
	}
}

