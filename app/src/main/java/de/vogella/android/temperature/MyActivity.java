package de.vogella.android.temperature;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;


public class MyActivity extends Activity {

    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        text = (EditText)findViewById(R.id.editText);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                RadioButton celsiusButton = (RadioButton) findViewById(R.id.radioButton);
                RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radioButton2);
                //Valido que se ingrese un valor
                if (text.getText().length() == 0) {
                        Toast.makeText(this, "Favor ingrese un valor correcto", Toast.LENGTH_LONG).show();
                        return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {
                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                } else {
                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                }
                break;
            case R.id.button2:
                ImageView imagen = (ImageView) findViewById(R.id.myicon);
                imagen.setImageResource(R.drawable.assigned);


                AssetManager manager = getAssets();
                InputStream open = null;

                try {
                    open = manager.open("assigned.png");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }



                break;
        }


    }



}
