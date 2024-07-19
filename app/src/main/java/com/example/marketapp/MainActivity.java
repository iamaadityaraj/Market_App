package com.example.marketapp;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListner{
    // 1. AdapterView
    RecyclerView RecyclerView;

    // 2. data Source
    List<item>ListItem;


    // 3. Adapter
    myCutomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        RecyclerView = findViewById(R.id.RecyclerView);

        // polyMorphism because Arraylist implements List
        ListItem=new ArrayList<>();

        item i1 = new item(R.drawable.fruit,"Fruit","Fruit are fresh comes driectly from garden");
        item i2 = new item(R.drawable.vegitables,"Vegitables","Delicious Vegitables");
        item i3 = new item(R.drawable.bread,"Bread","Bread, Wheat and Beans");
        item i4 = new item(R.drawable.beverage,"Beverage","Juice,Tea,Coffee and Soda");
        item i5 = new item(R.drawable.milk,"Milk","Milk,Shakes,Yogurt");
        item i6 = new item(R.drawable.popcorn,"Popcorn","Pop Corn,Donut and Drinks");

        ListItem.add(i1);
        ListItem.add(i2);
        ListItem.add(i3);
        ListItem.add(i4);
        ListItem.add(i5);
        ListItem.add(i6);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(layoutManager);

       adapter= new myCutomAdapter(ListItem);
       RecyclerView.setAdapter(adapter);

       adapter.setItemClickListner(this);
    }

    @Override
    public void onCLick(View v, int pos) {
        Toast.makeText(this,
                "You choose "+ListItem.get(pos).getItem_title(), Toast.LENGTH_SHORT).show();

    }
}