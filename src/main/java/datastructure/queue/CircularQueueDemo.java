package datastructure.queue;

import java.util.Scanner;

/**
 * 环形队列
 */
public class CircularQueueDemo {
    public static void main(String[] args) {
        CircularQueue arrayQueue = new CircularQueue(3);
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

    static class CircularQueue{
        //可重复使用的环形队列
        private int maxSize;
        private int front;//指向队列头部：指向队列头数据(队列包含指向的数据)
        private int rear;//指向队列尾部：指向队列尾数据的后一个位置(队列不包含指向的数据)
        //这样设计会使得数组中有一个位置专门来记录队列尾部的位置而不存数据
        private int[] arr;

        public CircularQueue(int size){
            this.maxSize=size;
            arr = new int[size];
        }

        public boolean isFull(){
            return (rear+1)%maxSize == front;
        }

        public boolean isEmpty(){
            return rear == front;
        }

        public void add(int n){
            if(isFull()) {
                System.out.println("队列已满");
                return;
            }
            arr[rear] = n;
            rear = (rear+1) % maxSize;
        }

        public int get(){
            if(isEmpty()){
                throw new RuntimeException("队列空，不能取数据");
            }
            int out = arr[front];
            front = (front+1) % maxSize;
            return out;
        }

        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列是空的");
                return;
            }
            for (int i=front;i< front+size();i++){
                System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
            }
        }

        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列空");
            }
            return arr[front];
        }

        public int size(){//队列的有效数据
            return (rear+maxSize-front)%maxSize ;
        }

    }


}
