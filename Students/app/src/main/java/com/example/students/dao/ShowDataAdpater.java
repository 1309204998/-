package com.example.students.dao;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.students.R;
import com.example.students.com.example.bean.Student;

import java.util.List;

public class ShowDataAdpater extends RecyclerView.Adapter<ShowDataAdpater.ViewHolder>  {
    private List<Student> mList ;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View myView;
        TextView id,price,name,num;
        public ViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            name = itemView.findViewById(R.id.name);
            num = itemView.findViewById(R.id.num);
        }
    }
    //数据源
    public ShowDataAdpater(List<Student> list){
        this.mList = list;
    }

    @NonNull
    @Override
    public ShowDataAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,null);
        final ShowDataAdpater.ViewHolder holder = new ShowDataAdpater.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShowDataAdpater.ViewHolder holder, int position) {

        Student item = mList.get(position);
        holder.name.setText(item.getName());
        holder.num.setText(item.getNum());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setmList(List<Student> mList) {
        this.mList = mList;
    }
}
