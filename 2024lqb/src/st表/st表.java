package st��;

import java.util.*;
import java.io.*;
import java.math.*;

public class st�� {
	static int INF = Integer.MAX_VALUE;
	static int N = 101000,M = 20;
	static int[] arr = new int[N];
	//f[i][j]��ʾ�ӽڵ�i��ʼ����2^j��Ԫ�ص��������ֵ������[i,i+2^j-1]
	static int[][] f = new int[N][M];
	static int n,m;
	static long ans;
	//https://www.luogu.com.cn/problem/P3865
	//��ʼ��st��O��nlogn��
	static void init() {
		//������1��������Ǳ���
		for(int i=1;i<=n;i++)
			f[i][0] = arr[i];
		//�ֳ�����������
		for(int j=1;j<M;j++) 
			for(int i=1;i+(1<<j)-1 <= n;i++) 
				f[i][j] = Math.max(f[i][j-1],f[i+(1<<(j-1))][j-1]);
	}
	//��ѯst��O��1��
	static int query(int l,int r) {
		//��������[l,r]�����2���ݿ�ȣ�l+2^k-1 <= r��
		int k = (int) (Math.log(r-l+1)/Math.log(2));
		//��Ϊ����������
		int res = Math.max(f[l][k],f[r-(1<<k)+1][k]);
		return res;
	}
	public static void main(String[] args) throws IOException {
		Read sc = new Read();
		PrintWriter out = new PrintWriter(System.out);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) 
			arr[i] = sc.nextInt();
		init();
		
		for(int i=1;i<=m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			out.println(query(a, b));
		}
		out.flush();
	}
}

class Read{
	StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//	
//	
	int nextInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	String getLine() throws IOException {
		return r.readLine();
	}
}

