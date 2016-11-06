package com.example.root.to_do_list;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddTitleActivity extends AppCompatActivity {
    public static ArrayList<Title> titles =new ArrayList<Title>();

    ImageButton datebutton;
    Button savebttn;
    EditText datetext,titletext,descriptortext;
    int year_x,month_x,day_x;
    static final int DIALOG_ID=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_title);
        Intent intent = getIntent();
        showDialogOnClick();
        savedataOnClick();;
    }

    public void showDialogOnClick(){

        datebutton = (ImageButton) findViewById(R.id.dateButton);

        datebutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                //Toast.makeText(getApplicationContext(),"Date Picker",Toast.LENGTH_SHORT).show();
                showDialog(DIALOG_ID);

            }
        });
    }

    public void savedataOnClick(){

        savebttn = (Button) findViewById(R.id.savebutton);

        savebttn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                titletext= (EditText) findViewById(R.id.addtitle);
                descriptortext= (EditText) findViewById(R.id.adddescription);
                datetext= (EditText) findViewById(R.id.adddate);
                if(titletext.getText().toString().isEmpty()||descriptortext.getText().toString().isEmpty()||datetext.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Invalid Enteries !!",Toast.LENGTH_SHORT).show();
                }
                else {
                    String date= datetext.getText().toString();
                    String description=descriptortext.getText().toString();
                    String title= titletext.getText().toString();
                    /*Intent returnIntent = new Intent();
                    returnIntent.putExtra("title", title);
                    returnIntent.putExtra("date", date);
                    returnIntent.putExtra("description", description);*/
                    MainActivity.data.add(new Title(title,description,date));
                    Toast.makeText(getApplicationContext(), "Data Saved !!", Toast.LENGTH_SHORT).show();
                    // setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }


                // Toast.makeText(getApplicationContext(),"Date Saved",Toast.LENGTH_SHORT).show();


            }
        });
    }


    @Override
    protected Dialog onCreateDialog(int id){

        if(id==DIALOG_ID) {
            final Calendar c = Calendar.getInstance();
            year_x = c.get(Calendar.YEAR);
            month_x = c.get(Calendar.MONTH);
            day_x = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(this, dpickerListener, year_x, month_x, day_x);


        }
        return null;

    }

    private DatePickerDialog.OnDateSetListener dpickerListener
            = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

            datetext= (EditText) findViewById(R.id.adddate);
            year_x=year;
            month_x=monthOfYear+1;
            day_x=dayOfMonth;

            datetext.setText(day_x+"/"+month_x+"/"+year_x);
        }
    };
}
