package _00Ä£°å;
import java.util.*;

public class ÖÊÊıÉ¸ {
	static int N = 1010000;
	static int[] st = new int[N];
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	
	static void getPrimes() {
		st[0]=1;st[1]=1;
		for(int i=2;i<=N/i;i++) {
			if(st[i]==0) {
				primes.add(i);
				for(int j=i+i;j<N;j+=i) 
					st[j] = 1;
			}
		}
		
	}
	public static void main(String[] args) {
		getPrimes();
		for(Integer x:primes)
			System.out.print(x+" ");
	}
}
