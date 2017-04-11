package com.example.lyb.sharedpreferencesa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**
 * Created by lyb on 2017/4/11.
            */

    public class LoginActivity extends AppCompatActivity {
        private SharedPreferences pref;
        private SharedPreferences.Editor editor;
        private EditText name;
        private EditText pwd;
        private Button login;
        private CheckBox remeberPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        name = (EditText) findViewById(R.id.name_et);
        pwd = (EditText) findViewById(R.id.pwd_et);
        remeberPwd = (CheckBox) findViewById(R.id.remeber_pwd);
        login = (Button) findViewById(R.id.login);
        boolean isRemeber = pref.getBoolean("remeber_password",false);
        if (isRemeber){
            String account =  pref.getString("account","");
            String password = pref.getString("password","");
            name.setText(account);
            name.setText(password);
            remeberPwd.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = name.getText().toString();
                String password = pwd.getText().toString();

                if (account.equals("admin")&&password.equals("123456")){
                   editor = pref.edit();
                    if (remeberPwd.isChecked()){
                        editor.putBoolean("remeber_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toasty.error(LoginActivity.this,"account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
