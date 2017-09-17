package com.codepath.flickster.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flickster.R;
import com.codepath.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.codepath.flickster.R.id.tvOverview;
import static com.codepath.flickster.R.id.tvTitle;

/**
 * Created by pam on 9/16/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie>{

    private static class ViewHolder {
        TextView title;
        TextView overview;
        ImageView image;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);

            viewHolder.title = (TextView) convertView.findViewById(tvTitle);
            viewHolder.overview = (TextView) convertView.findViewById(tvOverview);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            viewHolder.image.setImageResource(0);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.title.setText(movie.getOriginalTitle());
        viewHolder.overview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.image);
        return convertView;
    }
}

