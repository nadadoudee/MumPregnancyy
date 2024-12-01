package com.example.mumpregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class sleepyy extends AppCompatActivity {

    private EditText startTimeEditText, endTimeEditText;
    private Button saveButton;
    private TextView totalSleepTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleepy); // Assurez-vous que le bon layout est utilisé

        // Initialisation des vues
        startTimeEditText = findViewById(R.id.start_time);
        endTimeEditText = findViewById(R.id.end_time);
        saveButton = findViewById(R.id.save_sleep_button);
        totalSleepTimeTextView = findViewById(R.id.total_sleep_time);

        // Ajout du listener pour le bouton d'enregistrement
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les heures de début et de fin
                String startTime = startTimeEditText.getText().toString();
                String endTime = endTimeEditText.getText().toString();

                // Vérifier si les deux heures sont saisies
                if (!startTime.isEmpty() && !endTime.isEmpty()) {
                    // Calculer la durée du sommeil
                    int sleepDuration = calculateSleepDuration(startTime, endTime);

                    // Afficher la durée du sommeil
                    totalSleepTimeTextView.setText("Durée totale du sommeil : " + sleepDuration + "h " + (sleepDuration % 60) + "m");
                } else {
                    // Afficher un message d'erreur si l'une des heures est vide
                    totalSleepTimeTextView.setText("Veuillez saisir les heures de début et de fin.");
                }
            }
        });
    }

    // Méthode pour calculer la durée du sommeil en minutes
    private int calculateSleepDuration(String startTime, String endTime) {
        try {
            // Conversion des heures et minutes en minutes totales
            String[] startParts = startTime.split(":");
            String[] endParts = endTime.split(":");

            int startHour = Integer.parseInt(startParts[0]);
            int startMinute = Integer.parseInt(startParts[1]);
            int endHour = Integer.parseInt(endParts[0]);
            int endMinute = Integer.parseInt(endParts[1]);

            // Convertir l'heure de début et de fin en minutes depuis minuit
            int startTotalMinutes = startHour * 60 + startMinute;
            int endTotalMinutes = endHour * 60 + endMinute;

            // Si l'heure de fin est avant l'heure de début (indiquant que le sommeil a traversé minuit), ajouter 24h à l'heure de fin
            if (endTotalMinutes < startTotalMinutes) {
                endTotalMinutes += 24 * 60;
            }

            // Calculer la durée du sommeil
            return endTotalMinutes - startTotalMinutes;
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // Retourner 0 en cas d'erreur dans le calcul
        }
    }
}
