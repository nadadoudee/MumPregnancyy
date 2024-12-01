package com.example.mumpregnancy;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ArticlesFragment extends Fragment {

    public ArticlesFragment() {
        // Constructeur nécessaire
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate le layout du fragment
        View rootView = inflater.inflate(R.layout.activity_article2, container, false);

        // Initialisation des boutons des articles
        Button article1 = rootView.findViewById(R.id.article1);
        Button article2 = rootView.findViewById(R.id.article2);
        Button article3 = rootView.findViewById(R.id.article3);
        Button article4 = rootView.findViewById(R.id.article4);

        // Ajoutez des écouteurs de clic pour chaque bouton d'article
        article1.setOnClickListener(v -> showArticleDetail("Les bases d'une alimentation équilibrée", "Contenu détaillé de l'article 1"));
        article2.setOnClickListener(v -> showArticleDetail("L'importance des vaccins", "Contenu détaillé de l'article 2"));
        article3.setOnClickListener(v -> showArticleDetail("Les routines de sommeil idéales", "Contenu détaillé de l'article 3"));
        article4.setOnClickListener(v -> showArticleDetail("Les signes de croissance saine", "Contenu détaillé de l'article 4"));

        return rootView;
    }

    // Méthode pour afficher les détails de l'article
    private void showArticleDetail(String title, String content) {
        // Créez un Fragment ou une activité pour afficher les détails de l'article
        // Exemple avec un Toast pour le moment
        Toast.makeText(getActivity(), "Titre: " + title + "\nContenu: " + content, Toast.LENGTH_LONG).show();
    }
}
