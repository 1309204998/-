package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.students.com.example.bean.Student;
import com.example.students.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class DelStudentActivity extends Activity {
    private TextView res;
    private EditText input_num;
    private Button delBtn;
    private StudentDao studentDao= new StudentDao(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_student);

        res = findViewById(R.id.del_result);  //存放删除结果
        input_num = findViewById(R.id.inputNum);  //输入的数据
        delBtn =findViewById(R.id.delBtn);//删除

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.setText("删除成功");

             int count=  studentDao.delete(Integer.valueOf(input_num.getText().toString()));

               if (count ==1 ){
                   res.setText("删除成功");
                    //删除成功之后就去跳转
                   startActivity(new Intent(DelStudentActivity.this,AddActivity.class));
               }else{
                   res.setText("删除失败 ,查无此人");
               }

            }
        });
    }
}
