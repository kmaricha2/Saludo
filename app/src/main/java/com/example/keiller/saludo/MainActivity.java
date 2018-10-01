package com.example.keiller.saludo;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView getTx1, getTxt2;
    private int getHora, getMinuto;
    private ImageButton imagen;
    private TimePickerDialog mostrarHora;
    private InputMethodManager inputMethodManager;
    private EditText etHora;

    public final Calendar c = Calendar.getInstance();
    final int minuto = c.get(Calendar.MINUTE);
    final int hora = c.get(Calendar.HOUR_OF_DAY);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imageButton);
        etHora = findViewById(R.id.mostrar_hora);
        getTx1 = findViewById(R.id.textView);
        getTxt2 = findViewById(R.id.textView2);

        etHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputMethodManager = (InputMethodManager) getSystemService(MainActivity.this.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(etHora.getWindowToken(), 0);

                mostrarHora = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        etHora.setText(String.format("%02d:%02d", hourOfDay, minutes));
                        getHora = hourOfDay;
                        getMinuto = minutes;
                    }
                }, hora, minuto, true);

                mostrarHora.show();
            }
        });

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Greeter();
            }
        });

        GreeterDeviceTime();
    }

    private void GreeterDeviceTime() {




        if ((hora >= 00 && minuto > 00) && hora < 12) {
            getTxt2.setText(String.format("Buenos días \nLa hora actual es: %02d:%02d ", hora, minuto));
        } else if (hora >= 12 && hora < 18) {
            getTxt2.setText(String.format("Buenas tardes \n La hora actual es: %02d:%02d ", hora, minuto));
        } else {
            getTxt2.setText(String.format("Buenas noches \n La hora actual es: %02d:%02d ", hora, minuto));
        }
    }


    private void Greeter() {
        if ((getHora >= 00 && getMinuto > 00) && getHora < 12) {
            getTx1.setText(String.format("Buenos días son las: %02d:%02d", getHora, getMinuto));
        } else if (getHora >= 12 && getHora < 18) {
            getTx1.setText(String.format("Buenas tardes son las: %02d:%02d", getHora, getMinuto));
        } else {
            getTx1.setText(String.format("Buenas noches son las: %02d:%02d", getHora, getMinuto));
        }
    }

}