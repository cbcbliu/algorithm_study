package datastructure.hashtable;

public class HashTable {

    private final EmpLinkedList[] empLinkedListArr;//链表数组

    private final int size;

    public HashTable(int size){
        this.size = size;
        //初始化链表数组
        empLinkedListArr = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }

    }

    public void add(Employee emp){
        int empLinkedListNo = hashFunc(emp.id);
        empLinkedListArr[empLinkedListNo].add(emp);

    }

    public void list(){
        for(int i = 0;i<empLinkedListArr.length;i++){
            empLinkedListArr[i].list(i+1);
        }
    }

    public void findEmployeeById(int id){
        //使用散列函数确定是那一条链表
        int empLinkedListNo = hashFunc(id);
        Employee emp = empLinkedListArr[empLinkedListNo].findEmp(id);
        if(null != emp){
            System.out.println("在第"+(empLinkedListNo+1)+"条链表中找到雇员");
        }else{
            System.out.println("在哈希表中，没有找到该雇员");
        }
    }

    public void deleteEmployeeById(int id){
        //使用散列函数确定是那一条链表
        int empLinkedListNo = hashFunc(id);
        int deleteStatus = empLinkedListArr[empLinkedListNo].delete(id);
        if(deleteStatus == 1){
            System.out.println("在第"+(empLinkedListNo+1)+"条链表中删除雇员");
        }else{
            System.out.println("在哈希表中，没有找到该雇员");
        }
    }

    public int hashFunc(int id){
        return id % size;
    }



}
