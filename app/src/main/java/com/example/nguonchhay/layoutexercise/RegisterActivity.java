package com.example.nguonchhay.layoutexercise;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class RegisterActivity extends AppCompatActivity implements OnItemSelectedListener {

    protected String sex = "";
    protected Spinner spinnerSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinnerSex = (Spinner) findViewById(R.id.spinnerSex);
        spinnerSex.setOnItemSelectedListener(this);
        String[] dataSex = { "Please select gender", "Male", "Female", "Other" };
        ArrayAdapter<String> adapterState = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSex);
        adapterState.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSex.setAdapter(adapterState);

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
                    returnIntent.putExtra("sex", sex);
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

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        sex = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
