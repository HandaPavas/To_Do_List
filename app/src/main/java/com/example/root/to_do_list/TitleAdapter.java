package com.example.root.to_do_list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by root on 11/4/16.
 */
public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;
    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback{
        void onItemClick(int p);


    }

    public  void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback=itemClickCallback;
    }


    public TitleAdapter(List<Title> titlelist) {

        MainActivity.data = titlelist;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("message", "onCreateViewHolder: ");

        inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Log.d("message", "onBindViewHolder");
        Title current = MainActivity.data.get(position);
        holder.title.setText(current.getTitle());

    }

    @Override
    public int getItemCount() {
        return MainActivity.data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView icon;
        View cardview;


        public MyViewHolder(View itemView ) {
            super(itemView);
            Log.d("message", "MyViewHolder ");
            title= (TextView) itemView.findViewById(R.id.listText);
            icon= (ImageView) itemView.findViewById(R.id.listIcon);
            cardview=itemView.findViewById(R.id.card_view);
            cardview.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


            if(view.getId()== R.id.card_view){
                itemClickCallback.onItemClick(getAdapterPosition());

            }

        }
    }
}