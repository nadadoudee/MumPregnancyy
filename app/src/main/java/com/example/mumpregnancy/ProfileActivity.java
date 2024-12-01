package com.example.mumpregnancy;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mumpregnancy.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        // Référencer le TextView
        TextView textViewHello = findViewById(R.id.textViewHello);

        // Récupérer le nom depuis l'Intent
        String babyName = getIntent().getStringExtra("baby_name");

        // Vérifier si le nom est non nul et l'afficher
        if (babyName != null && !babyName.isEmpty()) {
            textViewHello.setText("Hello " + babyName + "!");
        } else {
            textViewHello.setText("Hello!");
        }
    }
}
