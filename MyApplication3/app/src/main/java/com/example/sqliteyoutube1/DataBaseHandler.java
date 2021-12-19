package com.example.sqliteyoutube1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {
    static final int DATABASE_VERSION=1;
    static final String DATABASE_Name="CustomerDB.db";

    static final String TABLE_CUSTOMERS="customers";
    static final String COLUMN_ID="_id";
    static final String COLUMN_NAME="name";
    static final String COLUMN_AGE="age";

    public DataBaseHandler(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory)
    {
        super(context,DATABASE_Name,factory,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement="CREATE TABLE "+TABLE_CUSTOMERS+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COLUMN_NAME+" TEXT,"
                +COLUMN_AGE+" INT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Customer customer){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,customer.getName());
        cv.put(COLUMN_AGE,customer.getAge());
        long insert=db.insert(TABLE_CUSTOMERS,null,cv);
        if(insert==-1)
            return false;
        else
            return true;

    }
    public List<Customer> getEveryone(){
        List<Customer> returnList=new ArrayList<>();
        String queryString="SELECT * FROM "+ TABLE_CUSTOMERS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            do{
                int customerID=cursor.getInt(0);
                String customerName=cursor.getString(1);
                int customerAge=cursor.getInt(2);
                Customer newCustomer=new Customer(customerID,customerName,customerAge);
                returnList.add(newCustomer);
            }while(cursor.moveToNext());
        }
        else
        {

        }


        return returnList;

    }

}