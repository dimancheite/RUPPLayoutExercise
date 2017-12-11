package com.example.nguonchhay.layoutexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        TextView txvFullName = (TextView) findViewById(R.id.txvFullName);
        txvFullName.setText(intent.getStringExtra("fullName"));

        TextView txvEmail = (TextView) findViewById(R.id.txvEmail);
        txvEmail.setText(intent.getStringExtra("email"));

        TextView txvSex = (TextView) findViewById(R.id.txvSex);
        txvSex.setText(intent.getStringExtra("sex"));

        Button btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
