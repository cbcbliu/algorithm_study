package datastructure.hashtable;

import java.util.Scanner;

public class HashTableDemo {

    /**
     * 数据结构 哈希表，链表+数组构成
     *Employee类为模拟数据，EmpLinkedList为链表，HashTable为链表数组即哈希表
     */
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        String key;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("delete:删除雇员");
            System.out.println("exit:退出系统");
            key = scanner.next();
            switch (key){
                case "add": {
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Employee employee = new Employee(id,name);
                    hashTable.add(employee);
                }break;
                case "list":{
                    hashTable.list();
                }break;
                case "find":{
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    hashTable.findEmployeeById(id);
                }break;
                case "delete":{
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    hashTable.deleteEmployeeById(id);
                }break;
                case "exit":{
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }

}
