package com.example.alzhicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AffirmationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affirmations);

        ArrayList<String> affirmations = new ArrayList<String>();

        affirmations.add("I am fearfully and wonderfully made.");
        affirmations.add("I contribute to this world everyday.");
        affirmations.add("I find happiness and comfort in making through it each day.");
        affirmations.add("I will conquer every single day that dawns upon me.");
        affirmations.add("I am blessed with a family that gives me hope, purpose and joy.");
        affirmations.add("I have the benifit of wisdom and experience.");
        affirmations.add("I am surrounded by people who love and care for me.");
        affirmations.add("This is my time to relax, count my blessings and cherish the people who matter to me.");
        affirmations.add("I am living the best years of my life.");
        affirmations.add("I am proud to have lived for so long.");

        ArrayAdapter<String> affirmAdapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,affirmations);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(affirmAdapter);

    }
}