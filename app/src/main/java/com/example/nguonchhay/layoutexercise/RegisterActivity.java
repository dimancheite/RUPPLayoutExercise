package com.example.nguonchhay.layoutexercise;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editFullName = (EditText) findViewById(R.id.editFullName);
                EditText editEmail = (EditText) findViewById(R.id.editEmail);
                EditText editPassword = (EditText) findViewById(R.id.editPassword);

                String inputFullName = editFullName.getText().toString();
                String inputEmail = editEmail.getText().toString();
                String inputPassword = editPassword.getText().toString();

                if (inputFullName.equalsIgnoreCase("") || inputEmail.equalsIgnoreCase("") || inputPassword.equalsIgnoreCase("")) {
                    Toast.makeText(RegisterActivity.this, "Please, provide Fullname, Email, and Password.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent returnIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    returnIntent.putExtra("fullName", inputFullName);
                    returnIntent.putExtra("email", inputEmail);
                    returnIntent.putExtra("password", inputPassword);
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }
            }
        });

        TextView txvLoginMe = (TextView) findViewById(R.id.txvLoginMe);
        txvLoginMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
