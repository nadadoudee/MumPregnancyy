package com.example.mumpregnancy;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BabyHealthArticlesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baby_health); // Use your layout file name

        // Initialize buttons
        Button article1Button = findViewById(R.id.article1);
        Button article2Button = findViewById(R.id.article2);
        Button article3Button = findViewById(R.id.article3);
        Button article4Button = findViewById(R.id.article4);
        Button article5Button = findViewById(R.id.article5);

        // Set click listeners for each button
        article1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArticleDetail(1); // Pass the article number or ID
            }
        });

        article2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArticleDetail(2);
            }
        });

        article3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArticleDetail(3);
            }
        });

        article4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArticleDetail(4);
            }
        });

        article5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArticleDetail(5);
            }
        });
    }

    // This method will open a new activity for the article detail based on the passed article ID
    private void openArticleDetail(int articleId) {
        Intent intent = new Intent(BabyHealthArticlesActivity.this, ArticleDetailActivity.class);
        intent.putExtra("articleId", articleId); // Pass the article ID to the detail activity
        startActivity(intent);
    }
}

