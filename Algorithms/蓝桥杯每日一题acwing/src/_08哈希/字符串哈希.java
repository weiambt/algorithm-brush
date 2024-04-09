package _08��ϣ;

import java.util.*;
import java.math.*;
import java.io.*;

public class �ַ�����ϣ {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static char[] str = new char[N];
	static int[] hash = new int[N],pow = new int[N];
	static int n,m;
	static int P = 131;
	//�����Ӵ��Ĺ�ϣֵ
	static int query(int l,int r) {
		return hash[r] - hash[l-1]*pow[r-l+1];
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		String string = " "+sc.next();
		str = string.toCharArray();
		pow[0]=1;
		hash[0]=0;
		for(int i=1;i<=n;i++) {
			hash[i] = hash[i-1]*P + str[i];
			pow[i] = pow[i-1]*P;//Ԥ����η�
		}

		while(m-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			if(query(a,b) == query(c,d)) System.out.println("Yes");
			else System.out.println("No");
		}
	}
}
