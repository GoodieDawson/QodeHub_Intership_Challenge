package com.example.internship_challenge;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ReadMoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Open second activity(read more screen)
        setContentView(R.layout.read_more_page);

        //Get selected article
        Article article = (Article) getIntent().getSerializableExtra("chosen_article");

        Log.d("CHOSEN", article.getArticle_name());

        //Populate page with article attributes

        ImageView img = (ImageView)findViewById(R.id.img);

        Log.d("CHOSEN_img", article.getArticle_img());
        Picasso.get().load(article.getArticle_img()).placeholder(R.drawable.ic_launcher_background).fit().into(img);

        TextView title_above = (TextView)findViewById(R.id.title_above);
        title_above.setText(article.getArticle_name());

        TextView title_below = (TextView)findViewById(R.id.title_below);
        title_below.setText(article.getArticle_name());

        TextView publisher = (TextView)findViewById(R.id.publisher);
        publisher.setText(article.getArticle_publisher());

        TextView text = (TextView)findViewById(R.id.text);
        text.setText(article.getArticle_text());


    }
}