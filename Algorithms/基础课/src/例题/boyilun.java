package ����;

import java.util.*;
import java.math.*;
import java.io.*;

public class boyilun {
		static int INF = 1000000007;
		static int N = 101000 , M = 2*N;
		static PII[] arr = new PII[N];
		static int n,m,ans;
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[i] = new PII(a,b);
			}
			Arrays.sort(arr,1,n+1,(a,b)->(a.l-b.l));
			//ʹ��С����ά����������Ҷ˵����Сֵ
			//���Ѿ����ڵ����У�û���Ҷ˵�ȵ�ǰ�������˵�С�ģ���ô���¿�һ����
			//					    ���Ҷ˵�ȵ�ǰ�������˵�С�ģ���ô�ͼӵ��������
			//�öѵ�ԭ��ֻ��Ҫ�ж����������Ƿ����һ������Ҷ˵����С������ֱ��ά���Ҷ˵����Сֵ����
			PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b)->(a-b));
			for(int i=1;i<=n;i++) {
				PII now = arr[i];
				//��ǰ��������Ҷ˵���Сֵ����˵����ô���½���
				if(q.size()==0 || q.peek()>=now.l) {
					q.add(now.r);
					ans++;
				}else {//����ͼ��뵽�Ҷ˵���С�����У�������ʵ�ӵ���һ�鶼��һ���ģ�Ϊ�˷�����뵽��С�����У�
					q.poll();
					q.add(now.r);
				}
			}
			System.out.println(ans);
		}
		
}
class PII{
	int l,r;
	public PII(int l,int r) {
		// TODO Auto-generated constructor stub
		this.l = l;
		this.r = r;
	}
}
