package _02��_���ֺ�ǰ׺��;
import java.util.*;
import java.math.*;

public class _09K������ {

	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,k;
	static int[] arr = new int[N];
	static int[] cnt = new int[N];//cnt[x]=y��ʾǰi��Ԫ����arr[i]������y��
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		long ans = 0;
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
			arr[i] = (arr[i] + arr[i-1])%k;
			ans += cnt[arr[i]];
			cnt[arr[i]]++;
			if(arr[i]==0) ans++;
		}
		System.out.println(ans);
	}

}
