package com.celebrateclub.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.celebrateclub.R;

public class MeuPerfilActivity extends AppCompatActivity {

    private TextView editarDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_perfil);

        editarDados = findViewById(R.id.tvEditarDados);

        editarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MeuPerfilActivity.this, EditarDadosActivity.class));
            }
        });
    }
}
