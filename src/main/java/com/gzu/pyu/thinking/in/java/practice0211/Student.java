package com.gzu.pyu.thinking.in.java.practice0211;

import java.io.Serializable;

public class Student implements Cloneable ,Serializable {
    public String name;
    public int age;
    public Address address;

    public Student() {
    }

    public Student(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Object clone()  {
        Student student=null;
        try {
            //淺拷貝
            student= (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            return new Student();
        }
        //支持深度克隆
        student.address=address.clone();
        return student;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}

class Address implements Cloneable,Serializable{
    String city;
    String town;

    public Address() {
    }

    public Address(String city, String town) {
        this.city = city;
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public Address clone()  {

        Address address=null;
        try {
            address= (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Address();
        }
        return address;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("city='").append(city).append('\'');
        sb.append(", town='").append(town).append('\'');
        sb.append('}');
        return sb.toString();
    }
}