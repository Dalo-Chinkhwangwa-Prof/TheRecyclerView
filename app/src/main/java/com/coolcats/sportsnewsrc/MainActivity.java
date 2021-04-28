package com.coolcats.sportsnewsrc;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.coolcats.sportsnewsrc.model.News;
import com.coolcats.sportsnewsrc.view.NewsAdapter;
import com.coolcats.sportsnewsrc.view.NewsFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsAdapter.NewsDelegate, NewsFragment.NewsInterface {


    private NewsFragment newsFragment = new NewsFragment();

    List<News> news = new ArrayList<>(
            Arrays.asList(
                    new News(Sport.BASEBALL, "Tom Brady has switched to baseball", "04/28/2021"),
                    new News(Sport.BASKETBALL, "Lamelo back on the court", "04/29/2021"),
                    new News(Sport.SOCCER, "Messi sends a text to Ronaldo!", "04/25/2021"),
                    new News(Sport.TENNIS, "Rodgers retires!", "04/28/2021"))
    );

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SnapHelper helper = new LinearSnapHelper();
        recyclerView = findViewById(R.id.recyclerview);
        helper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(new NewsAdapter(news, this));
    }

    @Override
    public void selectNews(News news) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("news", news);
        newsFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.main_frame, newsFragment)
                .addToBackStack(newsFragment.getTag())
                .commit();

    }

    @Override
    public void example() {
        Toast.makeText(this, "Extra Extra - Read all about it!!", Toast.LENGTH_SHORT).show();
    }
}