

import java.util.ArrayList;
import java.util.Scanner;

/*
    2023/1/17 14:54
    @author ZW
    Project Name:eclipse_worksapce

     题意：找到[l,r]中满足条件的数的个数，条件：数n在B进制下中1的个数恰好是k个，并且各个位的值只能是0或1
*/
public class _02度的数量 {
    static int k,b;
    static int N  = 33;
    static int[][] C = new int[N][N];
    static void init(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0) C[i][j] = 1;
                else C[i][j] = C[i-1][j]+C[i-1][j-1];
            }
        }
    }
    static int dp(int n){
        int res = 0;
        int used = 0;

        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%b);
            n/=b;
        }
        for(int i = nums.size()-1;i>=0;i--){
            int x = nums.get(i);

            //x==0此时无左子树
            if(x>0){
                res += C[i][k-used];//当第i位是0时的方案数
                if(x==1){
                    used++;
                    if(used>k)break;
                }
                else{//x>1时
                    if(k-used-1>=0)
                        res+=C[i][k-used-1];//当第i位是1时的方案数
                    //此时剩下的右子树，该节点存放的x>1，此时后面不存在满足条件的方案
                    break;
                }
            }
            //上面处理完了这棵树的**所有**左分支，就剩下最后一种右分支的情况
            // 也就是遍历到最后1位，在vector中就是下标为0的地方：i==0；
            // 并且最后1位取0，才算作一种情况res++。因为最后1位不为0的话，已经被上面的ifelse处理了。
            if(i==0 && used == k) res++;

        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int r = sc.nextInt();
        k = sc.nextInt();
        b = sc.nextInt();

        init();
        System.out.println(dp(r)-dp(l-1));
    }
}
