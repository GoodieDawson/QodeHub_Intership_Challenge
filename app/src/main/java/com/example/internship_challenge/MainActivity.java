package com.example.internship_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declare View for later article population
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Open first activity(main screen)
        setContentView(R.layout.activity_main);
        TextView taskbar = (TextView)findViewById(R.id.taskbar);
        taskbar.setText("NEWS");

        //Declare string to hold JSON data
        StringBuilder data = new StringBuilder();

        //Read JSON file and append articles to data string
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("article_list.json")));
            String line = bufferedReader.readLine();
            while (line != null){
                data.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d("FILE", data.toString());

        //Declare JSONArray amd Arraylist to be used in list population
        JSONArray articles_list = null;
        ArrayList<Article> article_array_list = new ArrayList<Article>();

        //Extract JSONArray and pass articles to article ArrayList
        try {
            JSONObject articles_reader  = new JSONObject(data.toString());
            articles_list = articles_reader.getJSONArray("articles");
            Log.d("LIST", articles_list.toString());

            for (int i = 0; i < articles_list.length(); i++) {
                JSONObject mJsonObjectProperty = articles_list.getJSONObject(i);

                String title = mJsonObjectProperty.getString("title");
                Log.d("TITLE", title);
                String publisher = mJsonObjectProperty.getString("publisher");
                Log.d("PUBLISHER", publisher);
                String img = mJsonObjectProperty.getString("image");
                Log.d("IMAGE", img);
                String text = mJsonObjectProperty.getString("text");
                Log.d("TEXT", text);


                Article current = new Article(title, publisher, img, text);

                article_array_list.add(current);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Pass articles ArrayList to ArticleAdapter to populate ListView
        lv = findViewById(R.id.news_list);
        ArticleAdapter adapter = new ArticleAdapter(this, article_array_list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Article selectedItem = (Article) parent.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, ReadMoreActivity.class);
                intent.putExtra("chosen_article", selectedItem);
                startActivity(intent);

            }
        });
    }
}

