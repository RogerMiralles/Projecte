package com.example.miral.projecte.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miral.projecte.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class calendario extends Fragment {

    CalendarView calendar;
    EditText fecha;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.fragment_calendario, container, false);

        calendar = (CalendarView)rootView.findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                fecha=(EditText)rootView.findViewById(R.id.eTxtFecha) ;
                fecha.setText(day + "/" + month + "/" + year);
            }
        });
        button=(Button)rootView.findViewById(R.id.btnAceptarGuardar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), "Guardado", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

}
