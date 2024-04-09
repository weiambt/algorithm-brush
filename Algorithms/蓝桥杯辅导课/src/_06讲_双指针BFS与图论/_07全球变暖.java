package _06讲_双指针BFS与图论;

import java.util.*;
import java.math.*;
import java.io.*;

public class _07全球变暖 {
    static int INF = 0x3f3f3f3f;
    static int N = 1100 , M = 2*N;
    static char[][] g = new char[N][N];
    static int[][] vis = new int[N][N];
    static int n,ans;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int flag;

    static boolean check(int x,int y) {
        if(x >=1 && x<=n && y>=1 && y<=n && g[x][y]=='#' && vis[x][y]==0)
            return true;
        return false;
    }

    static void dfs(int x,int y) {
        if(g[x-1][y]=='#' && g[x][y-1]=='#' && g[x+1][y]=='#' && g[x][y+1]=='#')
            flag = 1;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(check(nx, ny)) {
                vis[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] sss) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1;i<=n;i++) {
            char[] s = sc.next().toCharArray();
            for(int j=1;j<=n;j++) {
                g[i][j] = s[j-1];
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(g[i][j]=='#' && vis[i][j]==0) {
                    vis[i][j] = 1;
                    flag = 0;
                    dfs(i,j);
                    if(flag == 0) ans++;
                }
            }
        }

        System.out.println(ans);
    }
}