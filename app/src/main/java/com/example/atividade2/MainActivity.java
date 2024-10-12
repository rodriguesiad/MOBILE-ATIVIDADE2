package com.example.atividade2;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button button;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }

    public void iniciar(View view){
        button.setEnabled(false);
        button.setText("Processando...");
        contar();
    }

    private void contar() {
        new Thread(new Runnable() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                Integer cont = 10;

                @Override
                public void run() {
                    if (cont >= 0) {
                        text.setText(String.valueOf(cont));
                        cont--;
                        handler.postDelayed(this, 1000);
                    } else {
                        text.setText("10");
                        button.setText("Iniciar");
                        button.setEnabled(true);
                    }
                }
            });
        }
        }).start();
    };

}