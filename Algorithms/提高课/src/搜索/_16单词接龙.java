package 搜索;

import java.util.*;
import java.math.*;
import java.io.*;
public class _16单词接龙 {
	static int INF = 0x3f3f3f3f;
	static int N = 50 , M = 2*N;
	static int n,ans;
	static char start;
	static int[][] minCommonLen = new int[N][N];
	static char[][] words = new char[N][N];
	static int[] cnt = new int[N];
	
	static void dfs(String finalStr,int lastWordIdx) {
		ans = Math.max(ans,finalStr.length());
		for(int i=0;i<n;i++) {
			int len = minCommonLen[lastWordIdx][i];
			if(len!=0 && cnt[i]<=1) {
				cnt[i]++;
				dfs(finalStr+new String(words[i]).substring(len),i);//去除公共部分
				cnt[i]--;
			}
		}
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++)
			words[i] = sc.next().toCharArray();
		start = sc.next().toCharArray()[0];
		//预处理两个单词的最小重合部分长度
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int len = Math.min(words[i].length,words[j].length);
				for(int k=1;k<len;k++) {
					String a = new String(words[i]);
					String b = new String(words[j]);
					if(a.substring(a.length()-k, a.length()).equals(b.substring(0, k))) {
//						System.out.println(i+","+j+":"+k);
						minCommonLen[i][j] = k;
						break;		
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			if(words[i][0]==start) {
				cnt[i]++;
				dfs(new String(words[i]),i);
				cnt[i]--;
			}
		}
		System.out.println(ans);

	}
}
