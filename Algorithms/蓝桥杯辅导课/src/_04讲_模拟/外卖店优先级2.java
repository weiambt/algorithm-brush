package _04讲_模拟;

import java.util.*;
//优化做法
public class 外卖店优先级2 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int n,m,t;
	static PII[] order = new PII[N];

	static int[] vis = new int[N];
	static int[] score = new int[N];
	static int[] last = new int[N];


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		for(int i=1;i<=m;i++) {
			order[i] = new PII(sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(order,1,m+1);
		
		for(int i=1;i<=m;i++) {
			int time = order[i].time,id = order[i].id;
			//1.计算中间无订单的天数的损耗
			score[id] -= time - last[id]-1;
			if(score[id]<0) score[id]=0;
			//2.计算当前订单的贡献
			score[id] += 2;
			
			//3.维护缓存
			if(score[id]>5) vis[id] = 1;
			if(score[id]<=3) vis[id] = 0;
			
			last[id] = time;
		}
		//在t时刻再次计算损耗
		for(int i=1;i<=n;i++) {
			if(last[i]!=t)
				score[i] -= t-last[i];
			if(score[i]<=3)
				vis[i] = 0;
		}
		
		
		//计算缓存个数
		int ans = 0;
		for(int i=1;i<=n;i++)
			ans+=vis[i];
		System.out.println(ans);
	
	}
}
class PII implements Comparable<PII>{
	int id,time;
	public PII(int time,int id) {
		this.time = time;
		this.id = id;
	}
	@Override
	public int compareTo(PII o) {
		return time-o.time;

	}
}
