import java.util.ArrayList;

/*
    2023/1/23 20:10
    @author ZW
    Project Name:eclipse_worksapce
     
*/
public class _00数位dp模版 {
    static int count(int n){
        if(n==0) return 0;
        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%10);
            n/=10;
        }
        n = nums.size();
        int res = 0;
        int last = 0;
        for (int i = n-1; i >= 0; i--) {
            int x = nums.get(i);
            //枚举当前位小于x的所有情况
            for (int j = 0; j < x; j++) {
                //左子树计算公式

                //右子树一直递归

                // 右子树的终点可能会多一种方案
                if(i==0) res++;
            }
        }
        return res;
    }
}
