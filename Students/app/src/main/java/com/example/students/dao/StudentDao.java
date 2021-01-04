package com.example.students.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.students.com.example.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private MyHelper helper;
    public StudentDao(Context context) {
        System.out.println("构造方法执行");
        helper = new MyHelper(context); // 创建Dao时, 创建Helper
    }

    public void update(Student student) {
        SQLiteDatabase db = helper.getWritableDatabase(); // 获取数据库对象
        // 用来装载要插入的数据的 Map<列名, 列的值>
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        values.put("num", student.getNum());
        long id = db.update("temp_student", values, "_id=?",new String[] { student.getId() + "" }); // 向表插入数据values,
        student.setId(id);  // 得到id
        db.close();         // 关闭数据库
        System.out.println("修改方法执行");
    }
    //修改学生信息




    public void insert(Student student) {
        SQLiteDatabase db = helper.getWritableDatabase(); // 获取数据库对象
        // 用来装载要插入的数据的 Map<列名, 列的值>
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        values.put("num", student.getNum());
        long id = db.insert("temp_student", null, values); // 向表插入数据values,
        student.setId(id);  // 得到id

        System.out.println(
                "插入 之后的 id 为" + id
        );
        db.close();         // 关闭数据库
    }
    //根据id 删除数据
    public int delete(long id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        // 按条件删除指定表中的数据, 返回受影响的行数
        int count = db.delete("temp_student", "num=?", new String[] { id + "" });
        db.close();
        return count;
    }
    //查询所有数据
    public List<Student> queryAll() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("temp_student", null, null, null, null, null,
                null);
        List<Student> list = new ArrayList<Student>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex("_id")); // 可以根据列名获取索引
            String name = c.getString(1);
            String  num = c.getString(2);
            list.add(new Student(id,name,num));
        }
        c.close();
        db.close();

        return list;
    }


    public List<Student> searchByName (String name){
        List<Student> list  =  new ArrayList<>();
        SQLiteDatabase db = helper.getWritableDatabase();
        //查询数据库
        Cursor c = db.query("temp_student", null, "name=?", new String[]{name+""}, null, null,
                null);
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex("_id")); // 可以根据列名获取索引
            String f_name = c.getString(1);
            String num = c.getString(2);
            list.add(new Student(id,f_name,num));
        }
        c.close();
        db.close();

        System.out.println("查询结果如下：");
        for (Student f: list
             ) {
            System.out.println(f);
        }

        return list;


    }
}
