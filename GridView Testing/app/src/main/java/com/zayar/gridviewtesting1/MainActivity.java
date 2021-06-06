package com.zayar.gridviewtesting1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ImageAdapter mAdapter;
    private ArrayList<brandname> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        list=new ArrayList<>();
        list.add(new brandname(1,"MSI",R.drawable.msi));
        list.add(new brandname(2,"Asus",R.drawable.asus));
        list.add(new brandname(3,"Gigabyte",R.drawable.gigabyte));
        list.add(new brandname(4,"Asrock",R.drawable.asrock));
        if(mAdapter==null){
            mAdapter=new ImageAdapter(this,list);
            gridView.setAdapter(mAdapter);
        }
        else{
            mAdapter.setList(list);
            mAdapter.notifyDataSetChanged();
        }
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),((TextView)findViewById(R.id.itemLabel)).getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}