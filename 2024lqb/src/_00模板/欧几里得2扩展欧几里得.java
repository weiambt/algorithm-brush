package _00ģ��;
import java.util.*;

public class ŷ�����2��չŷ����� {
	static int N = 3030;
	
	//���x,y�� ax+by=gcd(a,b)�Ľ�
	static int x,y;
	static int exgcd(int a,int b) {
		if(b==0) {
			x=1;y=0;
			return a;
		}
		int gcd = exgcd(b,a%b);
		int t = x;
		x = y;
		y = t - a/b *y;
		return gcd;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//����ax+by = c�Ľ�
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int gcd = exgcd(a,b);
		if(c%gcd==0) {
			System.out.println("�н�");
			x *= (c/gcd);
			y *= (c/gcd);
			System.out.println("x="+x+",y="+y);
		}else {
			System.out.println("�޽�");
		}
	}
}
