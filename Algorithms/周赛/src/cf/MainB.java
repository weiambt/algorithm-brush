package cf;
import java.util.*;
import java.math.*;

public class MainB {
		static int INF = 0x3f3f3f3f;
		static int N = 101 , M = 2*N;
		static int[] ans1 = new int[20];
		static int[] ans2 = new int[20];
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			while(n-->0){
				int x = sc.nextInt();

				int flag1=0,flag2=0;//�ж��ǲ���0
				int cnt = 0;
				int flag = 1;
				while(x>0) {
					if(x%10%2==0) {
						ans1[cnt] = x%10/2;
						ans2[cnt] = x%10/2;
					}
					else {
						if(flag==1) {
							ans1[cnt] = x%10/2+1;
							ans2[cnt] = x%10/2;
							flag=2;
						}else {
							ans1[cnt] = x%10/2;
							ans2[cnt] = x%10/2+1;
							flag = 1;
						}
					}
					if(ans1[cnt]>0) flag1 = 1;
					if(ans2[cnt]>0) flag2 = 1;
					cnt++;
					x/=10;
				}
				
				flag = 0;
				for(int i=cnt-1;i>=0;i--) {
					if(flag1==0) {
						System.out.print(0);
						break;
					}
					if(ans1[i]==0 && flag==0) {
						continue;
					}else flag = 1;
					System.out.print(ans1[i]);
				}
				System.out.print(" ");
				flag = 0;
				for(int i=cnt-1;i>=0;i--) {
					if(flag2==0) {
						System.out.print(0);
						break;
					}
					if(ans2[i]==0 && flag==0 ) {
						continue;
					}else flag = 1;
					System.out.print(ans2[i]);
				}
				System.out.println();
			}
		}
}
