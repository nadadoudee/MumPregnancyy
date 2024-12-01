package com.example.mumpregnancy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ThreeColorCircleView extends View {

    // Attributs pour dessiner le cercle
    private Paint paintRed;
    private Paint paintBlue;
    private Paint paintOrange;
    private Paint textPaint;

    // Texte dynamique à afficher au centre du cercle
    private String centerText = ""; // Commencer avec une chaîne vide

    // Indicateurs pour les phases du cycle
    private int ovulationDay;
    private int fertilizationWindowStart;
    private int fertilizationWindowEnd;
    private int currentDay;

    public ThreeColorCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // Initialiser les peintures pour les arcs
        paintRed = new Paint();
        paintRed.setColor(0xFFFF6347); // Rouge (Tomato)
        paintRed.setStyle(Paint.Style.STROKE);
        paintRed.setStrokeWidth(50);

        paintBlue = new Paint();
        paintBlue.setColor(0xFF4682B4); // Bleu (SteelBlue)
        paintBlue.setStyle(Paint.Style.STROKE);
        paintBlue.setStrokeWidth(50);

        paintOrange = new Paint();
        paintOrange.setColor(0xFFFFA500); // Orange
        paintOrange.setStyle(Paint.Style.STROKE);
        paintOrange.setStrokeWidth(50);

        // Initialiser la peinture pour le texte
        textPaint = new Paint();
        textPaint.setColor(0xFFFFFFFF); // Blanc
        textPaint.setTextSize(50); // Taille du texte
        textPaint.setTextAlign(Paint.Align.CENTER); // Centrer le texte
    }

    // Méthode pour définir le texte central dynamiquement
    public void setCenterText(String text) {
        this.centerText = text; // Mettre à jour le texte
        invalidate(); // Redessiner la vue
    }

    // Méthode pour définir les informations sur les phases du cycle
    public void setCyclePhaseInfo(int ovulationDay, int fertilizationWindowStart, int fertilizationWindowEnd, int currentDay) {
        this.ovulationDay = ovulationDay;
        this.fertilizationWindowStart = fertilizationWindowStart;
        this.fertilizationWindowEnd = fertilizationWindowEnd;
        this.currentDay = currentDay;
        invalidate(); // Redessiner la vue avec les nouvelles informations
    }

    // Méthode pour mettre à jour le texte de la prochaine période
    public void setNextPeriodText(String text) {
        this.centerText = text;  // Mettre à jour le texte pour la prochaine période
        invalidate(); // Redessiner la vue avec le nouveau texte
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Obtenir le centre et le rayon du cercle
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2 - 30; // Réduire pour éviter la coupure

        int cx = width / 2;
        int cy = height / 2;

        // Dessiner les arcs pour chaque section (en degrés)
        float startAngle = 0;
        float sweepAngle = 120; // Chaque couleur couvre 120°

        // Dessiner la première section (Rouge) : Phase menstruelle
        canvas.drawArc(cx - radius, cy - radius, cx + radius, cy + radius, startAngle, sweepAngle, false, paintRed);

        // Dessiner la période de fertilité (Orange) : Fenêtre de fertilisation
        if (currentDay >= fertilizationWindowStart && currentDay <= fertilizationWindowEnd) {
            startAngle += sweepAngle; // Décaler pour la fenêtre de fécondation
            canvas.drawArc(cx - radius, cy - radius, cx + radius, cy + radius, startAngle, sweepAngle, false, paintOrange);
        }

        // Dessiner la période d'ovulation (Bleu)zz
        if (currentDay == ovulationDay) {
            startAngle += sweepAngle; // Décaler pour la période d'ovulation
            canvas.drawArc(cx - radius, cy - radius, cx + radius, cy + radius, startAngle, sweepAngle, false, paintBlue);
        }

        // Dessiner le texte dynamique au centre
        canvas.drawText(centerText, cx, cy, textPaint);

        // Ajouter le log pour afficher les valeurs
        Log.d("ThreeColorCircleView", "Current Day: " + currentDay + ", Ovulation Day: " + ovulationDay +
                ", Fertilization Start: " + fertilizationWindowStart + ", Fertilization End: " + fertilizationWindowEnd);
    }
}
