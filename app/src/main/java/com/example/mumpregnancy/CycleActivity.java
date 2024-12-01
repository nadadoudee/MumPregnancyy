package com.example.mumpregnancy;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class CycleActivity extends AppCompatActivity {

    private TextView currentDayText, nextPeriodText;
    private EditText cycleLengthInput;
    private Calendar startDate = Calendar.getInstance();
    private ProgressBar cycleProgressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planningbaby);

        // Initialisation des vues
        currentDayText = findViewById(R.id.currentDayText);
        nextPeriodText = findViewById(R.id.nextPeriodText);
        cycleLengthInput = findViewById(R.id.cycleLengthInput);
        cycleProgressBar = findViewById(R.id.cycleProgressBar);
        Button selectDateButton = findViewById(R.id.selectDateButton);
        Button openArticleButton = findViewById(R.id.openArticleButton);  // Bouton pour ouvrir l'activité article

        // Gestion du bouton de sélection de date
        selectDateButton.setOnClickListener(v -> showDatePickerDialog());

        // Lien avec le bouton d'ouverture de l'article
        openArticleButton.setOnClickListener(v -> openArticle());
    }

    // Affichage du sélecteur de date
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            startDate.set(year, month, dayOfMonth);
            Log.d("CycleActivity", "Date sélectionnée: " + year + "-" + (month + 1) + "-" + dayOfMonth);
            updateCycleInfo();  // Mise à jour des infos après sélection de la date
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    // Mise à jour des informations du cycle
    private void updateCycleInfo() {
        String cycleLengthString = cycleLengthInput.getText().toString();

        // Vérification si la durée du cycle est valide
        if (cycleLengthString.isEmpty() || !cycleLengthString.matches("\\d+")) {
            Toast.makeText(this, "Veuillez entrer une durée de cycle valide", Toast.LENGTH_SHORT).show();
            return;
        }

        int cycleLength = Integer.parseInt(cycleLengthString);
        Calendar today = Calendar.getInstance();
        long diffInMillis = today.getTimeInMillis() - startDate.getTimeInMillis();
        int daysPassed = (int) TimeUnit.MILLISECONDS.toDays(diffInMillis) + 1;

        Log.d("CycleActivity", "Jours écoulés depuis la date de début: " + daysPassed);

        // Calculer le nombre de jours restant jusqu'à la prochaine période
        int daysUntilNextPeriod = cycleLength - (daysPassed % cycleLength);

        // Calculer le jour actuel dans le cycle
        int currentDayInCycle = daysPassed % cycleLength;

        // Mettre à jour la ProgressBar
        cycleProgressBar.setMax(cycleLength);
        cycleProgressBar.setProgress(currentDayInCycle);

        // Mettre à jour le texte dans le cercle
        ThreeColorCircleView circleView = findViewById(R.id.threeColorCircle);
        if (circleView != null) {
            circleView.setCenterText("Jour actuel : " + currentDayInCycle);
            circleView.setNextPeriodText("Prochaine période dans : " + daysUntilNextPeriod + " jours");
        } else {
            Log.e("CycleActivity", "La vue du cercle est nulle !");
        }

        // Mettre à jour les TextViews
        currentDayText.setText("Jour actuel : " + currentDayInCycle);
        nextPeriodText.setText("Prochaine période dans : " + daysUntilNextPeriod + " jours");
    }

    // Méthode pour ouvrir l'activité des articles
    private void openArticle() {
        Intent intent = new Intent(CycleActivity.this, article.class);  // Assurez-vous que l'activité article est correctement déclarée
        startActivity(intent);
    }
}
