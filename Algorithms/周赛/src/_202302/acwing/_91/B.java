package _202302.acwing._91;
import java.util.*;

import javax.management.MXBean;

import java.math.*;
import java.io.*;

public class B {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int[][] arr = new int[N][3];
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			int last = 0;
			for(int i=1;i<=m;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[i][0] = a;
				arr[i][1] = b;
			}
			
			for(int i=1;i<=m;i++) {
				int a = arr[i][0];
				int b = arr[i][1];
				if(a==last) {
					int cnt=2;
					i++;
					while(i<=m && arr[i][0]==last) {
						cnt++;
						i++;
					}
					System.out.println(a+" "+cnt);
					return ;
				}else if(a > last+1) {
					System.out.println(last+1+" 0");
					return;
				}
				last = b;
				if(i==m) {
					if(b<n) {
						System.out.println(b+1+" 0");
					}else 
						System.out.println("OK");
				}
			}
			
		}
}
class Solution {
	int pow(int a,int b){
        int res = 1;
        while(b>0){
            if((b&1)>0) res *= a;
            a*=a;
            b>>=1;
        }
        return res;
    }
    public int minMaxDifference(int num) {
    	int n = num,mx=-1,cnt=0;
    	int ans1=0,ans2=0;
    	while(n>0) {
    		mx = n%10;
            // System.out.println(n%10);
    		n/=10;
    		cnt++;
    	}
    	n = num;
    	int idx=0;
    	while(idx<cnt) {
    		int x = n/pow(10,cnt-idx-1),x2;
//            System.out.println(x);
    		if(x==mx)
    			x=9;
    		if(x==mx) 
    			x2=0;
    		ans1 = ans1*10 + x;
    		ans2 = ans2*10 + x;
            n%=pow(10,cnt-idx-1);
            idx++;
    	}
    	System.out.println(ans1);
    	System.out.println(ans2);

        return 0;
    }
}

