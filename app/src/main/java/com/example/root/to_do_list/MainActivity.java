package com.example.root.to_do_list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TitleAdapter.ItemClickCallback{

    ImageButton floatButton;
    String title,date,description;
    static int position;
    private RecyclerView mRecycleView;
    private RecyclerView.LayoutManager mLayoutManager;
    private TitleAdapter mAdapter;

    public static  List<Title> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatButton= (ImageButton) findViewById(R.id.imageButton);
        floatButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                // Toast.makeText(getApplicationContext(),"Button Is Clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AddTitleActivity.class);
                // startActivityForResult(intent,1);
                startActivity(intent);
            }
        });

        mRecycleView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // mRecycleView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);


        mAdapter = new TitleAdapter(data );
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setItemClickCallback(this);


    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                title=data.getStringExtra("title");
                description=data.getStringExtra("description");
                date=data.getStringExtra("date");
            }

        }
    }*///onActivityResult
   /* public List<Title> getData() {


         int[] icons = {R.drawable.pen, R.drawable.pen, R.drawable.pen, R.drawable.pen};
        String[] titles = {"BreakFast", "BirthDay", "Aniversary", "Meeting"};
       for (i = 0; i < AddTitleActivity.titles.size(); i++) {

          Title current = new Title(title,description,date);
         current.getTitle() = title;
        data.add(new Title(title,description,date));
       Intent i= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);


        }
        return data;
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(int p) {

       Title title = (Title) data.get(p);
        position=p;
        Intent intent = new Intent(this,DisplayDetailActivity.class);
        Bundle extras= new Bundle();
        extras.putString("title",title.getTitle());
        extras.putString("data",title.getDate());
        extras.putString("description",title.getDescription());

        intent.putExtra("Bundle_Extras",extras);
        startActivity(intent);


    }
}
