package com.example.huawei.atividade3;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FragmentInputs extends Fragment {

    private EditText name, birthDate, passWord, login, email;
    private Spinner comboGender;
    private String gender;
    private AppCompatActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_inputs, container, false);

        name = (EditText) view.findViewById(R.id.editTextName);
        birthDate = (EditText) view.findViewById(R.id.dataNascimento);
        passWord = (EditText) view.findViewById(R.id.editTextSenha);
        login = (EditText) view.findViewById(R.id.editTextLogin);
        email = (EditText) view.findViewById(R.id.editTextEmail);

        String[] comboSexoLista;
        comboSexoLista = getResources().getStringArray(R.array.sexos);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, comboSexoLista);

        comboGender = (Spinner) view.findViewById(R.id.comboSexo);
        comboGender.setAdapter(adapter);
        comboGender.setOnItemSelectedListener(genderClickListener());

        Button button = (Button) view.findViewById(R.id.buttonSave);
        button.setOnClickListener(btnSaveClickListerner());

        return view;
    }

    private AdapterView.OnItemSelectedListener genderClickListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        };
    }

    private View.OnClickListener btnSaveClickListerner() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(name.getText().toString(), email.getText().toString(), gender, login.getText().toString(), birthDate.getText().toString(), passWord.getText().toString());
                try {
                    ((OnUserSavedListener) mainActivity).onUserSaved(user);

                } catch (ClassCastException e) {
                    throw new ClassCastException(mainActivity.toString()
                            + " must implement OnUserSavedListener");
                }

            }
        };
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (AppCompatActivity) context;
    }

    public static Fragment newInstance() {
        FragmentInputs fragment = new FragmentInputs();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnUserSavedListener {
        void onUserSaved(User user);
    }


}
