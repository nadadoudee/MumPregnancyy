package com.example.mumpregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Heumeur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heumeur);

        // Initialisation du bouton principal
        Button btn = findViewById(R.id.btn);

        // Écouteur pour le bouton principal
        btn.setOnClickListener(v ->
                        // Rediriger vers l'activité AddNoteActivity lorsqu'on clique sur le bouton
                {
                    Intent intent = new Intent(Heumeur.this, AddNoteActivity.class);
                    startActivity(intent);
                }
        );
    }

    // Méthode pour gérer le clic sur les boutons d'émotion
    public void onEmojiClick(View view) {
        // Récupérer l'émotion via le tag
        String emotion = view.getTag().toString();

        // Messages selon l'émotion
        String messageMotivation;
        switch (emotion) {
            case "heureux":
                messageMotivation = "يا عيشك يا ماما، فرحتك فرحتني 💖.";
                break;
            case "triste":
                messageMotivation = "يا ماما، ما تحزنيش، كل شيء بش يعدي ❤️.";
                break;
            case "affame":
                messageMotivation = "ماما، خذي راحتك و كلّي ما تحبّي! 🍽❤️";
                break;
            case "fatiguee":
                messageMotivation = "ماما، رتّاحي شوية و خليك دايمًا بصحة و خير 🌸.";
                break;
            default:
                messageMotivation = "Ommi, peu importe ton humeur, ena dima m3ak ❤️.";
        }

        // Boîte de dialogue avec le message motivant
        new AlertDialog.Builder(this)
                .setTitle("Message de Motivation")
                .setMessage(messageMotivation)
                .setPositiveButton("D'accord", null)
                .show();
    }
}
