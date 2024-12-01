package com.example.mumpregnancy;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NoteActivity extends AppCompatActivity {

    EditText noteTitle, noteContent;
    Button saveNoteButton;
    LinearLayout stickyNotesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);  // Assurez-vous que le bon layout est utilisé

        noteTitle = findViewById(R.id.noteTitle);
        noteContent = findViewById(R.id.noteContent);
        saveNoteButton = findViewById(R.id.saveNoteButton);
        stickyNotesContainer = findViewById(R.id.stickyNotesContainer);

        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer le titre et le contenu de la note
                String title = noteTitle.getText().toString();
                String content = noteContent.getText().toString();

                if (title.isEmpty() || content.isEmpty()) {
                    Toast.makeText(NoteActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    // Créer une nouvelle Sticky Note carrée
                    createStickyNoteSquare(title, content);

                    // Réinitialiser les champs
                    noteTitle.setText("");
                    noteContent.setText("");
                }
            }
        });
    }

    // Méthode pour créer une sticky note carrée
    private void createStickyNoteSquare(String title, String content) {
        // Créer un TextView pour afficher la sticky note carrée
        TextView stickyNote = new TextView(this);
        stickyNote.setText("Titre: " + title + "\n" + "Contenu: " + content);
        stickyNote.setPadding(30, 30, 30, 30);  // Ajouter un padding pour espacer le texte
        stickyNote.setTextColor(getResources().getColor(android.R.color.white));
        stickyNote.setTextSize(16);

        // Définir la largeur et la hauteur pour rendre la note carrée
        int widthHeight = 400; // Par exemple, une taille de 400x400 pixels pour la note carrée
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthHeight, widthHeight);
        stickyNote.setLayoutParams(layoutParams);

        // Personnaliser l'apparence de la note (carrée, fond coloré, etc.)
        stickyNote.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light)); // Couleur de fond
        stickyNote.setGravity(Gravity.CENTER); // Centrer le texte dans la note

        // Ajouter la sticky note au conteneur
        stickyNotesContainer.addView(stickyNote);
    }
}
