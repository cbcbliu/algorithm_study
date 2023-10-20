package dao;

import java.util.ArrayList;
import java.util.List;

public class WuPing {
    public int price;
    public int p;//重要度
    //public int num;//编号

    public int belong;//所属主件编号
    public List<WuPing> fj = new ArrayList<>();
    public WuPing a1;
    public WuPing a2;
    //public WuPing fj;
    public WuPing(int price,int p,int belong){
        this.p=p;
        this.belong=belong;
        this.price=price;
    }
    public int getImp(){
        return this.price*this.p;
    }
}
