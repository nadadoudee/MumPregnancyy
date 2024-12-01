package com.example.mumpregnancy;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class VoiceActivity extends AppCompatActivity {

    private Button btnRecordVoice, btnStopRecording, btnSaveVoice;
    private MediaRecorder mediaRecorder;
    private String fileName;
    private boolean isRecording = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocal); // Assurez-vous que vous utilisez le bon fichier XML

        // Initialisation des boutons
        btnRecordVoice = findViewById(R.id.btnRecordVoice);
        btnStopRecording = findViewById(R.id.btnStopRecording);
        btnSaveVoice = findViewById(R.id.btnSaveVoice);

        // Nom du fichier d'enregistrement
        fileName = getExternalCacheDir().getAbsolutePath() + "/recording.3gp";

        // Vérification des permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        // Au clic sur le bouton d'enregistrement
        btnRecordVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecording();
            }
        });

        // Au clic sur le bouton pour arrêter l'enregistrement
        btnStopRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRecording();
            }
        });

        // Au clic sur le bouton pour sauvegarder le message vocal
        btnSaveVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implémentez la logique de sauvegarde ici
                Toast.makeText(VoiceActivity.this, "Message vocal sauvegardé.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Démarrer l'enregistrement
    private void startRecording() {
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.setOutputFile(fileName);

        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
            isRecording = true;

            // Mise à jour de l'interface utilisateur
            btnRecordVoice.setEnabled(false);
            btnStopRecording.setEnabled(true);
            btnSaveVoice.setEnabled(false);

            Toast.makeText(this, "Enregistrement démarré.", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(this, "Erreur lors du démarrage de l'enregistrement.", Toast.LENGTH_SHORT).show();
        }
    }

    // Arrêter l'enregistrement
    private void stopRecording() {
        if (isRecording) {
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;

            isRecording = false;

            // Mise à jour de l'interface utilisateur
            btnRecordVoice.setEnabled(true);
            btnStopRecording.setEnabled(false);
            btnSaveVoice.setEnabled(true);

            Toast.makeText(this, "Enregistrement terminé.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permissions accordées.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Les permissions sont nécessaires pour enregistrer un audio.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
