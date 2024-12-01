package com.example.mumpregnancy;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class lifeStage extends AppCompatActivity {

    private Button iHaveBabyButton;
    private Button alreadyPregnantButton;
    private Button planningPregnancyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifestage);

        // Initialisation des boutons
        iHaveBabyButton = findViewById(R.id.iHaveBabyButton);
        alreadyPregnantButton = findViewById(R.id.alreadyPregnantButton);
        planningPregnancyButton = findViewById(R.id.planningPregnancyButton);

        // Gérer les clics des boutons
        iHaveBabyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers une activité spécifique (à remplacer par votre activité)
                Intent intent = new Intent(lifeStage.this, baby.class);
                startActivity(intent);
            }
        });

        alreadyPregnantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers une activité spécifique (à remplacer par votre activité)
                Intent intent = new Intent(lifeStage.this, journal.class);
                startActivity(intent);
            }
        });

        planningPregnancyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers une activité spécifique (à remplacer par votre activité)
                Intent intent = new Intent(lifeStage.this, CycleActivity.class);
                startActivity(intent);
            }
        });
    }
}
