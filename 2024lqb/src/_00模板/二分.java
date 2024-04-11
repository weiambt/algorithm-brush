package _00Ä£°å;

public class ¶ş·Ö {
	static int N = 1010;
	static int[] arr = new int[N];
	static int find_left(int l,int r,int x) {
		while(l<r) {
			int mid = l+r>>1;
			if(check(mid)) r = mid;
			else l = mid+1;
		}
		return l;
	}
	static int find_right(int l,int r,int x) {
		while(l<r) {
			int mid = l+r+1>>1;
			if(check(mid)) l = mid;
			else r = mid-1;
		}
		return l;
	}
	
}
