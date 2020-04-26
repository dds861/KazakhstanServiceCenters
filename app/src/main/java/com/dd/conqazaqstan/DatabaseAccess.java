package com.dd.conqazaqstan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.appcompat.app.AppCompatActivity;

import com.dd.conqazaqstan.departments.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dds86 on 17-Nov-17.
 */

public class DatabaseAccess extends AppCompatActivity {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<Department> getDepartments(String regionName) {
        List<Department> list = new ArrayList<>();
        Department product;
        String sqlQueryText = "SELECT regions, otdeli, doljnost, city, street, phone, officehours " +
                "FROM quotes " +
                "WHERE " +
                "otdeli='Департамент' " +
                "AND " +
                "regions ='" + regionName + "'";
        Cursor cursor = database.rawQuery(sqlQueryText, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            product = new Department(cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
            list.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Department> getOtdeli(String regionName) {
        List<Department> list = new ArrayList<>();
        Department product;
        String sqlQueryText = "SELECT regions, otdeli, doljnost, city, street, phone, officehours " +
                "FROM quotes " +
                "WHERE " +
                "doljnost='Руководитель отдела' " +
                "AND " +
                "regions ='" + regionName + "'";
        Cursor cursor = database.rawQuery(sqlQueryText, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            product = new Department(cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
            list.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}