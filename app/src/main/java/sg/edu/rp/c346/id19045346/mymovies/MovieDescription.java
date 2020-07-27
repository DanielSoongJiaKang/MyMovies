package sg.edu.rp.c346.id19045346.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Calendar;

public class MovieDescription extends AppCompatActivity {

    TextView tvtitle;
    TextView tvYear;
    ImageView ivRated;
    TextView tvGenre;
    TextView tvCalendar;
    TextView tvTheatre;
    TextView tvDescription;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_description);

        tvtitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        ivRated = findViewById(R.id.imageViewRates);
        tvGenre = findViewById(R.id.textViewGenre);
        tvCalendar = findViewById(R.id.textViewwatchon);
        tvTheatre = findViewById(R.id.textViewIntheatre);
        tvDescription = findViewById(R.id.textViewDescription);
        ratingBar = findViewById(R.id.ratingbar);

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        int year = intentReceived.getIntExtra("year",0);
        String rated = intentReceived.getStringExtra("rated");
        String genre = intentReceived.getStringExtra("genre");
        String cal = intentReceived.getStringExtra("calendar");
        String theatre = intentReceived.getStringExtra("theatre");
        String description = intentReceived.getStringExtra("description");
        int ratingbar = intentReceived.getIntExtra("ratingbar",0);


        tvtitle.setText(title);
        tvYear.setText("" + year);
        tvDescription.setText(description);
        tvCalendar.setText(cal);
        tvGenre.setText(genre);
        tvTheatre.setText(theatre);
        ratingBar.setRating(ratingbar);

        if(rated.equals("g")) {
            ivRated.setImageResource(R.drawable.rating_g);
        }
        else if(rated.equals("pg")) {
            ivRated.setImageResource(R.drawable.rating_pg);
        }
        else if(rated.equals("pg13")) {
            ivRated.setImageResource(R.drawable.rating_pg13);
        }

        else if(rated.equals("nc16")) {
            ivRated.setImageResource(R.drawable.rating_nc16);
        }
        else if(rated.equals("m18")) {
            ivRated.setImageResource(R.drawable.rating_m18);
        }
        else if(rated.equals("r21")) {
            ivRated.setImageResource(R.drawable.rating_r21);
        }



    }
}
