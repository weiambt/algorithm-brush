import java.util.*;

public class 航班时间 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int w,m,n;
	static int[] arr = new int[N];
	
	static void solve(int t1,int t2,int t3,int t4) {
		int time = (t2+t4-t1-t3)/2;
		String ans="";
		if(time/3600%24 <10) ans += "0";
		ans += time/3600%24+":";
		if(time%3600/60 <10) ans += "0";
		ans += time%3600/60+":";
		if(time%60 <10) ans += "0";
		ans += time%60;
		System.out.println(ans);
	}
	
	//处理字符串时间
	static int solveTime(String s,int d) {
		String[] ss = s.split(":");
		int h = Integer.parseInt(ss[0]);
		int m = Integer.parseInt(ss[1]);
		int o;
		if(ss[2].length()==2)
			o = Integer.parseInt(ss[2]);
		else
			o = Integer.parseInt(ss[2].substring(0,2));
		return h*3600 + m*60 + o + d*3600*24;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		while(n-->0) {
			String[] s1 = sc.nextLine().split(" ");
			String[] s2 = sc.nextLine().split(" ");
			
			int t1 = solveTime(s1[0],0);
			int t2 = solveTime(s1[1],s1.length>2?s1[2].charAt(2):0);
			int t3 = solveTime(s2[0],0);
			int t4 = solveTime(s2[1],s2.length>2?s2[2].charAt(2):0);

			solve(t1,t2,t3,t4);

		}

	}
}
