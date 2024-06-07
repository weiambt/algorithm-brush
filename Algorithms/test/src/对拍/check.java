package ╤тед;

public class check {

	public static void main(String[] args) throws Exception {
		String[] cp_data = {"cmd","/c","javac data.java"};
		String[] cp_force = {"cmd","/c","javac force_code.java"};
		String[] cp_new = {"cmd","/c","javac new_code.java"};
		
		String[] run_data = {"cmd","/c","java data > input.txt"};
		String[] run_force = {"cmd","/c","java force_code < input.txt > fout.txt"};
		String[] run_new = {"cmd","/c","java new_code < input.txt > nout.txt"};
		
		String[] fc = {"cmd","/c","fc fout.txt nout.txt"};
		
		Runtime.getRuntime().exec(cp_data).waitFor();
		Runtime.getRuntime().exec(cp_force).waitFor();
		Runtime.getRuntime().exec(cp_new).waitFor();
		int ans;
		while(true) {
			Runtime.getRuntime().exec(run_data).waitFor();
			Runtime.getRuntime().exec(run_force).waitFor();
			Runtime.getRuntime().exec(run_new).waitFor();
			ans = Runtime.getRuntime().exec(fc).waitFor();
			if(ans==0) {
				System.out.println("AC");
			}else {
				System.out.println("WA");
				break;
			}
		}
	}
}
