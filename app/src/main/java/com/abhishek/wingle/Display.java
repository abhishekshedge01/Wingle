package com.abhishek.wingle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tv1_fgtpwd,tv2_signup;
        Button btn_login;
        EditText ed1_phone,ed2_pwd;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar().hide();
        tv2_signup=findViewById(R.id.registertv);
        tv1_fgtpwd=findViewById(R.id.forgotpwdtv);
        btn_login=findViewById(R.id.signinbtn);
        ed1_phone=findViewById(R.id.phonenumbered1);
        ed2_pwd=findViewById(R.id.passworded2);


        tv2_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Signup.class);
                startActivity(intent);
            }
        });
    }
}