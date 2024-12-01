package com.example.mumpregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail); // Layout pour afficher les détails d'un article

        // Récupérer l'ID de l'article à partir de l'Intent
        Intent intent = getIntent();
        int articleId = intent.getIntExtra("articleId", 0);

        // Définir les TextViews pour le titre et le contenu de l'article
        TextView articleTitleTextView = findViewById(R.id.article_title);
        TextView articleContentTextView = findViewById(R.id.article_paragraph);

        // Afficher le contenu de l'article en fonction de l'ID
        switch (articleId) {
            case 1:
                articleTitleTextView.setText("L'alimentation idéale pour votre bébé");
                articleContentTextView.setText(
                        "L'alimentation de votre bébé est un aspect crucial de son développement. Dès la naissance, le lait maternel ou le lait infantile est essentiel pour fournir les nutriments nécessaires. \n\n" +
                                "À partir de six mois, les aliments solides peuvent être introduits, comme les purées de légumes, de fruits, et les céréales adaptées aux nourrissons. Les protéines, telles que le poisson et le poulet, doivent être ajoutées progressivement. \n\n" +
                                "Évitez les aliments riches en sel ou en sucre, qui pourraient nuire à la santé de votre bébé. Une alimentation équilibrée favorise une croissance optimale et un développement sain."
                );
                break;
            case 2:
                articleTitleTextView.setText("La vaccination de votre bébé : Ce qu'il faut savoir");
                articleContentTextView.setText(
                        "La vaccination est essentielle pour protéger votre bébé contre des maladies graves comme la tuberculose, l'hépatite B, ou encore la polio. \n\n" +
                                "Dès la naissance, un calendrier vaccinal adapté est suivi par les professionnels de santé. Respecter ce calendrier est crucial pour garantir une immunité efficace et durable. \n\n" +
                                "En cas de doute ou d'inquiétude, n'hésitez pas à consulter votre pédiatre pour mieux comprendre les bienfaits et le fonctionnement des vaccins administrés à votre enfant."
                );
                break;
            case 3:
                articleTitleTextView.setText("Les soins de la peau de bébé : Conseils pratiques");
                articleContentTextView.setText(
                        "La peau de votre bébé est délicate et nécessite une attention particulière pour éviter les irritations et les infections. \n\n" +
                                "Voici quelques conseils : \n" +
                                "- Utilisez des produits doux et hypoallergéniques spécialement conçus pour les bébés.\n" +
                                "- Changez régulièrement les couches pour prévenir les éruptions cutanées.\n" +
                                "- Optez pour des bains tièdes et appliquez une crème hydratante adaptée après chaque bain.\n\n" +
                                "En prenant soin de la peau de votre bébé, vous contribuez à son confort et à sa santé."
                );
                break;
            case 4:
                articleTitleTextView.setText("Les meilleurs conseils pour un sommeil sain chez bébé");
                articleContentTextView.setText(
                        "Un sommeil réparateur est essentiel pour le développement de votre bébé. Les nouveau-nés dorment généralement entre 16 et 18 heures par jour. \n\n" +
                                "Pour garantir un bon sommeil : \n" +
                                "- Créez une routine de coucher apaisante et régulière.\n" +
                                "- Assurez-vous que la chambre est calme, sombre et bien ventilée.\n" +
                                "- Évitez de coucher votre bébé s’il est trop fatigué ou agité.\n" +
                                "- Utilisez une literie sécurisée, adaptée à son âge.\n\n" +
                                "Un bon sommeil contribue à la santé physique et mentale de votre enfant."
                );
                break;
            default:
                articleTitleTextView.setText("Article non trouvé");
                articleContentTextView.setText("Désolé, cet article n'existe pas.");
                break;
        }
    }
}
