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

    private TextView textCurrency;
    private TextView textValue1;
    private TextView textValue2;
    private TextView textValue3;
    private Button buttonNext;
    private Button buttonBack;
    private FloatingActionButton buttonCreate;

    private int currentIndex = 0;
    private ArrayList<MDL_IponChallenge> iponChallenges;
    public static final String[] currencies = new String[]{"PHP","USD"};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        textCurrency = view.findViewById(R.id.textCurrency);
        textValue1 = view.findViewById(R.id.textAmount1);
        textValue2 = view.findViewById(R.id.textAmount2);
        textValue3 = view.findViewById(R.id.textAmount3);
        textValue2.setText("Hello World");
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

                int currencyIndex = r.nextInt(2);
                int value1 = r.nextInt(100 - 50) + 50;
                int value2 = r.nextInt(100 - 50) + 50;
                int value3 = r.nextInt(100 - 50) + 50;

                MDL_IponChallenge iponChallenge = new MDL_IponChallenge(currencies[currencyIndex], value1, value2, value3);
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
            String currency = iponChallenge.getCurrency();
            textCurrency.setText(currency);
            if(currency.equals("PHP")) {
                textValue1.setText("piso " + Integer.toString(iponChallenge.getPiso()));
                textValue2.setText("bente " + Integer.toString(iponChallenge.getBente()));
                textValue3.setText("sinkwenta " + Integer.toString(iponChallenge.getSinkwenta()));
            }if(currency.equals("USD")) {
                textValue1.setText("penny " + Integer.toString(iponChallenge.getPenny()));
                textValue2.setText("dime " + Integer.toString(iponChallenge.getDime()));
                textValue3.setText("quarter " + Integer.toString(iponChallenge.getQuarter()));
            }
        }
    }
}