package com.artcak.artcaklibraryexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.artcak.artcaklibrary.date.TimeHelper;

public class MainActivity extends AppCompatActivity {
    TextView tv_formatedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_formatedTime = findViewById(R.id.tv_formatedTime);
        custom();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.rb_time1:
                if (checked)
                    tv_formatedTime.setText(TimeHelper.getFormatedTime(TimeHelper.getTimeNow(),1));
                    break;
            case R.id.rb_time2:
                if (checked)
                    tv_formatedTime.setText(TimeHelper.getFormatedTime(TimeHelper.getTimeNow(),2));
                    break;
            case R.id.rb_time3:
                if (checked)
                    tv_formatedTime.setText(TimeHelper.getFormatedTime(TimeHelper.getTimeNow(),3));
                    break;
            case R.id.rb_time4:
                if (checked)
                    tv_formatedTime.setText(TimeHelper.getFormatedTime(TimeHelper.getTimeNow(),4));
                    break;
            case R.id.rb_time5:
                if (checked)
                    tv_formatedTime.setText(TimeHelper.getFormatedTime(TimeHelper.getTimeNow(),5));
                    break;
            case R.id.rb_time6:
                if (checked)
                    tv_formatedTime.setText(TimeHelper.getFormatedTime(TimeHelper.getTimeNow(),TimeHelper.FORMAT_DAY_TO_YEAR_SHORTMONTH));
                break;
            case R.id.rb_time7:
                if (checked)
                    tv_formatedTime.setText(TimeHelper.getFormatedTime(TimeHelper.getTimeNow(),TimeHelper.FORMAT_DAY_TO_SECOND_SHORTMONTH));
                break;
        }
    }

    private void custom(){
        tv_formatedTime.setText(TimeHelper.getFormatedTime(TimeHelper.getTimeNow()));
    }
}
