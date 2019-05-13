package com.example.swipedeleterecyclerview;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{

    RecyclerView recyclerView;
    MyAdapter adapter;
    List<Model> models = new ArrayList<>();
    Context context;

//    https://smartdevelopers.ir/%D8%AD%D8%B0%D9%81-%D8%A2%DB%8C%D8%AA%D9%85-%D9%87%D8%A7%DB%8C-recyclerview-%D8%A8%D8%A7-swipe-%DA%A9%D8%B1%D8%AF%D9%86-%D8%A2%D9%86%D9%87%D8%A7/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        recyclerView=findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter =new MyAdapter(models,context);
        recyclerView.setAdapter(adapter);
//        ItemTouchHelper itemTouchHelper = new
//                ItemTouchHelper(new SwipeToDeleteCallback(mAdapter));
//        itemTouchHelper.attachToRecyclerView(recyclerView);
//        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
//        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

        ItemTouchHelper.SimpleCallback simpleCallback=new RecyclerItemTouchHelper(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT,this);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);

        loadData();

    }

    private void loadData() {
        models.add(new Model("ali"));
        models.add(new Model("reza"));
        models.add(new Model("hasan"));
        models.add(new Model("ali"));
        models.add(new Model("mani"));
    }


    @Override
    public void onSwiped(RecyclerView.ViewHolder holder, int direction, int position) {
        adapter.remove(position);
    }
}
