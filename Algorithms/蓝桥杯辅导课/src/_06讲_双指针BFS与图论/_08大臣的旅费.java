package _06讲_双指针BFS与图论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _08大臣的旅费 {
    static int INF = 0x3f3f3f3f;
    static int N = 110000 , M = 2*N;
    static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
    static int idx,n,ans = 0;
    static int[] dist = new int[N];
    //计算向下最大深度
    static int getLongest(int u,int fa) {
    	int mx = 0,d2 = 0;	
		for(int i = h[u];i!=-1;i=ne[i]) {
			int j = e[i];
			if(j==fa) continue;
			int len = getLongest(j,u)+w[i];
			if(len>mx) {
				d2 = mx;
				mx = len;
			}else if(len>d2) {
				d2 = len;
			}
		}
		ans = Math.max(ans, mx+d2);

		return mx;
    }
    static void add(int a,int b,int c) {
    	e[idx] = b;
    	w[idx] = c;
    	ne[idx] = h[a];
    	h[a] = idx++;
    }
    static void init() {
    	Arrays.fill(h, -1);
    }

    public static void main(String[] sss) {
        Scanner sc = new Scanner(System.in);
        init();
        n = sc.nextInt();
        for(int i=0;i<n-1;i++) {
        	int a,b,c;
        	a = sc.nextInt();
        	b = sc.nextInt();
        	c = sc.nextInt();
        	add(a, b, c);
        	add(b, a, c);
        }
        getLongest(1, -1);
        long f = (long)ans*(ans+1)/2 + 10*ans;
        
        System.out.println(f);
    }
}