package _11Tire;
import java.util.*;
import java.math.*;
import java.io.*;

public class ������� {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 31*N;
		static int[] arr = new int[N];
		static int[][] son = new int[M][2];
		static int n,m,idx,ans;
		//�����ֵ����д�ŵ��Ƕ�������
		//�ֵ����в���һ����x
		static void insert(int x) {
			int p=0;
			for(int i=30;i>=0;i--) {//int���з��������������31λ����0~30
				int u = x>>i&1;//������ĵ�iλ����λֵ��u
				if(son[p][u]==0)//�����ھʹ���
					son[p][u] = ++idx;
				p = son[p][u];
			}
		}
		//��ѯx����֪���ֵ������ҵ����������ֵ
		static int query(int x) {
			int p=0,res = 0;
			for(int i=30;i>=0;i--) {
				int u = x>>i&1;//��һλ��u������0����1��
				//Ϊ��ʹ�����ֵ�����ô��Ҫ��һ����u��ͬ�ģ��������ܱ�֤��һλ�����ֵ��1
				if(son[p][u==0?1:0]!=0) {//����������������
					res += 1<<i;//��ʱ�ҵ������������һλ���x����һλһ����1������ʮ���ƴ𰸵Ĺ��׾���2^i
					p = son[p][u==0?1:0];
				}else
					p = son[p][u];
			}
			return res;
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
				insert(arr[i]);
			}
			for(int i=1;i<=n;i++) {
				int mx = query(arr[i]);
				ans = Math.max(ans, mx);
			}
			System.out.println(ans);
		}
}
