package datastructure.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key;
        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':{
                    arrayQueue.showQueue();
                }break;
                case 'a':{
                    System.out.println("输入一个数");
                    arrayQueue.add(scanner.nextInt());
                }break;
                case 'g':{
                     try {
                         System.out.println("取出的数据是:"+arrayQueue.get());
                     }catch (Exception e){
                         System.out.println(e.getMessage());
                     }
                }break;
                case 'h':{
                    try {
                        System.out.println("队列头的数据是:"+arrayQueue.headQueue());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }break;
                case 'e':{
                    scanner.close();
                    loop=false;
                    //System.exit(0);
                }break;


            }

        }
        System.out.println("程序退出");
    }

   static class ArrayQueue{

        //只能使用一次，队列加满之后就无法使用
        private int maxSize;
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr;

        public ArrayQueue(int size){
            this.maxSize=size;
            arr = new int[size];
            front = -1;//指向队列头部：指向队列头的前一个位置(队列不包含指向的数据)
            rear = -1;//指向队列尾：指向队列尾的数据（即队列的最后一个数据，队列包含指向的数据）
        }

        public boolean isFull(){
            return this.rear == this.maxSize-1;
        }

        public boolean isEmpty(){
            return rear == front;
        }

        /**
         * 添加数据
         * @param n
         */
        public void add(int n){
            if(isFull()){
                System.out.println("队列已满");
                return;
            }
            rear++;
            arr[rear] = n;
        }

        /**
         * 出队列
         * @return
         */
        public int get(){
            if(isEmpty()){
                throw new RuntimeException("队列空，不能取数据");
            }
            front++;
            return arr[front];
        }

        /**
         * 显示队列所有数据
         */
        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列是空的");
                return;
            }
            for (int i=0;i<arr.length;i++){
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
        //显示队列的头数据
        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列空");
            }
            return arr[front+1];
        }

    }


}

