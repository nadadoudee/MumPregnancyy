package com.example.mumpregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mumpregnancy.BabyHealthArticlesActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;

public class babypage extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView textViewHello;  // Référence pour le TextView "Hello"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item2);  // Assurez-vous d'utiliser le bon layout

        // Initialisation de la BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Référencer le TextView pour "Hello"
        textViewHello = findViewById(R.id.textViewHello);

        // Récupérer le nom du bébé passé dans l'Intent
        String babyName = getIntent().getStringExtra("baby_name");

        // Afficher "Hello" suivi du nom du bébé
        if (babyName != null && !babyName.isEmpty()) {
            textViewHello.setText("Hello " + babyName + "!");
        } else {
            textViewHello.setText("Hello!");
        }

        // Gérer les éléments du BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.profile) {
                // Si vous ne voulez rien faire ici, ne rien mettre
                return true;
            } else if (item.getItemId() == R.id.articlee) {
                openAnotherActivity();
                return true;
            } else if (item.getItemId() == R.id.moon) {
                openSleepTrackerActivity();
                return true;
            } else if (item.getItemId() == R.id.journal) {
                openNoteActivity();
                return true;
            }
            return false;
        });
    }

    // Méthode pour ouvrir l'activité SleepTrackerActivity
    private void openSleepTrackerActivity() {
        Intent intent = new Intent(babypage.this, sleepyy.class);
        startActivity(intent);
    }

    // Méthode pour ouvrir une autre activité (par exemple BabyHealthArticlesActivity)
    private void openAnotherActivity() {
        Intent intent = new Intent(babypage.this, BabyHealthArticlesActivity.class);
        startActivity(intent);
    }

    // Méthode pour ouvrir l'activité NoteActivity
    private void openNoteActivity() {
        Intent intent = new Intent(babypage.this, NoteActivity.class);
        startActivity(intent);
    }
}
