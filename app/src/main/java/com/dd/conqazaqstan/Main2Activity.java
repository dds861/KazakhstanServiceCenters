package com.dd.conqazaqstan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;

import com.dd.conqazaqstan.departments.Department;
import com.dd.conqazaqstan.departments.MyAdapterDepartments;
import com.dd.conqazaqstan.otdeli.MyAdapterOtdeli;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView listViewDepartments;
    private ListView listViewOtdeli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        String regionName = getIntent().getStringExtra("regionName");

        this.listViewDepartments = (ListView) findViewById(R.id.listViewDepartments);
        List<Department> quotes = databaseAccess.getDepartments(regionName);
        MyAdapterDepartments myAdapter = new MyAdapterDepartments(getApplicationContext(), quotes);
        listViewDepartments.setAdapter(myAdapter);


        this.listViewOtdeli = (ListView) findViewById(R.id.listViewOtdeli);
        List<Department> quotes2 = databaseAccess.getOtdeli(regionName);
        MyAdapterOtdeli myAdapter2 = new MyAdapterOtdeli(getApplicationContext(), quotes2);
        listViewOtdeli.setAdapter(myAdapter2);

        Utility.setListViewHeightBasedOnChildren(listViewDepartments);
        Utility.setListViewHeightBasedOnChildren(listViewOtdeli);

        databaseAccess.close();



    }
}
