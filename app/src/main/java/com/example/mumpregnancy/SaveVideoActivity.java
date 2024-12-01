package com.example.mumpregnancy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class SaveVideoActivity extends AppCompatActivity {

    private static final int VIDEO_PICKER_REQUEST = 1; // Code pour identifier la requête de la galerie
    private static final int STORAGE_PERMISSION_REQUEST = 2; // Code pour la demande de permission
    private Button btnAddVideo, btnSaveVideo; // Boutons pour ajouter et enregistrer une vidéo
    private VideoView videoView; // Composant pour afficher et lire la vidéo
    private Uri selectedVideoUri; // URI de la vidéo sélectionnée

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video); // Charge la mise en page définie dans video.xml

        // Initialisation des composants
        btnAddVideo = findViewById(R.id.btnAddVideo);
        btnSaveVideo = findViewById(R.id.btnSaveVideo);
        videoView = findViewById(R.id.videoView);

        // Vérification des permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_REQUEST);
        }

        // Ouvrir la galerie pour sélectionner une vidéo
        btnAddVideo.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, VIDEO_PICKER_REQUEST);
        });

        // Enregistrer la vidéo dans le stockage interne
        btnSaveVideo.setOnClickListener(v -> {
            if (selectedVideoUri != null) {
                saveVideoToAppStorage(selectedVideoUri); // Fonction pour enregistrer la vidéo
            } else {
                Toast.makeText(this, "Aucune vidéo à enregistrer.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Mise à jour de la méthode onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VIDEO_PICKER_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedVideoUri = data.getData(); // URI de la vidéo sélectionnée
            Log.d("VideoURI", "URI de la vidéo : " + selectedVideoUri); // Ajouter un log pour vérifier l'URI

            if (selectedVideoUri != null) {
                videoView.setVideoURI(selectedVideoUri); // Charger l'URI dans le VideoView
                videoView.start(); // Démarrer la lecture
                Toast.makeText(this, "Vidéo chargée avec succès !", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Aucune vidéo sélectionnée.", Toast.LENGTH_SHORT).show();
        }
    }

    // Fonction pour enregistrer la vidéo dans le stockage interne
    private void saveVideoToAppStorage(Uri videoUri) {
        try {
            // Récupérer le flux d'entrée de la vidéo
            InputStream inputStream = getContentResolver().openInputStream(videoUri);

            // Créer un répertoire "videos" dans le stockage interne de l'application
            File appDir = new File(getFilesDir(), "videos");
            if (!appDir.exists()) {
                appDir.mkdir(); // Créer le répertoire s'il n'existe pas
            }

            // Créer un fichier avec un nom unique
            File videoFile = new File(appDir, "video_" + System.currentTimeMillis() + ".mp4");
            FileOutputStream outputStream = new FileOutputStream(videoFile);

            // Copier les données du flux d'entrée vers le fichier de sortie
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            // Fermer les flux
            inputStream.close();
            outputStream.close();

            Toast.makeText(this, "Vidéo enregistrée avec succès !", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Erreur lors de l'enregistrement : " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    // Gérer la réponse de la demande de permission
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission accordée", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission refusée. L'application ne peut pas accéder à la galerie.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}