package com.example.divyasethi.login;

import android.content.res.Configuration;
import android.inputmethodservice.KeyboardView;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private int flag=0;
   private  int count=0;
    private LinearLayout linearLayout;
    private Button login;
  //  private MyAlertDialog alertDialog;
    //Counter counter;
   // private KeyboardView.OnKeyboardActionListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=(LinearLayout)findViewById(R.id.layout);
        username=(EditText)findViewById(R.id.user_name);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==KeyEvent.KEYCODE_ENTER){


                }
                return false;
            }
        });

    //    alertDialog= new MyAlertDialog(this);

      //  counter=new Counter(10000,1000);
       // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(flag==0)
                    flag=1;
                else{
                if(((EditText)v).getText()!=null)
                    if(!Validate((((EditText)v).getText()).toString()))
                        username.setError("Invalid username");

            }}
        });



    }

    private boolean Validate(String s){

        if(s.length()<5 && s.length()!=0) {
            String username_pattern = new String("[[a-z][A-Z][0-9]]*");
            Pattern pattern = Pattern.compile(username_pattern);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }
        return false;
    }
    long lastPressedTime=0;
    @Override
    public void onBackPressed(){

        count++;
        if(count==2)
            finish();
        Toast.makeText(getApplicationContext(),"Press back to exit",Toast.LENGTH_SHORT).show();
        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
            count=0;
            }
        }.start();

//        if(System.currentTimeMillis()-lastPressedTime<2000){
//            finish();
//        }else {
//            Toast.makeText(getApplicationContext(),"Press back to exit",Toast.LENGTH_SHORT).show();
//            lastPressedTime = System.currentTimeMillis();
//        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        if(newConfig.keyboardHidden==Configuration.KEYBOARDHIDDEN_NO){
            Toast.makeText(getApplicationContext(),"Good up til now !!!",Toast.LENGTH_SHORT).show();
            Log.e("Inside!!","onConfigChanged");
        }
    }


}
