package com.example.mumpregnancy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    private EditText noteInput;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        noteInput = findViewById(R.id.noteInput);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = noteInput.getText().toString().trim();
                if (!note.isEmpty()) {
                    Toast.makeText(AddNoteActivity.this, "Note enregistrée : " + note, Toast.LENGTH_SHORT).show();
                    finish(); // Ferme l'activité après l'enregistrement
                } else {
                    Toast.makeText(AddNoteActivity.this, "Veuillez entrer une note d'humeur.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
