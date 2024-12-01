package com.example.mumpregnancy;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class journal extends AppCompatActivity {

    private Button btnAddVideo, btnAddImage, btnRecordVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journal);

        // Initialisation des boutons
        btnAddVideo = findViewById(R.id.btnAddVideo);
        btnAddImage = findViewById(R.id.btnAddImage);
        btnRecordVoice = findViewById(R.id.btnRecordVoice);

        // Action pour ajouter une vidéo
        btnAddVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(journal.this, SaveVideoActivity.class);
                startActivity(intent);
            }
        });


        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(journal.this, image.class);
                startActivity(intent);
            }
        });


        btnRecordVoice.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
        Intent intent = new Intent(journal.this, VoiceActivity.class);
       startActivity(intent);
     }
       });
    }}
