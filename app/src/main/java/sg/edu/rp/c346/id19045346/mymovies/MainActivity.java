package sg.edu.rp.c346.id19045346.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvmovie;
    ArrayList<Movie> alMovie;
    CustomAdapter caMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvmovie = findViewById(R.id.ListViewMovies);
        alMovie = new ArrayList<>();

        lvmovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movieslected = alMovie.get(position);
                String title = movieslected.getTitle();
                int year = movieslected.getYear();
                String rated = movieslected.getRated();
                String genre = movieslected.getGenre();
                Calendar calendar = movieslected.getWatched_on();
                String date = movieslected.getWatched_on().get(Calendar.DAY_OF_MONTH) + "/" +
                        movieslected.getWatched_on().get(Calendar.MONTH) + "/" + movieslected.getWatched_on().get(Calendar.YEAR);
                String theatre = movieslected.getIn_theatre();
                String description = movieslected.getDescription();
                int rating =  movieslected.getRatingbar();

                Intent intent = new Intent(MainActivity.this,MovieDescription.class);
                intent.putExtra("title",title);
                intent.putExtra("year" ,year);
                intent.putExtra("rated", rated);
                intent.putExtra("genre",genre);
                intent.putExtra("calendar",date);
                intent.putExtra("theatre",theatre);
                intent.putExtra("description",description);
                intent.putExtra("ratingbar",rating);
                startActivity(intent);
            }
        });

        Calendar date = Calendar.getInstance();
        date.set(2014,11,15);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015,5,15);




        Movie movie1 = new Movie("The Avengers",2012,"pg13","Action | Sci-Fi",date,
                "Golden Village - Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheros to save the planet from Loki and his army.",4);

        Movie movie2 = new Movie("Planes",2013,"pg","Animation | Comedy", date2, "Cathay - AMK Hub",
                "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",2);
        alMovie.add(movie1);
        alMovie.add(movie2);
        caMovie = new CustomAdapter(this,R.layout.row,alMovie);
        lvmovie.setAdapter(caMovie);
    }


}
