package _04��_ģ��;

import java.util.*;

public class �ƶ����� {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int w,m,n;
	static int[] arr = new int[N];

	static int[] h = new int[N];//��
	static int[] l = new int[N];//��

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		m = sc.nextInt();
		n = sc.nextInt();
		
		if(m>n) {
			int t = m;
			m = n;
			n = t;
		}
		h[1] = 1;l[1]=1;
		int hang=1,lie=2,flag=1;

		for(int i=2;i<=n;i++) {
			if(i%w==1) {
				hang++;
				flag=0;
			}
			if(lie>w)lie = w;
			if(lie<1) lie = 1;
			h[i] = hang;
			l[i] = lie;
			if(flag==1)
				lie++;
			else lie--;
		}
		System.out.println(h[n]-h[m]+l[n]-l[m]);
	}
}
