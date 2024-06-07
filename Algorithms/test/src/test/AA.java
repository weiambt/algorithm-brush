package test;

import java.util.*;
import java.io.*;
import java.math.*;

public class AA {
	static int INF = Integer.MAX_VALUE;
	static int mod = 1000000007 ;
	static int N = 3010000,M = 2*N;
	static long[][] dp = new long[N][22];
	static int n,m;
	static long ans;
  static int gcd(int a,int b){
    return b==0?a:gcd(b,a%b);
  }
	
	static void solve() {
		n = 21;
    dp[1][0] = 1;
    for(int mask = 0;mask < (1<<n);mask ++ ){
      for(int last = 0;last<n;last++){
        if((mask>>last&1)==0 ) continue;
        for(int j=0;j<n;j++){
          if((mask>>j&1)==0 || j==last || gcd(last+1,j+1)!=1) continue;
//          System.out.println(mask & ~(1<<last));
          dp[mask][last] += dp[mask & ~(1<<last)][j];
//          System.out.println(mask +" "+last+" "+dp[mask][last]);
          
        }
        if(mask == (1<<n)-1 && last!=0) ans += dp[mask][last];
      }
    }
    System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		
    solve();
	}

	static Scanner sc = new Scanner(System.in);

}

