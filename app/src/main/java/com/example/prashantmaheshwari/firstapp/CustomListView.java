package com.example.prashantmaheshwari.firstapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by prashant maheshwari on 26-02-2018.
 */

public class CustomListView extends ArrayAdapter<Works> {

    List<Works> extrasList;
    Context context;
    int resource;

    public CustomListView(Context context, int resource, List<Works> extrasList) {
        super(context, resource, extrasList);
        this.context = context;
        this.resource = resource;
        this.extrasList = extrasList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        @SuppressLint("ViewHolder")
        View CustomView = layoutInflater.inflate(resource,parent,false);

        TextView myText = (TextView)CustomView.findViewById(R.id.title);
        ImageView image = (ImageView)CustomView.findViewById(R.id.list_image);
        TextView Money = (TextView)CustomView.findViewById(R.id.artist);

        Works extras = extrasList.get(position);

        image.setImageDrawable(context.getResources().getDrawable(extras.getImage()));
        myText.setText(extras.getTitle());
        Money.setText(extras.getMoney());

        return CustomView;


    }
}
