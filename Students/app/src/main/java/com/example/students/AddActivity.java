package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.students.com.example.bean.Student;
import com.example.students.dao.StudentDao;

public class AddActivity extends Activity {
    private EditText etSno,etName,etNum;
    private StudentDao dao;
    private Button Cancel,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initLayout();
        event();

    }


    public  void initLayout(){
        dao=new StudentDao(this);
        etSno=findViewById(R.id.etSno);
        etName=findViewById(R.id.etName);
        Cancel=findViewById(R.id.CancelBtn);
        add=findViewById(R.id.addBtn);
    }


    public void event(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao.insert(new Student(0,etName.getText().toString(),etSno.getText().toString()));
                show("添加成功");
                getMain();
            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMain();
            }
        });

    }
    public void  show(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void getMain(){
        startActivity(new Intent(this,StudentListActivity.class));
    }
}
