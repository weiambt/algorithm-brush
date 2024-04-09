package _04½²_Ä£Äâ;

import java.util.*;

public class ´íÎóÆ±¾Ý {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int n;
	static int[] arr = new int[N];
	static int idx = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		while(n-->0) {
			String[] str = sc.nextLine().split(" ");
			for(String i:str)
				arr[idx++] = Integer.parseInt(i);
		}
//		System.out.println(idx);
		int duan=0,chong=0;
		Arrays.sort(arr,0,idx);
		for(int i=1;i<idx;i++) {
//			System.out.print(arr[i]+" ");
			if(chong==0 && arr[i]==arr[i-1])
				chong = arr[i];
			if(duan ==0 && arr[i]!=arr[i-1]+1)
				duan = arr[i-1]+1;
//			System.out.println(duan+" "+chong);
		}
		System.out.println(duan+" "+chong);
	}
}
