package _202211.acwing;
import java.util.*;
/**
 * WA  Ïû³ý
 * @author ZW
 *
 */
public class p2 {

	static Stack<Character> stk =  new Stack<>();

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String s = sc.next();
//		int n = s.length();
//		for(int i=0;i<n;i++) {
//			if(stk.size()>0 && stk.peek()==s.charAt(i)) 
//				stk.pop();
//			else
//				stk.push(s.charAt(i));
//		}
//		StringBuilder ans = new StringBuilder();
//		while(stk.size()>0) {
//			ans.append(stk.pop());
//		}
//		ans.reverse();
//		System.out.println(ans.toString());
//
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringBuilder ans = new StringBuilder();
		int n = s.length();
		for(int i=0;i<n;i++) {
			if(ans.length()>0 && ans.charAt(ans.length()-1)==s.charAt(i)) 
				ans.deleteCharAt(ans.length()-1);
			else
				ans.append(s.charAt(i));
		}
		System.out.println(ans.toString());

	}
}
