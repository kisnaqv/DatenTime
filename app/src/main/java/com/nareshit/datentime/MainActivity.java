package com.nareshit.datentime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button button,time;
    TextView textView;
    EditText e1;
    String ddd,mm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.pickdate);
        textView=findViewById(R.id.date);
        time=findViewById(R.id.picktime);
        e1=findViewById(R.id.time);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar=Calendar.getInstance();
                int y=calendar.get(Calendar.YEAR);
                int m=calendar.get(Calendar.MONTH);
                int d=calendar.get(Calendar.DATE);

                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet
                            (DatePicker view, int year, int month, int dayOfMonth) {
                        mm=""+month;
                        ddd=""+dayOfMonth;

                        if(month<10 ){

                            mm="0"+month;

                            //textView.setText(year+"/"+0+month+"/"+"0"+dayOfMonth);
                        }
                        if(dayOfMonth<10){
                            ddd="0"+dayOfMonth;



                        }
                        textView.setText(year + "/" + mm + "/" + ddd);
                        Toast.makeText(MainActivity.this, ""+year + "/" + mm + "/" + ddd,Toast.LENGTH_SHORT).show();



                    }
                },y,m,d
                );
                datePickerDialog.show();
                //selection fast date
                //datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());

                //future date
                //datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis()-1000);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

            }
        });


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int h=calendar.get(Calendar.HOUR);
                int m=calendar.get(Calendar.MINUTE);
                int s=calendar.get(Calendar.SECOND);

                TimePickerDialog timePickerDialog=new TimePickerDialog(
                        MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        e1.setText(hourOfDay+":"+minute);
                    }
                },h,m,false
                );
                timePickerDialog.show();

            }
        });
    }
}
