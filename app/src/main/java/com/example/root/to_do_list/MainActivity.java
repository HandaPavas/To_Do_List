package com.example.root.to_do_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView=(RecyclerView)findViewById(R.id.my_recycler_view);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager= new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);



    }
}
