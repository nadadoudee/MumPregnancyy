package com.example.mumpregnancy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class image extends AppCompatActivity {

    private static final int IMAGE_PICKER_REQUEST = 1; // Code pour identifier la requête de la galerie
    private static final int STORAGE_PERMISSION_REQUEST = 2; // Code pour la demande de permission
    private Button btnAddImage, btnSaveImage; // Boutons pour ajouter et enregistrer une image
    private ImageView imageView; // Composant pour afficher l'image
    private Uri selectedImageUri; // URI de l'image sélectionnée

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image); // Charge la mise en page définie dans image.xml

        // Initialisation des composants
        btnAddImage = findViewById(R.id.btnAddImage);
        btnSaveImage = findViewById(R.id.btnSaveImage);
        imageView = findViewById(R.id.imageView); // Correction ici pour utiliser un ImageView

        // Vérification des permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_REQUEST);
        }

        // Ouvrir la galerie pour sélectionner une image
        btnAddImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, IMAGE_PICKER_REQUEST);
        });

        // Enregistrer l'image dans le stockage interne
        btnSaveImage.setOnClickListener(v -> {
            if (selectedImageUri != null) {
                saveImageToAppStorage(selectedImageUri); // Fonction pour enregistrer l'image
            } else {
                Toast.makeText(this, "Aucune image à enregistrer.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Mise à jour de la méthode onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_PICKER_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData(); // URI de l'image sélectionnée
            Log.d("imageURI", "URI de l'image : " + selectedImageUri); // Ajouter un log pour vérifier l'URI

            if (selectedImageUri != null) {
                imageView.setImageURI(selectedImageUri); // Charger l'URI dans l'ImageView
                Toast.makeText(this, "Image chargée avec succès !", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Aucune image sélectionnée.", Toast.LENGTH_SHORT).show();
        }
    }

    // Fonction pour enregistrer l'image dans le stockage interne
    private void saveImageToAppStorage(Uri imageUri) {
        try {
            // Récupérer le flux d'entrée de l'image
            InputStream inputStream = getContentResolver().openInputStream(imageUri);

            // Créer un répertoire "images" dans le stockage interne de l'application
            File appDir = new File(getFilesDir(), "images");
            if (!appDir.exists()) {
                appDir.mkdir(); // Créer le répertoire s'il n'existe pas
            }

            // Créer un fichier avec un nom unique
            File imageFile = new File(appDir, "image_" + System.currentTimeMillis() + ".jpg");
            FileOutputStream outputStream = new FileOutputStream(imageFile);

            // Copier les données du flux d'entrée vers le fichier de sortie
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            // Fermer les flux
            inputStream.close();
            outputStream.close();

            Toast.makeText(this, "Image enregistrée avec succès !", Toast.LENGTH_LONG).show();
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
