package _99备战国赛;
import java.util.*;
import java.math.*;
import java.io.*;

public class AcWing3451字符串排序II {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;
		static int[] dx = {1,0,-1,0};
		static int[] dy = {0,1,0,-1};
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			String string;
			List<PCI> list = new ArrayList<PCI>();
			char[] s;
			while(sc.hasNext()) {
				s = sc.nextLine().toCharArray();
				n = s.length;
				for(int i=0;i<n;i++) {
					if(s[i]>='a' && s[i]<='z' || (s[i]>='A' && s[i]<='Z')) {
						list.add(new PCI(s[i],i));
					}
				}
				Collections.sort(list);
				for(int i=0,j=0;i<n;i++) {
					if(Character.isLetter(s[i])) {
						s[i] = list.get(j++).c;
					}
					System.out.print(s[i]);
				}
			}

		}
}
class PCI implements Comparable<PCI>{
	char c;
	int idx;
	public PCI(char c,int idx) {

		this.c = c;
		this.idx = idx;
	}
	@Override
	public int compareTo(PCI o) {
		if(Character.toLowerCase(c) == Character.toLowerCase(o.c))
			return idx-o.idx;
		return Character.toLowerCase(c) - Character.toLowerCase(o.c);
	}
}
