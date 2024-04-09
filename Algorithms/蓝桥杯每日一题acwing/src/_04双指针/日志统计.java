package _04双指针;
import java.util.*;
import java.math.*;
import java.io.*;

public class 日志统计 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static PII[] a = new PII[N];
	static int n,d,k;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = sc.nextInt();
		k = sc.nextInt();
		for(int i=1;i<=n;i++) {
			a[i] = new PII(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(a,1,n+1,(a,b)->(a.time-b.time));
		Set<Integer> ans = new TreeSet<Integer>();
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for(int i=1,j=1;i<=n;i++) {
			int now = a[i].time;
			while(now - a[j].time +1 > d) {
				mp.put(a[j].id,mp.get(a[j].id)-1);
				j++;
			}
			mp.put(a[i].id,mp.getOrDefault(a[i].id, 0)+1);
			
			if(mp.getOrDefault(a[i].id, 0)>=k)
				ans.add(a[i].id);

		}
		for(Integer i: ans)
			System.out.println(i);
	}
}
class PII{
	int time,id;
	public PII(int time,int id) {
		// TODO Auto-generated constructor stub
		this.time = time;
		this.id = id;
	}
}
