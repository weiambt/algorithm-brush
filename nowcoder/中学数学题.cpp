#include<bits/stdc++.h>
using namespace std;
// https://ac.nowcoder.com/acm/contest/9692/D
//思维、数学
// 给定数n，求n!的p进制下有多少个后导零。非常简单。
// 为了简化问题，p保证为素数。
//题解：https://ac.nowcoder.com/acm/discuss/blogs?tagId=139763
int main(){
    int t,n,p;
    cin>>t;
    while(t--){
        cin>>n>>p;
        long long cnt = 0;
        for(int i=p;n/i;n/=p)
            cnt += (long long)n/i;
        
         cout<<cnt<<endl;   
    }
    return 0;
}