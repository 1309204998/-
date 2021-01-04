package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.students.com.example.bean.Student;
import com.example.students.dao.StudentDao;

public class UpdateActivity extends AppCompatActivity {
    private EditText inputName,inputNum;
    private Button updateBtn,cancalBtn;
    private StudentDao studentDao = new StudentDao(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final Student students=(Student)getIntent().getSerializableExtra("Student");
        // 取出来传输的对象信息
        init();
        inputNum.setText(students.getNum());
        inputName.setText(students.getName());

        final Student new_Student = new Student(students.getId(),inputName.getText().toString(),inputNum.getText().toString());

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentDao.update(new_Student);
                Toast.makeText(UpdateActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                getIndex();
            }
        });

        cancalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getIndex();
            }
        });




    }

    public void init (){
        inputName=findViewById(R.id.newName);
        inputNum= findViewById(R.id.newSno);
        updateBtn=findViewById(R.id.updateBtn);
        cancalBtn=findViewById(R.id.cancelBtn);
    }

    public void getIndex(){
        startActivity(new Intent(
                UpdateActivity.this,StudentListActivity.class
        ));
    }
}
