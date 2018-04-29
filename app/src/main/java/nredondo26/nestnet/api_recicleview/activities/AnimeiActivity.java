package nredondo26.nestnet.api_recicleview.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Objects;

import nredondo26.nestnet.api_recicleview.R;

public class AnimeiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animei);
        Objects.requireNonNull(getSupportActionBar()).hide();


        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String estudio = getIntent().getExtras().getString("anime_estudio");
        String categori = getIntent().getExtras().getString("anime_categori");
        int nb_episode = getIntent().getExtras().getInt("anime_nb_episode");
        String rating = getIntent().getExtras().getString("nime_rating");
        String img_url = getIntent().getExtras().getString("anime_img");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtollbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_rowname);
        TextView tv_studio = findViewById(R.id.aa_studio);
        TextView tv_categorie = findViewById(R.id.aa_categorie);
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_rating = findViewById(R.id.aa_rating);
        ImageView tv_thumbnail = findViewById(R.id.aa_thumbnail);

        tv_name.setText(name);
        tv_categorie.setText(categori);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_studio.setText(estudio);

        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shapes).error(R.drawable.loading_shapes);

        Glide.with(this).load(img_url).apply(requestOptions).into(tv_thumbnail);

    }
}
