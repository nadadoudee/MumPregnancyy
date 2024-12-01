package com.example.mumpregnancy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class item3 extends AppCompatActivity {

    // Déclaration du BottomNavigationView
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item3);

        // Initialisation du BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Configuration du BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment selectedFragment = null;

                // Gérer l'action lorsque l'élément du menu est sélectionné avec if-else
                if (item.getItemId() == R.id.profile) {  // Vérifiez que l'ID "profile" est bien défini dans votre fichier menu.xml
                    // Remplacer par le fragment Profil
                    selectedFragment = new ProfileFragment();
                } else if (item.getItemId() == R.id.journal) {  // Vérifiez que l'ID "journal" est bien défini dans votre fichier menu.xml
                    // Remplacer par le fragment Journal
                    selectedFragment = new JournalFragment();
                } else if (item.getItemId() == R.id.emoji) {  // Vérifiez que l'ID "emoji" est bien défini dans votre fichier menu.xml
                    // Remplacer par le fragment Humeur
                    selectedFragment = new HumeurFragment();
                } else if (item.getItemId() == R.id.articlee) {  // Vérifiez que l'ID "articlee" est bien défini dans votre fichier menu.xml
                    // Remplacer par le fragment Articles
                    selectedFragment = new ArticlesFragment();
                }

                // Remplacer le fragment actuel par le fragment sélectionné
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)  // Assurez-vous que le conteneur existe dans le XML
                            .commit();
                }
                return true;
            }
        });

        // Charger un fragment par défaut si nécessaire (par exemple ProfilFragment)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ProfileFragment())  // Fragment de démarrage
                    .commit();
        }
    }
}
