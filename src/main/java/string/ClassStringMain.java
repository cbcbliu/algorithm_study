package string;

import dao.WuPing;

import java.util.ArrayList;
import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;
/**
 * 字符串相关的算法
 */
public class ClassStringMain {



    public static void main(String[] args) {

        algorithm4();

    }

    /**
     * 计算某字符出现次数.(简单难度)
     * 输入:第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
     * 输出:输出输入字符串中含有该字符的个数。（不区分大小写字母）
     */
    public static void algorithm(){
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int count = 0;
        //a:97 z:122:,A:65,Z:90
        for(int i = 0;i < a.length();i++){
            char ch = a.charAt(i);
            char ch2 = b.charAt(0);
            if(ch>96 && ch<123){
                ch-=32;
            }
            if(ch2>96 && ch2<123){
                ch2-=32;
            }
            if(ch == ch2){
                count++;
            }
        }

        System.out.println(count);
    }

    /**
     *输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；(简单难度)
     *长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * 输入：连续输入字符串(每个字符串长度小于等于100)
     * 输出：依次输出所有分割后的长度为8的新字符串
     */
    public static void algorithm2(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = str.length()%8;
        int m = str.length()/8;
        for(int i = 0; i <m; i++) {
            System.out.println(str.substring(i*8,i*8+8));
        }
        StringBuilder last = new StringBuilder(str.substring(m * 8 ));
        int num0 = 8-n;
        while (num0>0 && n>0) {
            last.append("0");
            num0--;
        }
        System.out.println(last);
        /*
         * 更好的思路：先补0，这样字符串长度就是8的倍数。再循环输出前八个字符，迭代时扣除前八个字符
         */

    }

    /**
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。(简单难度)
     * 输入一个十六进制的数值字符串。
     * 输出该数值的十进制字符串。
     */
    public static void algorithm3(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String a = in.nextLine();
            System.out.println(Integer.parseInt(a.substring(2),16));
        }
    }

    /**
     * 模拟坐标移动(中等难度)
     * 例.输入: A10;S10 输出: -10,10
     */
    public static void algorithm4(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int initX = 0;
        int initY = 0;

        String[] splitArr = str.split(";");
        for (String s : splitArr){
            if(s.matches("[a-z]|[A-Z]\\d\\d?")){//正则表达式
                int i = Integer.parseInt(s.substring(1));
                switch (s.charAt(0)) {
                    case 'A':
                        initX -= i;
                        break;
                    case 'D':
                        initX += i;
                        break;
                    case 'W':
                        initY += i;
                        break;
                    case 'S':
                        initY -= i;
                        break;
                }
            }
        }
        System.out.println(initX+","+initY);



    }






}



