package 例题;

import java.util.*;
import java.math.*;
import java.io.*;

public class 中位数 {
		static int INF = 1000000007;
		static int N = 101000 , M = 2*N;
		static int n,m,ans;
		
		public static void main(String[] sss) {
			PriorityQueue<Integer> q1 = new PriorityQueue<Integer>((a,b)->(a-b));
			PriorityQueue<Integer> q2 = new PriorityQueue<Integer>((a,b)->(b-a));
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			int mid = sc.nextInt();
			System.out.println(mid);
			
			for(int i=2;i<=n;i++) {
				int x = sc.nextInt();
				if(x<mid) q2.add(x);
				else q1.add(x);
				if(i%2==1) {
					while(q1.size()!=q2.size()) {
						if(q1.size()>q2.size()) {
							q2.add(mid);
							mid = q1.poll();
						}else {
							q1.add(mid);
							mid = q2.poll();
						}
					}
					System.out.println(mid);
				}
			}
		}
		
}

