package com.celebrateclub.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.celebrateclub.R;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

import static android.app.PendingIntent.FLAG_ONE_SHOT;
import static maes.tech.intentanim.CustomIntent.customType;

public class NovaContaActivity2 extends AppCompatActivity {

    private Button btnAvancar;
    private EditText editNome, editSobreNome, editCelular;
    private String sNome, sSobrenome, sCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta2);

        btnAvancar = findViewById(R.id.btnAvancar);
        editNome = findViewById(R.id.editNome);
        editSobreNome = findViewById(R.id.editSobrenome);
        editCelular = findViewById(R.id.editCelular);

        Intent intent = getIntent();
        final String sCPF = intent.getStringExtra("cpf");
        final String sPassword = intent.getStringExtra("senha");


        MaskEditTextChangedListener maskCelular = new MaskEditTextChangedListener("(##)#####-####", editCelular);
        editCelular.addTextChangedListener(maskCelular);


        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

                    if (editNome.getText().toString().isEmpty()) {
                        com.onurkaganaldemir.ktoastlib.KToast.errorToast(NovaContaActivity2
                                .this, "O campo nome não pode estar vazio.", android.view.Gravity.BOTTOM, com.onurkaganaldemir.ktoastlib.KToast.LENGTH_AUTO);
                    } else {
                        if (editSobreNome.getText().toString().isEmpty()) {
                            com.onurkaganaldemir.ktoastlib.KToast.errorToast(NovaContaActivity2
                                    .this, "O campo sobrenome não pode estar vazio.", android.view.Gravity.BOTTOM, com.onurkaganaldemir.ktoastlib.KToast.LENGTH_AUTO);

                        } else {
                            if (editCelular.getText().toString().isEmpty()) {
                                com.onurkaganaldemir.ktoastlib.KToast.errorToast(NovaContaActivity2
                                        .this, "O campo celular não pode estar vazio.", android.view.Gravity.BOTTOM, com.onurkaganaldemir.ktoastlib.KToast.LENGTH_AUTO);


                            } else {
                                Intent intent = new Intent(NovaContaActivity2.this, NovaContaActivity3.class);

                                intent.putExtra("cpf", sCPF);
                                intent.putExtra("senha", sPassword);
                                intent.putExtra("nome", editNome.getText().toString());
                                intent.putExtra("sobrenome", editSobreNome.getText().toString());
                                intent.putExtra("celular", editCelular.getText().toString());


                                startActivity(intent);

                                customType(NovaContaActivity2.this, "left-to-right");
                            }
                        }
                    }

                }


        });
    }
}