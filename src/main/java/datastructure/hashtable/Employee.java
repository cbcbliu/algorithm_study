package datastructure.hashtable;

/**
 *模拟数据。表示一个雇员
 */
public class Employee {

    public int id;
    public String name;
    public Employee next;
    public Employee(int id ,String name){
        super();
        this.id = id;
        this.name = name;
    }

}
