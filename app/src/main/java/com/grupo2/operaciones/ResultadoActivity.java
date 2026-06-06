package com.grupo2.operaciones;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView tvOperacion = findViewById(R.id.tvOperacion);
        TextView tvResultado = findViewById(R.id.tvResultado);
        Button btnVolver = findViewById(R.id.btnVolver);

        double resultado = getIntent().getDoubleExtra("resultado", 0);
        double num1 = getIntent().getDoubleExtra("num1", 0);
        double num2 = getIntent().getDoubleExtra("num2", 0);
        String operacion = getIntent().getStringExtra("operacion");

        tvOperacion.setText(num1 + " " + operacion + " " + num2);
        tvResultado.setText(String.valueOf(resultado));

        btnVolver.setOnClickListener(v -> finish());
    }
}
