package com.example.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.students.com.example.bean.Student;
import com.example.students.dao.RecyclerItemClickListener;
import com.example.students.dao.ShowDataAdpater;
import com.example.students.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends Activity {
private RecyclerView recyclerView;
private List<Student> mlist ;
private  StudentDao dao;
private  ShowDataAdpater showDataAdpater;
private Button add,findBtn,del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        initData();
        Event();
    }
    public void initData(){
        recyclerView=findViewById(R.id.rlv);
        findBtn=findViewById(R.id.findBtn);
        del=findViewById(R.id.aboutUs);
        add=findViewById(R.id.add);
        mlist= new ArrayList<>();


        dao= new StudentDao(StudentListActivity.this);
        mlist=dao.queryAll();
        showDataAdpater = new ShowDataAdpater(mlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StudentListActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(showDataAdpater);
    }

    public void Event(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentListActivity.this,AddActivity.class));
            }
        });

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentListActivity.this,FindStudent.class));
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentListActivity.this,DelStudentActivity.class));
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(StudentListActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(StudentListActivity.this, UpdateActivity.class);
                intent.putExtra("Student", mlist.get(position));
                startActivity(intent);
            }
        }));



    }
}
