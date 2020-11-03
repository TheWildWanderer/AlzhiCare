package com.example.alzhicare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
       /*
        TextView textView=findViewById(R.id.current_time);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String currentTime = sdf.format(new Date());
        textView.setText(currentTime);*/

        TextView textView1=findViewById(R.id.todays_date);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMM yyyy");
        String currentDate = sdf1.format(new Date());
        textView1.setText(currentDate);

        TextView textView2=findViewById(R.id.day_of_week);
        Calendar sCalender = Calendar.getInstance();
        String currentDay = sCalender.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG,Locale.getDefault());

        String sun="Jerelyn";
        ImageView imageView=findViewById(R.id.time_of_day);
        int timeOfDay = sCalender.get(Calendar.HOUR_OF_DAY);
        if(timeOfDay>=4 && timeOfDay<6){
            sun = "Morning";
            textView2.setText("It's "+currentDay+" "+sun+"!");
            imageView.setImageResource(R.drawable.displaymorning);
        }
        else if(timeOfDay>=6 && timeOfDay<12){
            sun = "Morning";
            textView2.setText("It's "+currentDay+" "+sun+"!");
            imageView.setImageResource(R.drawable.displayday);
        }
        else if(timeOfDay>=12 && timeOfDay<16){
            //afternoon
            sun = "Afternoon";
            textView2.setText("It's "+currentDay+" "+sun+"!");
            imageView.setImageResource(R.drawable.displayafternoon);

        }
        else if(timeOfDay>=16 && timeOfDay<21){
            //evening
            sun = "Evening";
            textView2.setText("It's "+currentDay+" "+sun+"!");
            imageView.setImageResource(R.drawable.displayevening);

        }
        else if((timeOfDay>=21 && timeOfDay<24)||(timeOfDay>=0 && timeOfDay<5)){
            //night
            sun = "Night";
            textView2.setText("It's "+currentDay+" "+sun+"!");
            imageView.setImageResource(R.drawable.displaynight);

        }



        ///////////////////////////////////////EXPLICIT INTENTS

        // Find the View that shows the numbers category
        ImageButton affirm = (ImageButton) findViewById(R.id.buttonAffirmations);
        affirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent affirmIntent = new Intent(MainActivity.this, AffirmationsActivity.class);
                startActivity(affirmIntent);
            }
        });

        ImageButton memories = (ImageButton) findViewById(R.id.buttonMemories);
        memories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent memoriesIntent = new Intent(MainActivity.this, MemoriesActivity.class);
                startActivity(memoriesIntent);
            }
        });

        ImageButton grateful = (ImageButton) findViewById(R.id.buttonGrateful);
        grateful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gratefulIntent = new Intent(MainActivity.this, GratefulActivity.class);
                startActivity(gratefulIntent);
            }
        });

        ImageButton reminders = (ImageButton) findViewById(R.id.buttonReminders);
        reminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent remindersIntent = new Intent(MainActivity.this, RemindersActivity.class);
                startActivity(remindersIntent);
            }
        });
        /*
        ImageButton movies = (ImageButton) findViewById(R.id.buttonMovies);
        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moviesIntent = new Intent(MainActivity.this, MoviesActivity.class);
                startActivity(moviesIntent);
            }
        });*/

        ImageButton me = (ImageButton) findViewById(R.id.buttonAboutMe);
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutMeIntent = new Intent(MainActivity.this, AboutmeActivity.class);
                startActivity(aboutMeIntent);
            }
        });

        ImageButton settings = (ImageButton) findViewById(R.id.buttonSettings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        ///////////////////////////////////////IMPLICIT INTENTS
        ImageButton games = (ImageButton) findViewById(R.id.buttonGames);
        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchGameBrowser = new Intent(Intent.ACTION_VIEW);
                launchGameBrowser.setData(Uri.parse("https://www.brightfocus.org/alzheimers/memory-games"));
                startActivity(launchGameBrowser);
            }
        });

        ImageButton music = (ImageButton) findViewById(R.id.buttonMusic);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchSpotify = new Intent(Intent.ACTION_VIEW);
                launchSpotify.setData(Uri.parse("https://open.spotify.com/playlist/6FJ4OmNsXnZ7pU7Bh06M1q?si=m8tW7MO5TOa-q3KLSQveBQ"));
                startActivity(launchSpotify);
            }
        });

        ImageButton sos = (ImageButton)findViewById(R.id.buttonHelp);
        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOfHelper="8825899099";
                Intent sosCall = new Intent(Intent.ACTION_DIAL);
                sosCall.setData(Uri.parse("tel:"+numberOfHelper.trim()));
                startActivity(sosCall);
            }
        });



    }
}