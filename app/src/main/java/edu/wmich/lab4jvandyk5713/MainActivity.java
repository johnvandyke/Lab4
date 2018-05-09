package edu.wmich.lab4jvandyk5713;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends ActionBarActivity {
    private TextView partyDateOutput;
    final RadioButton radButtonRetirement = (RadioButton)findViewById(R.id.radioButtonRetirement);
    final RadioButton radButtonGraduation = (RadioButton)findViewById(R.id.radioButtonGraduation);
    final RadioButton radButtonPajama = (RadioButton)findViewById(R.id.radioButtonPajama);
    final RadioButton radButtonPizza = (RadioButton)findViewById(R.id.radioButtonPizza);
    final RadioButton radButtonHoliday = (RadioButton)findViewById(R.id.radioButtonHoliday);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        partyDateOutput = (TextView) findViewById(R.id.textViewOutput);
        Button btnChooseDate = (Button) findViewById(R.id.buttonChooseDate);
        Button btnNextStep = (Button) findViewById(R.id.buttonNextStep);

        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date,
                        calDate.get(Calendar.YEAR), calDate.get(Calendar.MONTH),
                        calDate.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radButtonGraduation.isChecked()) {
                    partyDateOutput.setText("The reservation for your graduation party on " + calDate
                            + " has been reserved!");
                }

                if (radButtonHoliday.isChecked()) {
                    partyDateOutput.setText("The reservation for your holiday party on " + calDate
                            + " has been reserved!");
                }

                if (radButtonPajama.isChecked()) {
                    partyDateOutput.setText("The reservation for your pajama party on " + calDate
                            + " has been reserved!");
                }

                if (radButtonPizza.isChecked()) {
                    partyDateOutput.setText("The reservation for your pizza party on " + calDate
                            + " has been reserved!");
                }

                if (radButtonRetirement.isChecked()) {
                    partyDateOutput.setText("The reservation for your retirement party on " + calDate
                            + " has been reserved!");
                }
            }
        });
    }

    Calendar calDate = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            calDate.set(Calendar.YEAR, year);
            calDate.set(Calendar.MONTH, monthOfYear);
            calDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }
    };
}

