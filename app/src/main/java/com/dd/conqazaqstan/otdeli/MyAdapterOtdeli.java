package com.dd.conqazaqstan.otdeli;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dd.conqazaqstan.R;
import com.dd.conqazaqstan.departments.Department;

import java.util.List;

/**
 * Created by dds86 on 17-Nov-17.
 */

public class MyAdapterOtdeli extends ArrayAdapter<Department> {
    private List<Department> objects;

    public MyAdapterOtdeli(@NonNull Context context, @NonNull List<Department> objects) {
        super(context, 0, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.items_otdeli, parent, false);

        Department product = getItem(position);

        TextView textView2 = (TextView) view.findViewById(R.id.otdelDoljnost);
        TextView textView3 = (TextView) view.findViewById(R.id.otdelCity);
        TextView textView4 = (TextView) view.findViewById(R.id.otdelAddress);
        TextView textView5 = (TextView) view.findViewById(R.id.otdelPhoneNumber);

        textView2.setText(product.getTextView2());
        textView3.setText(product.getTextView3());
        textView4.setText(product.getTextView4());
        textView5.setText(product.getTextView5());

        return view;
    }
}
