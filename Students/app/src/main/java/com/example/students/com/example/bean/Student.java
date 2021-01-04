package com.example.students.com.example.bean;

import java.io.Serializable;

public class Student  implements Serializable {

    long id;
    String name;  //姓名
    String num ; //

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Student(long id, String name, String num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "学生信息: " +
                "id=" + id +
                " name='" + name + '\'' +
                " num='" + num + '\'' ;
    }
}

