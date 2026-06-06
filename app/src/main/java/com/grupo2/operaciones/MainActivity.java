package com.grupo2.operaciones;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editNum1, editNum2;
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);

        btnSumar.setOnClickListener(v -> operar("Suma"));
        btnRestar.setOnClickListener(v -> operar("Resta"));
        btnMultiplicar.setOnClickListener(v -> operar("Multiplicación"));
        btnDividir.setOnClickListener(v -> operar("División"));
    }

    private void operar(String tipo) {
        String s1 = editNum1.getText().toString();
        String s2 = editNum2.getText().toString();

        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2)) {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double num1 = Double.parseDouble(s1);
            double num2 = Double.parseDouble(s2);
            OperacionesMatematicas op = new OperacionesMatematicas(num1, num2);

            double resultado;
            if (tipo.equals("Suma")) resultado = op.sumar();
            else if (tipo.equals("Resta")) resultado = op.restar();
            else if (tipo.equals("Multiplicación")) resultado = op.multiplicar();
            else resultado = op.dividir();

            Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
            intent.putExtra("resultado", resultado);
            intent.putExtra("operacion", tipo);
            intent.putExtra("num1", num1);
            intent.putExtra("num2", num2);
            startActivity(intent);

        } catch (ArithmeticException e) {
            Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingresa valores numéricos válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
