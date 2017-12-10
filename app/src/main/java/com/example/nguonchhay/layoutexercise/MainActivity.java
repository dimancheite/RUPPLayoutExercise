package com.example.nguonchhay.layoutexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int MAIN_ACTIVITY_REGISTER_CODE = 123;

    protected String fullName = "", email = "", password = "";
    protected EditText editEmail, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editEmail.setText(email);

        editPassword = (EditText) findViewById(R.id.editPassword);
        editPassword.setText("");

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputEmail = editEmail.getText().toString();
                String inputPassword = editPassword.getText().toString();

                if (inputEmail.equalsIgnoreCase("") || inputPassword.equalsIgnoreCase("")) {
                    Toast.makeText(MainActivity.this, "Please, provide Email and Password.", Toast.LENGTH_SHORT).show();
                } else {
                    if (inputEmail.equalsIgnoreCase(email) && inputPassword.equals(password)) {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("fullName", fullName);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Email or Password are incorrect.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        TextView txvSignUp = (TextView) findViewById(R.id.txvSignUp);
        txvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullName = email = password = "";
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivityForResult(intent, MAIN_ACTIVITY_REGISTER_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MAIN_ACTIVITY_REGISTER_CODE) {
            if (resultCode == RESULT_OK) {
                fullName = data.getStringExtra("fullName");
                email = data.getStringExtra("email");
                password = data.getStringExtra("password");

                System.out.println(fullName + " - " + email + " - " + password);
            }
        }
    }
}
