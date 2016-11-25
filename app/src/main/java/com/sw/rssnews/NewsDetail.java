package com.sw.rssnews;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sw.rssnews.fragment.FragmentWebView;

public class NewsDetail extends AppCompatActivity {
    Context context;
    ImageView imageView;
    TextView title, description,date,link;
    String ur;
    Bundle data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_detail);

        imageView = (ImageView) findViewById(R.id.imageView);
        title = (TextView) findViewById(R.id.title);
        description = (TextView)findViewById(R.id.description);
        date = (TextView) findViewById(R.id.pubdate);
        link = (TextView) findViewById(R.id.link);
        Picasso.with(context).load(getIntent().getStringExtra("Image")).into(imageView);
        title.setText(getIntent().getStringExtra("Title"));
        description.setText(getIntent().getStringExtra("Description"));
        date.setText(getIntent().getStringExtra("Date"));
        link.setText(getIntent().getStringExtra("Link"));
        data = new Bundle();
        data.putString("currenturl", getIntent().getStringExtra("Link"));
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentWebView();
                fragment.setArguments(data);
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_news,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

}
