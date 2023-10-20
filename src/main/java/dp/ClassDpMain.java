package dp;

import dao.WuPing;

import java.util.Scanner;

/**
 * 动态规划相关的算法
 */
public class ClassDpMain {

    public static void main(String[] args) {

    }

    /**
     * 01背包问题、动态规划(中等难度)...个人感觉非常难，01背包问题的进阶
     *题目在牛客网：<a href="https://www.nowcoder.com/exam/oj/ta?difficulty=3&page=1&pageSize=50&search=&tpId=37&type=37">...</a>
     * 编号HJ16
     */
    public static void test4(){
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();//总钱数
        int total = scanner.nextInt();//物品总数
        //ArrayList<WuPing> wuPings = new ArrayList<>();
        WuPing[] wuPings = new WuPing[total];//所有物品的数组
        for (int i = 0; i <total; i++) {
            WuPing wuPing = new WuPing(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            wuPings[i] = wuPing;
        }

        WuPing[] zjArr = new WuPing[total];//主件的数组
        int zj = 0;//主件个数
        for (WuPing wp : wuPings){
            if(wp.belong==0){//主件
                zjArr[zj] = wp;
                zj++;
            }
            if(wp.belong>0){//附件放入主件对象
                if(wuPings[wp.belong-1].a1 == null){
                    wuPings[wp.belong-1].a1 = wp;
                }else {
                    wuPings[wp.belong-1].a2 = wp;
                }
            }
        }

        int[][] dp = new int[zj+1][money+1];
        for (int i = 1; i < zj+1; i++) {
            int v=0,v1=0,v2=0,v3=0,tempdp=0,tempdp1=0,tempdp2=0,tempdp3=0;
            v = zjArr[i-1].price;
            tempdp = zjArr[i-1].getImp();
            if(zjArr[i-1].a1 != null){
                v1 = zjArr[i-1].a1.price + v;
                tempdp1 = tempdp + zjArr[i-1].a1.getImp();
            }
            if(zjArr[i-1].a2 != null){
                v2 = zjArr[i-1].a2.price + v;
                tempdp2 = tempdp + zjArr[i-1].a2.getImp();
            }
            if(zjArr[i-1].a1 != null && zjArr[i-1].a2 != null){
                v3 = zjArr[i-1].a2.price +zjArr[i-1].a1.price+ v;
                tempdp3 = tempdp + zjArr[i-1].a2.getImp() + zjArr[i-1].a1.getImp();
            }
            for (int j = 0; j < money+1; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=v && v!= 0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v] + tempdp);
                if(j>=v1 && v1!= 0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v1] + tempdp1);
                if(j>=v2 && v2!= 0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v2] + tempdp2);
                if(j>=v3 && v3!= 0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-v3] + tempdp3);
            }
        }

        System.out.println(dp[zj][money]);
    }

}
