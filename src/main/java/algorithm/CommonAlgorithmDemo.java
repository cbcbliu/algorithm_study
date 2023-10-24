package algorithm;

import java.util.Scanner;

/**
 * 未分类的算法
 * od笔试前hr发的算法题参考，24页的pdf(info/algorithmOfodHr.pdf)
 * 无标准答案
 */
public class CommonAlgorithmDemo {

    public static void main(String[] args){
        algorithm2();
    }

    /**
     * 1.任务混部
     * 输入：第一行输入任务数量，后面每行为一个任务输入3个整数分别为开始时间、结束时间、并行度(运行时占用服务器数量)
     * 输出：完成这批任务最少需要多少服务器
     */
    public static void algorithm(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Task[] tasks = new Task[n];
        int start=-1,end = 0;
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
            if(tasks[i].startTime < start || start == -1){
                start = tasks[i].startTime;
            }
            if(tasks[i].endTime > end){
                end = tasks[i].endTime;
            }
        }
        int maxServer=0,curServer = 0;//最大占用服务器数量，当前占用服务器数量
        for (int i = start; i <= end; i++) {
            for(Task task : tasks){
                if(task.startTime == i && task.status == -1){
                    task.status = 0;
                    curServer = curServer + task.parallelism;
                }
                if(task.endTime == i && task.status == 0){
                    task.status = 1;
                    curServer = curServer - task.parallelism;
                }
                maxServer = Math.max(maxServer,curServer);
            }
        }

        System.out.println(maxServer);


    }

    static class Task{

        int status = -1;//初始：-1，启动：0，完成：1
        int startTime;//开始时间
        int endTime;//结束时间
        int parallelism;//占用服务器数
        public Task(int startTime,int endTime,int parallelism){
            this.endTime = endTime;
            this.startTime = startTime;
            this.parallelism = parallelism;
        }
    }

    /**
     * 2.单词倒叙
     * 输入：
     * 输出：
     */
    public static void algorithm2(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split = str.split("[^A-Za-z]");
        for (int i = split.length -1;i>=0;i--){
            System.out.print(split[i] + " ");
        }

    }


}
