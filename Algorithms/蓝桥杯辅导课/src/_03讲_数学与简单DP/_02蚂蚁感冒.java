package _03��_��ѧ���DP;

import java.util.*;
import java.math.*;
import java.io.*;

public class _02���ϸ�ð {
		static int INF = 0x3f3f3f3f;
		static int N = 101 , M = 2*N;
		static Integer[] arr = new Integer[N];
		static int n,m;
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			//��������ߵ����ϡ��ұ����ҵ�һ�����ᱻӰ��
			int left=0,right=0;//�ֱ��ʾ��������ߵ��������������ұ������ߵ���������
			for(int i=1;i<n;i++) {
				if(Math.abs(arr[i])<Math.abs(arr[0]) && arr[i]>0)//ͳ����������ߵ�����
					left++;
				else if(Math.abs(arr[i])>Math.abs(arr[0]) && arr[i]<0)
					right++;
			}
			int ans=1;
			if(arr[0]>0) {//��Ⱦ��������
				ans += right;//��ʱ���ұ������ߵ�һ���н���
				if(right>0) ans += left;//�ұ������ߵ�����ֻҪ���ڣ���ô������ҵľͻ�ȫ�������档���򲻻ᱻӰ��
			}else {//��Ⱦ��������
				ans += left;
				if(left>0) ans += right;
			}
			System.out.println(ans);
			
		}
}
