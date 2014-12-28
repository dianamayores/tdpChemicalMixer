package com.complete.thesisdesignproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        final EditText txtFaculty = (EditText)findViewById(R.id.txtFaculty);
        final EditText txtPassword = (EditText)findViewById(R.id.txtPassword);
        Button btnLogin = (Button)findViewById(R.id.btnLogIn);

        btnLogin.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                String faculty = txtFaculty.getText().toString();
                String password = txtPassword.getText().toString();

                try{
                    if(faculty.length() > 0 && password.length() >0)
                    {
                        DBthesis dbUser = new DBthesis(LoginActivity.this);
                        dbUser.open();

                        if(dbUser.Login(faculty, password))
                        {
                            Toast.makeText(LoginActivity.this,"Successfully Logged In", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(LoginActivity.this,"Invalid Faculty Number/Password", Toast.LENGTH_LONG).show();
                        }
                        dbUser.close();
                    }

                }catch(Exception e)
                     {Toast.makeText(LoginActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();}}
        });
    }
}