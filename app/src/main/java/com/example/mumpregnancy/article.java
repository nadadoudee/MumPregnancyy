package com.example.mumpregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class article extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);

        // Initialiser les boutons des articles
        Button article1Button = findViewById(R.id.article1);
        Button article2Button = findViewById(R.id.article2);
        Button article3Button = findViewById(R.id.article3);
        Button article4Button = findViewById(R.id.article4);

        // Action pour l'article 1
        article1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArticleDetail("Le rôle du stress dans la fertilité",
                        "Le stress est un facteur majeur qui peut affecter la fertilité en perturbant les hormones. "
                                + "En effet, le stress chronique peut entraîner une élévation des niveaux de cortisol, une hormone qui "
                                + "inhibe la production d'hormones sexuelles telles que la progestérone et l'estradiol. Cela peut perturber "
                                + "les cycles menstruels et rendre la conception plus difficile. Pour cette raison, il est conseillé aux couples "
                                + "de trouver des méthodes pour réduire leur stress, comme la pratique de la méditation, le yoga, ou simplement "
                                + "prendre des vacances pour se détendre. Il est aussi important de discuter avec un professionnel de santé pour "
                                + "apprendre à gérer efficacement le stress.");
            }
        });

        // Action pour l'article 2
        article2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArticleDetail("L'alimentation pour favoriser la conception",
                        "Une alimentation saine et équilibrée est cruciale pour la fertilité. Il est recommandé de consommer des "
                                + "aliments riches en nutriments essentiels tels que des vitamines, des minéraux, et des acides gras oméga-3. "
                                + "Les légumes, les fruits, les céréales complètes, et les poissons gras sont particulièrement bénéfiques pour "
                                + "favoriser la fertilité. Une alimentation riche en antioxydants peut aider à protéger les cellules reproductives "
                                + "des dommages causés par le stress oxydatif. Pour les femmes qui cherchent à concevoir, il est aussi important "
                                + "de maintenir un poids santé et d'éviter les régimes restrictifs qui pourraient nuire à la fertilité.");
            }
        });

        // Action pour l'article 3
        article3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArticleDetail("Le rôle de la vitamine C",
                        "La vitamine C joue un rôle clé dans la fertilité en tant qu'antioxydant. Elle aide à protéger les spermatozoïdes "
                                + "contre les dommages oxydatifs et améliore la qualité du sperme. La vitamine C soutient également la santé du "
                                + "système immunitaire, ce qui est important pour la conception. Chez les femmes, elle est essentielle pour la "
                                + "synthèse du collagène et la bonne santé des tissus reproductifs. Les sources riches en vitamine C incluent les "
                                + "agrumes, les poivrons, les fraises et les kiwis. En ajoutant ces aliments à votre alimentation, vous pouvez "
                                + "aider à améliorer vos chances de conception.");
            }
        });

        // Action pour l'article 4
        article4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArticleDetail("Gérer son poids pour améliorer la fertilité",
                        "Le poids corporel peut avoir un impact important sur la fertilité. Un poids idéal permet de réguler les niveaux "
                                + "d'hormones reproductives et de maintenir une bonne santé reproductive. L'excès de poids ou l'insuffisance pondérale "
                                + "peuvent perturber l'ovulation et rendre la conception plus difficile. Il est conseillé de maintenir un IMC (Indice "
                                + "de Masse Corporelle) normal, qui se situe généralement entre 18,5 et 24,9. Pour améliorer la fertilité, il est "
                                + "important d'adopter un mode de vie sain, de faire de l'exercice régulièrement et de suivre un régime alimentaire "
                                + "équilibré pour maintenir un poids corporel stable et sain.");
            }
        });
    }

    // Méthode pour ouvrir la page de détail de l'article
    private void openArticleDetail(String title, String description) {
        Intent intent = new Intent(article.this, ArticleDetailActivity.class);
        intent.putExtra("TITLE", title);
        intent.putExtra("DESCRIPTION", description);
        startActivity(intent);
    }
}
