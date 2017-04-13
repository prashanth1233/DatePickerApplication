package com.example.prasanth.datepickerapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int DATE_PICKER_ID = 999;
    private EditText dateOutput;
    DatePicker datePicker;
    private int year, month, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateOutput = (EditText) findViewById(R.id.dateShowing);
        dateOutput.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        showDialog(DATE_PICKER_ID);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DATE_PICKER_ID) {
            return new DatePickerDialog(this, dateSetListener, year, month, date);
        } else
            return null;
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDate) {
            year = selectedYear;
            month = selectedMonth;
            date = selectedDate;
            dateOutput.setText(new StringBuilder().append(month + 1).append("-").append(date).append("-").append(year));
            datePicker.init(year, month, date, null);
        }
    };

}
