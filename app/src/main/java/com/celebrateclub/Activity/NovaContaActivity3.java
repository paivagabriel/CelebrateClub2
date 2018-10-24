package com.celebrateclub.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.celebrateclub.R;
import com.celebrateclub.Util.ValidaEmail;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

import static maes.tech.intentanim.CustomIntent.customType;

public class NovaContaActivity3 extends AppCompatActivity {

    private Button btnAvancar;
    private EditText editEmail, editDataNascimento, editGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta3);
        editEmail = findViewById(R.id.editCPF);
        editDataNascimento = findViewById(R.id.editDataNascimento);
        btnAvancar = findViewById(R.id.btnAvancar);

        MaskEditTextChangedListener maskDataNascimento = new MaskEditTextChangedListener("##/##/####", editDataNascimento);
        editDataNascimento.addTextChangedListener(maskDataNascimento);
        Intent intent = getIntent();
        final String sCPF = intent.getStringExtra("cpf");
        final String sPassword = intent.getStringExtra("senha");
        final String sNome = intent.getStringExtra("nome");
        final String sSobrenome = intent.getStringExtra("sobrenome");
        final String sCelular = intent.getStringExtra("celular");
        Log.i("CADASTRO",sCPF+", "+ sPassword+", "+ sNome+", "+sSobrenome+", "+ sCelular);

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Masculino", "Feminino", "Prefiro não dizer"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);




        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidaEmail.validar(editEmail) == false){
                    com.onurkaganaldemir.ktoastlib.KToast.errorToast(NovaContaActivity3
                            .this, "Verifique o e-mail digitado.", android.view.Gravity.BOTTOM, com.onurkaganaldemir.ktoastlib.KToast.LENGTH_AUTO);
                }else{
                    startActivity(new Intent(NovaContaActivity3.this, HomeActivity.class));
                    com.onurkaganaldemir.ktoastlib.KToast.successToast(NovaContaActivity3
                            .this, sCPF+", "+ sPassword+", "+ sNome+", "+sSobrenome+", "+ sCelular, android.view.Gravity.BOTTOM, com.onurkaganaldemir.ktoastlib.KToast.LENGTH_AUTO);
                    customType(NovaContaActivity3.this,"left-to-right");
                }


            }
        });
    }


}
