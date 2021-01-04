package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.students.com.example.bean.Student;
import com.example.students.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class FindStudent extends Activity {
    private StudentDao dao;
    private TextView textView;
    private EditText input;
    private Button findBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_student);
        dao = new StudentDao(this);
        textView = findViewById(R.id.result);  //存放查询结果
        input = findViewById(R.id.input);  //输入的数据
        findBtn =findViewById(R.id.findBtn);//搜索按钮

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Student> students = new ArrayList<>();
                 students =dao.searchByName(input.getText().toString());
                 if(!students.isEmpty()){

                     for(Student student:students)
                     textView.setText("查询结果如下\n"+student.toString()+"\n");
                 }
                 else{
                     textView.setText("没有查询到结果");
                 }
            }
        });
    }
}
