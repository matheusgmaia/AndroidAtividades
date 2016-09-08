package com.example.huawei.atividade1;

import android.app.Activity;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class RecebeIntentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_intent);
        Bundle args = getIntent().getExtras();
        int numero = args.getInt("Numero");
        String nome = args.getString("Nome");
        TextView text = (TextView) findViewById(R.id.texto);
        text.setText(String.format("%d, %s", numero, nome));
        Log.d("Parte2", String.format("%d", numero));
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
}
