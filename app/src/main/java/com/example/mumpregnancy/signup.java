package com.example.mumpregnancy;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    private EditText usernameEditText, emailEditText, passwordEditText;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);  // Assure-toi que le nom du fichier XML est correct

        // Initialiser les éléments de l'interface utilisateur
        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        signupButton = findViewById(R.id.signupButton);

        // Mettre en place le listener de clic pour le bouton "Sign Up"
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validation de base
                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(signup.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    // Validation de l'email
                    Toast.makeText(signup.this, "Email invalide", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    // Validation du mot de passe (longueur minimale)
                    Toast.makeText(signup.this, "Le mot de passe doit contenir au moins 6 caractères", Toast.LENGTH_SHORT).show();
                } else {
                    // Ici, tu peux envoyer ces données à ton serveur ou base de données
                    // Pour la démonstration, on affiche simplement un message de succès
                    Toast.makeText(signup.this, "Inscription réussie!", Toast.LENGTH_SHORT).show();

                    // Optionnellement, on peut vider les champs après l'inscription réussie
                    usernameEditText.setText("");
                    emailEditText.setText("");
                    passwordEditText.setText("");
                }
            }
        });
    }
}
