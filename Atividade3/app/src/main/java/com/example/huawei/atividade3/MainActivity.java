package com.example.huawei.atividade3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentInputs.OnUserSavedListener{

    private final String FRAG_DETAILS_TAG = "Frag Details";
    private final String FRAG_INPUTS_TAG = "Frag Inputs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isATablet() == false){
            fragmentInputs();
        }
        else if (isATablet() == true){
            fragmentInputsAndDetailTablet();
        }
    }

    private void fragmentInputsAndDetailTablet() {
        fragmentInputs();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentDetalhes,
                FragmentDetails.newInstance(), FRAG_DETAILS_TAG).commit();
    }

    private void fragmentInputs() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentInputs,
                FragmentInputs.newInstance(), FRAG_INPUTS_TAG).commit();
    }

    private boolean isATablet() {
        return getResources().getBoolean(R.bool.Tablet);
    }

    @Override
    public void onUserSaved(User user) {
        //Se Tablet passa o user para a outra fragment
        if(isATablet()) {
            FragmentInputs.OnUserSavedListener callback =
                    (FragmentInputs.OnUserSavedListener)getSupportFragmentManager()
                            .findFragmentByTag(FRAG_DETAILS_TAG);

            callback.onUserSaved(user);
        //Se celular cria a outra fragment passando o user
        } else {
            FragmentDetails fragment = FragmentDetails.newInstance(user);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentInputs, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
