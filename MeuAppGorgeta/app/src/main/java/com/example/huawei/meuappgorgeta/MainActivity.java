package com.example.huawei.meuappgorgeta;

import android.animation.ObjectAnimator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int progresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Calculadora de Gorjeta");
        }
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final ImageView icone = (ImageView) findViewById(R.id.iconImage);
        final TextView valorDesconto = (TextView)findViewById(R.id.valorDesconto);
        final TextView valorTotal = (TextView)findViewById(R.id.valorTotal);
        final TextView descontoTexto = (TextView)findViewById(R.id.desconto_texto);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresso = progress;
                descontoTexto.setText(String.format("Gorjeta:%d", progresso) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText valor = (EditText)findViewById(R.id.valorDaConta);
                if(valor.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "Nenhum valor inserido", Toast.LENGTH_SHORT).show();
                    return;
                }

                icone.setRotation(0);
                ObjectAnimator a = ObjectAnimator.ofFloat(icone, "rotation", icone.getRotation(), 360 );
                a.start();

                double  total = 0.0,
                        value = Double.parseDouble(valor.getText().toString());
                int tipPercentage = seekBar.getProgress();
                total+= value + (tipPercentage * 0.01 * value);

                valorTotal.setText(String.format("Valor total da conta: R$ %.2f", total));
                valorDesconto.setText(String.format("Valor da gorjeta: R$ %.2f",tipPercentage * 0.01 * value));


            }
        });


    }
}






