package _07²¢²é¼¯;

import java.util.*;
import java.io.*;
import java.math.*;

public class Ç×ÆÝ {
	static int N = 20010;
	static int[] p = new int[N];
	static int n,m,q,a,b;
	static int find(int x) {
		if(x==p[x]) return x;
		return p[x] = find(p[x]);
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
		String[] op = br.readLine().split(" ");
		n = Integer.parseInt(op[0]);
		m = Integer.parseInt(op[1]);
		for(int i=1;i<=n;i++) p[i]=i;
		while(m-->0) {
			op = br.readLine().split(" ");
			a = Integer.parseInt(op[0]);
			b = Integer.parseInt(op[1]);
			p[find(a)]=find(b);
		}
		op = br.readLine().split(" ");
		q = Integer.parseInt(op[0]);
		while(q-->0) {
			op = br.readLine().split(" ");
			a = Integer.parseInt(op[0]);
			b = Integer.parseInt(op[1]);
			if(find(a)==find(b))
				pr.write("Yes\n");
			else pr.write("No\n");
		}
		pr.flush();
	}
}
