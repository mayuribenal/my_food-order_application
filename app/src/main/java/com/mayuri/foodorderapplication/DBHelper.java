package com.mayuri.foodorderapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.mayuri.foodorderapplication.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
   final static String  DBNAME = "mydatabase.db";
    final static int DBVERSION =9;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(
            "create table orders " +
                    "(id integer primary key Autoincrement,"+
                    "name text,"+
                    "phone text,"+
                    "price int," +
                    "image int ,"+
                    "quantity int ,"+
                    "description ,"+
                    "foodname)"
    );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    sqLiteDatabase.execSQL("DROP table if exists orders ");
    onCreate(sqLiteDatabase);
    }

    public boolean insertOrder (String name,String phone,int price,int image,String desc,String foodName,int quantity) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodName",foodName);
        values.put("quantity",quantity);
        long id = database.insert("orders",null,values);
        if(id <= 0){
            return false;
        }else {
            return true;
        }
    }
    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select id,foodName,image,price from orders",null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OrdersModel model = new OrdersModel();


                model.setOrderNumber(cursor.getInt(0) + "");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }

        cursor.close();
        database.close();
        return orders;
    }
}
