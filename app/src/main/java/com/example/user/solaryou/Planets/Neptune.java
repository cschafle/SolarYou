package com.example.user.solaryou.Planets;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.solaryou.R;
import android.widget.RadioGroup.OnCheckedChangeListener;



/**
 * Created by User on 9/10/2014.
 */
public class Neptune extends Fragment {

    EditText weight;
    EditText day;
    EditText year;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.neptune_fragment, container, false);
        return rootView;
    }

    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button rb1 = (Button) getActivity().findViewById(R.id.radio_Mercury);
        Button rb2 = (Button) getActivity().findViewById(R.id.radio_venus);
        Button rb3 = (Button) getActivity().findViewById(R.id.radio_mars);
        Button rb4 = (Button) getActivity().findViewById(R.id.radio_earth);
        Button rb5 = (Button) getActivity().findViewById(R.id.radio_jupiter);
        Button rb6 = (Button) getActivity().findViewById(R.id.radio_saturn);
        Button rb7 = (Button) getActivity().findViewById(R.id.radio_uranus);

        rb1.setOnClickListener(next_Listener);
        rb2.setOnClickListener(next_Listener);
        rb3.setOnClickListener(next_Listener);
        rb4.setOnClickListener(next_Listener);
        rb5.setOnClickListener(next_Listener);
        rb6.setOnClickListener(next_Listener);
        rb7.setOnClickListener(next_Listener);

    }

    private View.OnClickListener next_Listener = new View.OnClickListener() {
        public void onClick(View v) {

            //xml find out which radio button has been checked ...
            RadioGroup radio_grp=(RadioGroup)getActivity().findViewById(R.id.RadioGroupEarth); //change or leave out this line (I've put it in because you might find it useful later )
            RadioButton rb1=(RadioButton)getActivity().findViewById(R.id.radio_Mercury);  //you dont need to do this again if global ...
            RadioButton rb2 = (RadioButton)getActivity().findViewById((R.id.radio_venus));
            RadioButton rb3 = (RadioButton)getActivity().findViewById((R.id.radio_mars));
            RadioButton rb4 = (RadioButton)getActivity().findViewById((R.id.radio_earth));
            RadioButton rb5 = (RadioButton)getActivity().findViewById((R.id.radio_jupiter));
            RadioButton rb6 = (RadioButton)getActivity().findViewById((R.id.radio_saturn));
            RadioButton rb7 = (RadioButton)getActivity().findViewById((R.id.radio_uranus));

            //find values of edit text fields
            weight  = (EditText) getActivity().findViewById(R.id.weight);
            day = (EditText) getActivity().findViewById(R.id.day);
            year = (EditText) getActivity().findViewById(R.id.year);
            int weightValue = Integer.parseInt(weight.getText().toString());
            int dayValue = Integer.parseInt(day.getText().toString());
            int yearValue = Integer.parseInt(year.getText().toString());

            if(rb1.isChecked() == true) {
                Toast.makeText(getActivity(),"Convert Neptunian units to Mercurian units?",Toast.LENGTH_SHORT).show();
                //weight on earth / surface gravity on earth = mass
                //mass*surface gravity of other planet
                double weight = weightValue/(11.15);
                weight = weight*(3.7);
                weight = (double)Math.round(weight * Math.pow(10, 2))
                        / Math.pow(10, 2);
                //365 = 1 earth year so years*365 / earth days in year on other planet
                double age = (yearValue*(164*365) + dayValue)/88;
                age = (double)Math.round(age * Math.pow(10, 2))
                        / Math.pow(10, 2);
                TextView t = (TextView) getView().findViewById(R.id.displayResults);
                t.setText("Your weight on Mercury is: " + weight + " and your age is: " + age);

            }
            if(rb2.isChecked() == true) {
                Toast.makeText(getActivity(),"Convert Neptunian units to Venusian units?",Toast.LENGTH_SHORT).show();
                double weight = weightValue/(11.15);
                weight = weight*(8.87);

                double age = (yearValue*(365*164) + dayValue)/225;

                weight = (double)Math.round(weight * Math.pow(10, 2))
                        / Math.pow(10, 2);
                age = (double)Math.round(age * Math.pow(10, 2))
                        / Math.pow(10, 2);
                TextView t = (TextView) getView().findViewById(R.id.displayResults);
                t.setText("Your weight on Venus is: " + weight + " and your age is: " + age);
            }
            if(rb3.isChecked() == true) {
                Toast.makeText(getActivity(),"Convert Neptunian units to Martian units?",Toast.LENGTH_SHORT).show();
                double weight = weightValue/(11.15);
                weight = weight*(9.8);

                double age = (yearValue*(365*164) + dayValue)/365;
                weight = (double)Math.round(weight * Math.pow(10, 2))
                        / Math.pow(10, 2);
                age = (double)Math.round(age * Math.pow(10, 2))
                        / Math.pow(10, 2);
                TextView t = (TextView) getView().findViewById(R.id.displayResults);
                t.setText("Your weight on Earth is: " + weight + " and your age is: " + age);

            }
            if(rb4.isChecked() == true) {
                Toast.makeText(getActivity(),"Convert Neptunian units to Earth units?",Toast.LENGTH_SHORT).show();
                double weight = weightValue/(11.15);
                weight = weight*(3.71);

                double age = (yearValue*(365*164) + dayValue)/(687);

                weight = (double)Math.round(weight * Math.pow(10, 2))
                        / Math.pow(10, 2);
                age = (double)Math.round(age * Math.pow(10, 2))
                        / Math.pow(10, 2);
                TextView t = (TextView) getView().findViewById(R.id.displayResults);
                t.setText("Your weight on Mars is: " + weight + " and your age is: " + age);

            }
            if(rb5.isChecked() == true) {
                Toast.makeText(getActivity(),"Convert Neptunian units to Jovian units?",Toast.LENGTH_SHORT).show();
                double weight = weightValue/(11.15);
                weight = weight*(24.92);

                double age = (yearValue*(365*11.8) + dayValue)/(29.4*365);
                weight = (double)Math.round(weight * Math.pow(10, 2))
                        / Math.pow(10, 2);
                age = (double)Math.round(age * Math.pow(10, 2))
                        / Math.pow(10, 2);
                TextView t = (TextView) getView().findViewById(R.id.displayResults);
                t.setText("Your weight on Jupiter is: " + weight + " and your age is: " + age);

            }
            if(rb6.isChecked() == true) {
                Toast.makeText(getActivity(),"Convert Neptunian units to Saturnian units?",Toast.LENGTH_SHORT).show();
                double weight = weightValue/(11.15);
                weight = weight*(10.44);

                double age = (yearValue*(365*29.4) + dayValue)/(84*365);
                weight = (double)Math.round(weight * Math.pow(10, 2))
                        / Math.pow(10, 2);
                age = (double)Math.round(age * Math.pow(10, 2))
                        / Math.pow(10, 2);
                TextView t = (TextView) getView().findViewById(R.id.displayResults);
                t.setText("Your weight on Saturn is: " + weight + " and your age is: " + age);

            }
            if(rb7.isChecked() == true) {
                Toast.makeText(getActivity(),"Convert Neptunian units to Uranian units?",Toast.LENGTH_SHORT).show();
                double weight = weightValue/(11.15);
                weight = weight*(8.87);

                double age = (yearValue*(365*84) + dayValue)/(164*365);
                weight = (double)Math.round(weight * Math.pow(10, 2))
                        / Math.pow(10, 2);
                age = (double)Math.round(age * Math.pow(10, 2))
                        / Math.pow(10, 2);
                TextView t = (TextView) getView().findViewById(R.id.displayResults);
                t.setText("Your weight on Uranus is: " + weight + " and your age is: " + age);

            }
        }
    };

}
