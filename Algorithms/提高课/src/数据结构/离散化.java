package ���ݽṹ;
import java.util.*;
public class ��ɢ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[] {0,1,100,1,99};
		HashSet<Integer> se = new HashSet<Integer>();
		for(int i=1;i<=4;i++)
			se.add(a[i]);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(Integer i:se)
			list.add(i);
		for(int i=1;i<=4;i++) {
			a[i] = Collections.binarySearch(list, a[i]);
			System.out.println(a[i]);
		}
	}
}
