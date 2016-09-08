package com.example.huawei.atividade1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnviaIntentActivity extends Activity {
    public int numero = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envia_intent);
        Button botao = (Button) this.findViewById(R.id.buttonIniciarActivity);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaIntent(numero++);
            }
        });
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void enviaIntent(int i){
        EditText editText = (EditText) findViewById(R.id.texto_mensagem);
        String message = editText.getText().toString();
        Intent intent = new Intent(getContext(), RecebeIntentActivity.class);
        Bundle params = new Bundle();
        params.putInt("Numero", i);
        params.putString("Nome", ((EditText) findViewById(R.id.texto_mensagem)).getText().toString());
        intent.putExtras(params);
        startActivity(intent);
    }

    public Context getContext() {
        return this;
    }
}
