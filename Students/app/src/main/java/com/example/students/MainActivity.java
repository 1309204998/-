package com.example.students;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.students.com.example.bean.Student;
import com.example.students.dao.AdminDao;
import com.example.students.dao.UserDao;

public class MainActivity extends Activity {
    private Button loginBtn,RegBtn;
    private EditText username,password;
    private RadioGroup radioGroup;
    private RadioButton radioButton1,radioButton2;
    private String option = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件ID
        loginBtn=findViewById(R.id.login);
        username=findViewById(R.id.usernameEdit);
        password=findViewById(R.id.passwordEdit);
        radioGroup=findViewById(R.id.radiogroup1);
        radioButton1 =  findViewById(R.id.radiobutton1);
        radioButton2 =  findViewById(R.id.radiobutton2);
        final AdminDao adminDao = new AdminDao(this);
        final UserDao userDao = new UserDao(this);
        //为RadioGroup设置监听事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 先判断 选择的是什么身份
                if(checkedId == radioButton1.getId()){
                    option = radioButton1.getText().toString();
                }else if(checkedId == radioButton2.getId()){
                    option = radioButton2.getText().toString();
                }
            }
        });



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //账号密码不能为空
                if(option.equals("管理员")){
                    if(username.getText().toString().equals("")||password.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
                    }else{

                        //进行判断是否能登录
                        if(adminDao.judge(username.getText().toString(),password.getText().toString())){
                            //直接进入主页面
                            //完成对学生的增删改查
                            Intent intent = new Intent(MainActivity.this,StudentListActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,"请检查账号密码",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
//
                    userDao.insert(new Student(0,"2580","123456"));
                    //进行判断是否能登录
                    if(userDao.judge(username.getText().toString(),password.getText().toString())){
                        //直接进入主页面
                        //完成对学生的增删改查
                        Intent intent = new Intent(MainActivity.this,FindStudent.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    }
                }







            }
        });
    }
}
