package datastructure.hashtable;

/**
 * 链表
 */
public class EmpLinkedList {

    private Employee head;

    public void add(Employee emp){
        if(head == null){
            head = emp;
            return;
        }

        //curEmp定位到最后一个数据
        Employee curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;//后移
        }
        curEmp.next = emp;//新增
    }

    public void list(int no){
        if(head == null){
            System.out.println("第"+no+"条链表为空");
            return;
        }
        System.out.print("第"+no+"条链表的信息为");
        Employee curEmp = head;
        while (true){
            System.out.printf("=> id=%s name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public int delete(int id){
        if(head == null){
            return 0;
        }
        if(head.id == id){
            head = head.next;
            return 1;
        }
        Employee curEmp = head;//辅助指针
        while (curEmp.next != null){
            if(curEmp.next.id == id){
                curEmp.next = curEmp.next.next;
                return 1;
            }
            curEmp = curEmp.next;
        }
        return 0;
    }

    public Employee findEmp(int id){

        if(head == null){
            //System.out.println("链表为空");
            return null;
        }

        Employee curEmp = head;//辅助指针
        while (true){
            if (curEmp.id == id){
                break;//找到
            }
            if(curEmp.next == null){
                curEmp = null;
                break;//没找到
            }
            curEmp = curEmp.next;
        }
        return curEmp;

    }

}
