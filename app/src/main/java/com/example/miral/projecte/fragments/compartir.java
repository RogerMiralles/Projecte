package com.example.miral.projecte.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.miral.projecte.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class compartir extends Fragment {
    Button button;
    EditText eTxt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView= inflater.inflate(R.layout.fragment_compartir, container, false);
        eTxt = (EditText)rootView.findViewById(R.id.eTxtTextCompartir);
       button=(Button)rootView.findViewById(R.id.btnCompartirText);
       button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               String txt = eTxt.getText().toString();
               String mimeType = "text/plain";
               ShareCompat.IntentBuilder
                       .from(getActivity())
                       .setType(mimeType)
                       .setChooserTitle("Compartir con:")
                       .setText(txt)
                       .startChooser();
           }
       });
       return rootView;
    }

}
