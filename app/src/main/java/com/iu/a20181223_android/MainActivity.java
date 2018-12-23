package com.iu.a20181223_android;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private android.widget.Button logoutBtn;
    private Button timeBtn;
    private TextView timeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("로그아웃 확인");
                alert.setMessage("정말 로그아웃 하시겠어요?");
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("취소", null);
                alert.show();
            }
        });

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener otsl = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String selectedTime = String.format("%d시 %d분",hourOfDay,minute);
                        //Toast.makeText(mContext, "시간 설정됨", Toast.LENGTH_SHORT).show();
                        timeTxt.setText(selectedTime);
                    }
                };

                TimePickerDialog tpd = new TimePickerDialog(mContext,otsl,13,32,true);
                tpd.show();
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.timeBtn = (Button) findViewById(R.id.timeBtn);
        this.logoutBtn = (Button) findViewById(R.id.logoutBtn);
        timeTxt = findViewById(R.id.timeTxt);
    }
}
