package com.example.greendaomigration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class FirstFragment extends Fragment {

    private TextView textPiso;
    private TextView textBente;
    private TextView textSinkwenta;
    private Button buttonNext;
    private Button buttonBack;
    private FloatingActionButton buttonCreate;

    private int currentIndex = 0;
    private ArrayList<MDL_IponChallenge> iponChallenges;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        textPiso = view.findViewById(R.id.textAmount1);
        textBente = view.findViewById(R.id.textAmount2);
        textSinkwenta = view.findViewById(R.id.textAmount3);
        textBente.setText("Hello World");
        buttonNext = view.findViewById(R.id.button_first);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pendingIndex = currentIndex + 1;
                if (pendingIndex < iponChallenges.size()) {
                    currentIndex = pendingIndex;
                    setChallengeIndex();
                }
            }
        });

        buttonBack = view.findViewById(R.id.button_second);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pendingIndex = currentIndex -  1;
                if (pendingIndex >= 0) {
                    currentIndex = pendingIndex;
                    setChallengeIndex();
                }
            }
        });

        buttonCreate = view.findViewById(R.id.fab);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random r = new Random();
                int piso = r.nextInt(100 - 10) + 50;
                int bente = r.nextInt(100 - 10) + 50;
                int sinkwenta = r.nextInt(100 - 10) + 50;

                MDL_IponChallenge iponChallenge = new MDL_IponChallenge(piso,bente,sinkwenta);
                ApplicationGreendaoMigration.getIponChallengeSession().insert(iponChallenge);

                refreshChallenges();
            }
        });

        refreshChallenges();
        return view;
    }

    public void refreshChallenges(){
        iponChallenges = ApplicationGreendaoMigration.getIponChallenges();
        currentIndex = iponChallenges.size() - 1;
        setChallengeIndex();
    }

    public void setChallengeIndex(){
        if (!iponChallenges.isEmpty() && iponChallenges.get(currentIndex) != null) {
            MDL_IponChallenge iponChallenge = iponChallenges.get(currentIndex);
            textPiso.setText(Integer.toString(iponChallenge.getPiso()));
            textBente.setText(Integer.toString(iponChallenge.getBente()));
            textSinkwenta.setText(Integer.toString(iponChallenge.getSinkwenta()));
        }
    }
}