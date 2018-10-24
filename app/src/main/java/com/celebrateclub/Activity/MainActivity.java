package com.celebrateclub.Activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.celebrateclub.R;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

public class MainActivity extends AppCompatActivity {

    private EditText editCPF, editPassword;
    private TextView tvNovaConta;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCPF = findViewById(R.id.editCPF);
        editPassword = findViewById(R.id.editPassword);
        tvNovaConta = findViewById(R.id.tvNovaConta);
        btnEntrar = findViewById(R.id.btnEntrar);

        tvNovaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NovaContaActivity.class));
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });

        MaskEditTextChangedListener maskCPF = new MaskEditTextChangedListener("###.###.###-##", editCPF);
        editCPF.addTextChangedListener(maskCPF);


        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
    }
}
