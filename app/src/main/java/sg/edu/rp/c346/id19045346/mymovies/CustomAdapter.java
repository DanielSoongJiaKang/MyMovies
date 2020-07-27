package sg.edu.rp.c346.id19045346.mymovies;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;


    public CustomAdapter(Context context,int resource,ArrayList<Movie> objects){
        super(context,resource,objects);

        parent_context=context;
        layout_id=resource;
        movieList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvtitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvyear = rowView.findViewById(R.id.textViewYear);
        TextView tvgenre = rowView.findViewById(R.id.textViewGenre);
        ImageView ivrated = rowView.findViewById(R.id.imageViewRates);


        // Obtain the Android Version information based on the position
        Movie currentmovie = movieList.get(position);

        // Set values to the TextView to display the corresponding information
        tvtitle.setText(currentmovie.getTitle());
        tvyear.setText(""+currentmovie.getYear());
        tvgenre.setText(currentmovie.getGenre());

        if(currentmovie.getYear() == 2020) {

            tvyear.getResources().getColor(android.R.color.holo_red_dark);
        }


        if(currentmovie.getGenre().equals("g")) {
            ivrated.setImageResource(R.drawable.rating_g);
        }
        else if (currentmovie.getGenre().equals("pg")) {
            ivrated.setImageResource(R.drawable.rating_pg);
        }
        else if (currentmovie.getGenre().equals("pg13")) {
            ivrated.setImageResource(R.drawable.rating_pg13);
        }
        else if (currentmovie.getGenre().equals("nc16")) {
            ivrated.setImageResource(R.drawable.rating_nc16);
        }
        else if (currentmovie.getGenre().equals("m18")) {
            ivrated.setImageResource(R.drawable.rating_m18);
        }
        else if (currentmovie.getGenre().equals("r21")) {
            ivrated.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }

}
