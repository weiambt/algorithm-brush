package _202211.acwing;
import java.util.*;
/**
 * AcWing 4719. ��Ʒ����
 * AC�ˣ�������̫ɵ�ˣ� set������ַ���s1+s2��ֱ�ӱȽ��ַ���������

 * @author ZW
 *
 */
public class p1 {
	static int N = 101;
	static int M = 101;
	static int n,m;
	
	static Set<String> se = new HashSet<>();

	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int ans=0;
	
		for(int i=1;i<=n;i++) {
			String s = sc.next();
			s += " ";
			s += sc.next();
			se.add(s);
		}
		System.out.println(se.size());
	}
}
