package com.example.students.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.students.com.example.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    private MyHelper helper;
    public AdminDao(Context context) {
        System.out.println("创建table_admin ");
        helper = new MyHelper(context); // 创建Dao时, 创建Helper
    }
    public void insert(Student student) {
        //测试的时候用
        SQLiteDatabase db = helper.getWritableDatabase(); // 获取数据库对象
        // 用来装载要插入的数据的 Map<列名, 列的值>
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        values.put("password", student.getNum());
        long id = db.insert("table_admin", null, values); // 向表插入数据values,
        student.setId(id);  // 得到id
        System.out.println(
                "插入 之后的 id 为" + id
        );
        db.close();         // 关闭数据库
    }
    public boolean judge (String name,String password){
        SQLiteDatabase db = helper.getWritableDatabase();
        //查询数据库
        Cursor c = db.query("table_admin", null, "name=?", new String[]{name+""}, null, null,
                null);
        while (c.moveToNext()) {

           if(c.getString(2).equals(password)) {
               return true;
           }
        }
        c.close();
        db.close();
        return false;
    }
}
