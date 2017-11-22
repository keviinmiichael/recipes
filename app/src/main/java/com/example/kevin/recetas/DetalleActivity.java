package com.example.kevin.recetas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    public static final String RECETA_KEY = "receta_key";
    private ImageView imageView;
    private TextView title;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Bundle bundle = getIntent().getExtras();
        Receta receta = (Receta) bundle.getSerializable(RECETA_KEY);
        imageView = (ImageView) findViewById(R.id.img_detalle);
        title = (TextView) findViewById(R.id.title_detalle);
        description = (TextView) findViewById(R.id.description_detalle);

        imageView.setImageResource(receta.getImg());
        title.setText(receta.getTitle().toString());
        description.setText(receta.getTodo().toString());

    }
}
