package com.example.mumpregnancy;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomepage); // Assurez-vous que le nom du fichier XML est correct

        // Initialisation du bouton
        Button btn = findViewById(R.id.btn);

        // Définir l'action lors du clic sur le bouton
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbtn();
            }
        });
    }

    // Méthode qui s'active lors du clic sur le bouton
    public void openbtn() {
        // Par exemple, ouvrir une autre activité
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

