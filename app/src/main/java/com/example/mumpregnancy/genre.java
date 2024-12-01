package com.example.mumpregnancy;
import android.annotation.SuppressLint;
import android.content.Intent; // N'oublie pas d'importer la classe Intent
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class genre extends AppCompatActivity {

    private ImageView boyImage;
    private ImageView girlImage;
    private Button nextButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.genre);

        boyImage = findViewById(R.id.boyImage);
        girlImage = findViewById(R.id.girlImage);
        nextButton = findViewById(R.id.nextButton);

        boyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Vous avez sélectionné Un garçon");
            }
        });

        girlImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Vous avez sélectionné Une fille");
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implémentez la navigation vers la page babypage
                Intent intent = new Intent(genre.this, babypage.class);
                startActivity(intent);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
