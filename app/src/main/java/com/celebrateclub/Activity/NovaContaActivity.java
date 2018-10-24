package com.celebrateclub.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.celebrateclub.R;
import com.celebrateclub.Util.ValidaCPF;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;

import static android.app.PendingIntent.FLAG_ONE_SHOT;
import static maes.tech.intentanim.CustomIntent.customType;

public class NovaContaActivity extends AppCompatActivity {

    private Button btnProximaPagina;
    private EditText editCPF, editPassword, editPasswordConfirm;
    private String sCPF, sPassword, sPasswordConfirm, cpfConvertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta);
        btnProximaPagina = findViewById(R.id.btnAvancar);
        editCPF = findViewById(R.id.editCPF);
        editPassword = findViewById(R.id.editPassword);
        editPasswordConfirm = findViewById(R.id.editPasswordConfirm);



        MaskEditTextChangedListener maskCPF = new MaskEditTextChangedListener("###.###.###-##", editCPF);
        editCPF.addTextChangedListener(maskCPF);


        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        btnProximaPagina.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                sCPF = editCPF.getText().toString();
                sPassword = editPassword.getText().toString();
                sPasswordConfirm = editPasswordConfirm.getText().toString();
                cpfConvertido = sCPF.replace(".", "").replace("-", "");




                            if (ValidaCPF.isCPF(cpfConvertido) == true) {

                                    Intent intent = new Intent(NovaContaActivity.this, NovaContaActivity2.class);

                                    intent.putExtra("cpf", sCPF);
                                    intent.putExtra("senha", sPassword);
                                intent.addFlags(FLAG_ONE_SHOT);
                                    startActivity(intent);
                                customType(NovaContaActivity.this,"left-to-right");

                                    editCPF.getText().clear();
                                    editPassword.getText().clear();
                                    editPasswordConfirm.getText().clear();



                            } else {

                                com.onurkaganaldemir.ktoastlib.KToast.warningToast(NovaContaActivity
                                .this, "Verifique o CPF digitado.", android.view.Gravity.BOTTOM, com.onurkaganaldemir.ktoastlib.KToast.LENGTH_AUTO);
                            }





            }
        });


    }
}
