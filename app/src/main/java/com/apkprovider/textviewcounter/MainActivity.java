package com.apkprovider.textviewcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.apkprovider.textviewcounter.customtextview.CountingTextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    private CountingTextView textView;
    private Button randomFloatButton;
    private Button randomIntButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (CountingTextView) findViewById(R.id.text_view);
        randomFloatButton = (Button) findViewById(R.id.random_float_button);
        randomIntButton = (Button) findViewById(R.id.random_integer_button);


        init();
    }

    private void init(){

         randomFloatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomInt = random.nextInt(100);
                float randomFloat = random.nextFloat();
                float finalFloat = (float) randomInt * randomFloat;

                textView.setFormatter(new CountingTextView.ValueFormatter() {
                    @Override
                    public String formatValue(float value) {
                        return String.format("$ %.2f%%", value);
                    }
                });

                textView.setValue(finalFloat);
            }
        });

        randomIntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setFormatter(new CountingTextView.ValueFormatter() {
                    @Override
                    public String formatValue(float value) {
                        return String.format("$ %.0f", value);
                    }
                });

                int randomInt = random.nextInt(100);
                textView.setValue((float) randomInt);
            }
        });

    }

}
