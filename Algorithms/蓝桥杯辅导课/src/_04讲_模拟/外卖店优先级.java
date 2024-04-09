package _04��_ģ��;

import java.util.*;
//��������
public class ���������ȼ� {
	static int INF = 0x3f3f3f3f;
	static int N = 10100,M = 2*N;
	static int n,m,t;
	static int[] vis = new int[N];
	static int[] score = new int[N];

	//�ռ��TLE
	//order[i][j]=k��ʾʱ��i����j��k������
	static int[][] order = new int[N][N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		while(m-->0) {
			order[sc.nextInt()][sc.nextInt()]++;
		}
		
		for(int i=1;i<=t;i++) {
			for(int j=1;j<=n;j++) {
				if(order[i][j]>0) 
					score[j] += order[i][j]*2;
				else
					score[j]--;
				if(score[j]<0) score[j]=0;
				if(score[j]>5)
					vis[j] = 1;
				if(score[j]<=3)
					vis[j] = 0;
			}
		}
		int ans = 0;
		for(int i=1;i<=n;i++)
			ans+=vis[i];
		System.out.println(ans);
	}
}
