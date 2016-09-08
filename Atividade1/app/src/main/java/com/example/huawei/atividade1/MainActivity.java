package com.example.huawei.atividade1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends android.support.v4.app.FragmentActivity {

    public static final String TAG_CICLO_DE_VIDA = "CicloDeVidaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG_CICLO_DE_VIDA, String.format("%s.%s", getClassName(), "OnCreate()"));
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Atividade 1");
        }
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        DinamAddedFrag frag1 = new DinamAddedFrag();
        ft.add(R.id.layoutFrag, frag1, "FragmentDinam");
        ft.commit();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu com os botões da action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.parte2_criarActivity) {
            Intent intent = new Intent(this, EnviaIntentActivity.class);
            startActivity(intent);
            Toast.makeText(this, "PARTE 2", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String getClassName() {
        String className = getClass().getName();
        return (className.substring(className.lastIndexOf(".") + 1));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG_CICLO_DE_VIDA, String.format("%s.%s", getClassName(), "OnDestroy()"));

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG_CICLO_DE_VIDA, String.format("%s.%s", getClassName(), "OnStop()"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG_CICLO_DE_VIDA, String.format("%s.%s", getClassName(), "OnPause()"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG_CICLO_DE_VIDA, String.format("%s.%s", getClassName(), "OnRestart()"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG_CICLO_DE_VIDA, String.format("%s.%s", getClassName(), "OnStart()"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG_CICLO_DE_VIDA, String.format("%s.%s", getClassName(), "OnResume()"));
    }
}
