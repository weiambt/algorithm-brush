package _03讲_数学与简单DP;

import java.util.*;
import java.math.*;
import java.io.*;

public class _02蚂蚁感冒 {
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
			//左边向左走的蚂蚁、右边向右的一定不会被影响
			int left=0,right=0;//分别表示左边向右走的蚂蚁数量，和右边向左走的蚂蚁数量
			for(int i=1;i<n;i++) {
				if(Math.abs(arr[i])<Math.abs(arr[0]) && arr[i]>0)//统计左边向右走的蚂蚁
					left++;
				else if(Math.abs(arr[i])>Math.abs(arr[0]) && arr[i]<0)
					right++;
			}
			int ans=1;
			if(arr[0]>0) {//感染者向右走
				ans += right;//此时，右边向左走的一定有交叉
				if(right>0) ans += left;//右边向左走的蚂蚁只要存在，那么左边向右的就会全部被交叉。否则不会被影响
			}else {//感染者向左走
				ans += left;
				if(left>0) ans += right;
			}
			System.out.println(ans);
			
		}
}
