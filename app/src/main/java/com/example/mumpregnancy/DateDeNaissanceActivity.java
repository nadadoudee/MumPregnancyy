package com.example.mumpregnancy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // N'oubliez pas d'importer Log
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class DateDeNaissanceActivity extends AppCompatActivity {

    private EditText editTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datenais);

        editTextDate = findViewById(R.id.editTextDate);

        // Configurez l'écouteur pour afficher le sélecteur de date
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // Initialisation du bouton "Suivant"
        Button btnSuivant = findViewById(R.id.btnSuivant);

        // Ajoutez l'écouteur de clic pour le bouton "Suivant"
        btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifiez si une date a été sélectionnée
                if (editTextDate.getText().toString().isEmpty()) {
                    // Affiche un message d'erreur si la date n'est pas sélectionnée
                    Toast.makeText(DateDeNaissanceActivity.this, "Veuillez sélectionner une date.", Toast.LENGTH_SHORT).show();
                } else {
                    // Debug log
                    Log.d("DateDeNaissanceActivity", "Navigating to GenreActivity");
                    // Naviguer vers GenreActivity
                    Intent intent = new Intent(DateDeNaissanceActivity.this, genre.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void showDatePickerDialog() {
        // Obtenez la date actuelle
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Créez et affichez le sélecteur de date
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    // Définit la date sélectionnée dans l'EditText
                    String selectedDate = dayOfMonth + " " + getMonthName(monthOfYear) + " " + year1;
                    editTextDate.setText(selectedDate);
                },
                year, month, day);
        datePickerDialog.show();
    }

    // Fonction auxiliaire pour obtenir le nom du mois à partir de l'index du mois
    private String getMonthName(int monthIndex) {
        String[] monthNames = {
                "janvier", "février", "mars", "avril", "mai", "juin",
                "juillet", "août", "septembre", "octobre", "novembre", "décembre"
        };
        return monthNames[monthIndex];
    }
}