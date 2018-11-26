package com.mobileapps.week2_weekendproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        MySQLHelper mySqlLiteHelper;
        EditText etFirstName;
        EditText etLastName;
        EditText etAddress;
        EditText etPhoneNumber;
        EditText etSkypeID;
        EditText etEmailAddress;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etFirstName = findViewById(R.id.etFirstName);
            etLastName=findViewById(R.id.etLastName);
            etAddress=findViewById(R.id.etAddress);
            etPhoneNumber=findViewById(R.id.etPhoneNumber);
            etSkypeID=findViewById(R.id.etSkypeID);
            etEmailAddress=findViewById(R.id.etEmail);

            mySqlLiteHelper=new MySQLHelper(this,null);

        }

        public void CLICK (View view) {
            switch (view.getId()){

                case R.id.btnIntoDB:

                    String uFirstName=etFirstName.getText().toString();
                    String uLastName=etLastName.getText().toString();
                    String uAddress=etAddress.getText().toString();
                    String uPhoneNumber=etPhoneNumber.getText().toString();
                    String uSkypeID=etSkypeID.getText().toString();
                    String uEmail=etEmailAddress.getText().toString();
                    mySqlLiteHelper.insertUser(uFirstName,uLastName,uAddress,uPhoneNumber,uSkypeID,uEmail);
                    break;
            }
        }
    }
