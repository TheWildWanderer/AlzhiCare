package com.example.alzhicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GratefulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grateful);


    }

    public void doneGrateful(View view){
        EditText gratefulInput = (EditText) findViewById(R.id.grateful_one);
        String one = gratefulInput.getText().toString();
        EditText gratefulInput1 = (EditText) findViewById(R.id.grateful_two);
        String two = gratefulInput1.getText().toString();
        EditText gratefulInput2 = (EditText) findViewById(R.id.grateful_three);
        String three = gratefulInput2.getText().toString();

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
        String datesub = sdf1.format(new Date());

        Intent email = new Intent(Intent.ACTION_SEND);
        String to="jerelynpreeja@gmail.com";
        String subject = "("+datesub +") I am grateful for";
        String message = "Today, I am grateful for : \n1)"+one+"\n2)"+two+"\n2)"+three;
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        if (email.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(email, "Choose an Email client :"));
        }}
}