package com.example.students.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
	// 由于父类没有无参构造函数, 所以子类必须指定调用父类哪个有参的构造函数
	public MyHelper(Context context) {
		super(context, "students.db", null, 2);

	}

	public void onCreate(SQLiteDatabase db) {
		System.out.println("正在创建表格");
		db.execSQL("CREATE TABLE temp_student(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name VARCHAR(20)," + // 姓名列
				"num  VARCHAR(20)"+ // xuehao
				")"
		);

		System.out.println("正在创建管理员表格");
		db.execSQL("CREATE TABLE table_admin(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name VARCHAR(20)," + // 姓名列
				"password  VARCHAR(20)"+ // xuehao
				")"
		);
		System.out.println("正在创建用户表格");
		db.execSQL("CREATE TABLE table_user(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name VARCHAR(20)," + // 姓名列
				"password  VARCHAR(20)"+ // xuehao
				")"
		);



	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("onUpgrade");
	}
}
