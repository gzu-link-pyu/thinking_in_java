package com.gzu.pyu.thinking.in.java.practice0211;

import com.gzu.pyu.tools.utils.CloneUtils;

public class TestMain {
    public static void main(String ... args){
        Address address=new Address("ShengZheng","LongGang");
        //将address指向的区域赋值给addressNew，使得addressNew和address同时指向了同一个区域
        Address addressNew=address;

        //address指向的内容改变了，addressNew指向的内容也跟着改变
        System.out.println(address==addressNew);// true
        address.setCity("GuiYang");
        System.out.println(address);
//        Address{city='GuiYang', town='LongGang'}
        System.out.println(addressNew);
//        Address{city='GuiYang', town='LongGang'}

        //address進行克隆,將address進行了复制了，产生了一个新的对象
        Address addressClone = address.clone();
        System.out.println(address==addressClone);// false
        address.setTown("HuaXi");
        System.out.println(address);
//        Address{city='GuiYang', town='HuaXi'}
        System.out.println(addressClone);
//        Address{city='GuiYang', town='LongGang'}

        //在内存中通过字节流的拷贝是比较容易的，把木对象写入到一个字节流中，再从字节流中读出来
        Address addr = CloneUtils.clone(address);
        System.out.println(address==addr);// false
        addr.setCity("PanZhou");
        System.out.println(address);
//        Address{city='GuiYang', town='HuaXi'}
        System.out.println(addr);
//        Address{city='PanZhou', town='HuaXi'}
    }
}
