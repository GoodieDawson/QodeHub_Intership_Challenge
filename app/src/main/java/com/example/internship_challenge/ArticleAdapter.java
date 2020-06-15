package com.example.internship_challenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArticleAdapter extends ArrayAdapter<Article> {


    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    //Pass Article attributes to row layout
    public View getView(int position, View convertView, ViewGroup parent) {

        Article article = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);

        }

        TextView title = (TextView) convertView.findViewById(R.id.title);

        TextView publisher = (TextView) convertView.findViewById(R.id.publisher);

        title.setText(article.article_name);

        publisher.setText(article.article_publisher);

        return convertView;

    }
}
