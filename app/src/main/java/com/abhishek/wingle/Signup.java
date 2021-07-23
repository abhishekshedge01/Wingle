package com.abhishek.wingle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Signup extends AppCompatActivity {

    TextView tv1_signin;
    Button btn_verify;
    FirebaseAuth firebaseAuth;
    EditText ed1_username,ed2_phone,ed3_pwd;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Window window;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        window=this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(this.getResources().getColor(R.color.pinky));
        }

        tv1_signin=findViewById(R.id.logintv);
        ed1_username=findViewById(R.id.ed1_username);
        ed2_phone=findViewById(R.id.ed2_phonenumber);
        ed3_pwd=findViewById(R.id.ed3_pass);
        btn_verify=findViewById(R.id.btn_signup);
        progressDialog=new ProgressDialog(getApplicationContext());
        firebaseAuth=FirebaseAuth.getInstance();

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }
    private void Register()
    {
        String str1=ed1_username.getText().toString();
        String str2=ed2_phone.getText().toString();
        String str3=ed3_pwd.getText().toString();


        // check if string1 is empty or not
        //alternative of textUtils is to check if the string is null and also chek if the str.length()==0 or else we might get nullptr exception
        if(TextUtils.isEmpty(str1))
        {
            ed1_username.setError("field empty");
            Toast.makeText(getApplicationContext(),"Username can't be empty!",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(str2))
        {
            ed2_phone.setError("field empty");
            Toast.makeText(getApplicationContext(),"Phone number can't be empty!",Toast.LENGTH_SHORT).show();
            return;
        }

        else if(TextUtils.isEmpty(str3))
        {
            ed3_pwd.setError("field empty");
            Toast.makeText(getApplicationContext(),"Password can't be empty!",Toast.LENGTH_SHORT).show();
            return;
        }

        else if(str3.length()<6)
        {
            ed3_pwd.setError("weak password");
            Toast.makeText(getApplicationContext(),"Password can't be weak!",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setTitle("Verifying");
        progressDialog.setMessage("Sending OTP...");
        progressDialog.setCanceledOnTouchOutside(false);
    }
}