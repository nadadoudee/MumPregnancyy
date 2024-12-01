package com.example.mumpregnancy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;



public class babyname extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.babyname);

        // Références au champ EditText et au bouton
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        EditText editTextBabyName = findViewById(R.id.editTextBabyName);
        Button btnNewBaby = findViewById(R.id.button_nouveau_bebe);

        btnNewBaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer le nom saisi par l'utilisateur
                String babyName = editTextBabyName.getText().toString();

                // Vérifier si le nom n'est pas vide
                if (!babyName.isEmpty()) {
                    // Naviguer vers la page du profil et transmettre le nom
                    Intent intent = new Intent(babyname.this, babypage.class);
                    intent.putExtra("baby_name", babyName); // Ajouter le nom comme extra
                    startActivity(intent);
                } else {
                    // Afficher un message si le champ est vide (optionnel)
                    editTextBabyName.setError("Veuillez entrer un nom");
                }
            }
        });
    }
}
