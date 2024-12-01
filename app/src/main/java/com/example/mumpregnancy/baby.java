package com.example.mumpregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class baby extends AppCompatActivity {

    private Button selectedButton = null; // Variable pour stocker le bouton sélectionné

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baby);
        // Initialisation des boutons
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button submitButton = findViewById(R.id.button_submit); // Bouton Submit ajouté dans XML

        // Ajout des écouteurs pour chaque bouton
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Réinitialiser le style des autres boutons
                resetButtonStyles();

                // Définir le bouton sélectionné
                selectedButton = (Button) v;
                selectedButton.setBackgroundColor(getResources().getColor(R.color.piink)); // Couleur de sélection
            }
        };

        // Associer les écouteurs
        button1.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);
        button3.setOnClickListener(buttonClickListener);
        button4.setOnClickListener(buttonClickListener);
        button5.setOnClickListener(buttonClickListener);

        // Gestion du clic sur le bouton Submit
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedButton != null) {
                    // Naviguer vers la nouvelle activité
                    Intent intent = new Intent(baby.this, babyname.class);
                    startActivity(intent);
                } else {
                    // Afficher un message si aucun bouton n'est sélectionné
                    Toast.makeText(baby.this, "Veuillez sélectionner une option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Réinitialiser le style des boutons
    private void resetButtonStyles() {
        if (selectedButton != null) {
            selectedButton.setBackgroundColor(getResources().getColor(R.color.white)); // Couleur par défaut
        }
    }
}
