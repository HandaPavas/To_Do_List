package com.example.root.to_do_list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailsFragment extends android.support.v4.app.Fragment {

    TextView title,description,date;



    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_details, container, false);
        title=(TextView)view.findViewById(R.id.titletextView);
        description=(TextView)view.findViewById(R.id.descriptiontextView);
        date=(TextView)view.findViewById(R.id.datetextView);
        Bundle bundle= getArguments();
        int position = bundle.getInt("count");
        title.setText(MainActivity.data.get(position).getTitle());
        description.setText(MainActivity.data.get(position).getDescription());
        date.setText(MainActivity.data.get(position).getDate());

        return view;
    }
}
