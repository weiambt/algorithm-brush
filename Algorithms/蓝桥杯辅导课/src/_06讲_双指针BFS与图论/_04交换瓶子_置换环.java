package _06��_˫ָ��BFS��ͼ��;

import java.util.*;
import java.math.*;
import java.io.*;

public class _04����ƿ��_�û��� {
	static int INF = 0x3f3f3f3f;
	static int N = 10010 , M = 2*N;
	static int[] arr = new int[N];
	static int[] vis = new int[N];
	static int n,m;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		int k=0;//��¼��ʼ���ж����»�
		for(int i=1;i<=n;i++) {
			if(vis[i]==0) {//û�����ʹ������»�
				k++;
				for(int j=i;vis[j]==0;j=arr[j]) {//����������
					vis[j]=1;
				}
			}
		}
		//��ʼ��k��������������n����
		//ÿһ���û�������1��������ô����Ҫ����n-k��
		System.out.println(n-k);
		
	}
}
