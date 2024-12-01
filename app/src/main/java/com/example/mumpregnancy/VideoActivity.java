package com.example.mumpregnancy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    private static final int VIDEO_PICKER_REQUEST = 1;
    private Button btnaddVideo; // Déclaration correcte du bouton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video); // Assurez-vous que le layout "video.xml" est bien celui que vous utilisez

        // Initialisation du bouton
        btnaddVideo = findViewById(R.id.btnAddVideo);

        // Ouvrir la galerie pour choisir une vidéo
        btnaddVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, VIDEO_PICKER_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VIDEO_PICKER_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri videoUri = data.getData(); // Récupérer l'URI de la vidéo sélectionnée
            // Traitement de la vidéo choisie, vous pouvez par exemple la lire ou l'afficher
        }
    }
}
