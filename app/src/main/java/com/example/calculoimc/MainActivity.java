package com.example.calculoimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calculoimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private TextView resultado;
    private TextView classificacao;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // COMEÇA AQUI

// onde exibe o resultado
        TextView resultado = findViewById(R.id.txt_resultado);

// onde exibe a classificação
        TextView classificacao = findViewById(R.id.txt_classificacao);

// botao para calcular
        Button botaoCalcular = findViewById(R.id.btn_calcular);
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularImc();
            }

            private void calcularImc() {
                // Obtém os valores de peso e altura dos campos de entrada
                EditText pesoInput = findViewById(R.id.peso_input);
                EditText alturaInput = findViewById(R.id.altura_input);

                // Converte os valores para double
                double peso = Double.parseDouble(pesoInput.getText().toString());
                double altura = Double.parseDouble(alturaInput.getText().toString());

                // Calcula o IMC
                double imc = calcularIMC(peso, altura);

                // Exibe o resultado do IMC
                resultado.setText(String.valueOf(valorConvertido);

                // Classifica o IMC
                String classificacaoImc = classificarIMC(imc);
                classificacao.setText("Classificação: " + classificacaoImc);
            }

            private double calcularIMC(double peso, double altura) {
                // Fórmula do IMC: peso / (altura * altura)
                return peso / (altura * altura);
            }

            private String classificarIMC(double imc) {
                // Adapte as faixas de classificação conforme necessário
                if (imc < 18.5) {
                    return "Abaixo do peso";
                } else if (imc >= 18.5 && imc < 24.9) {
                    return "Peso normal";
                } else if (imc >= 25 && imc < 29.9) {
                    return "Sobrepeso";
                } else if (imc >= 30 && imc < 34.9) {
                    return "Obesidade Grau I";
                } else if (imc >= 35 && imc < 39.9) {
                    return "Obesidade Grau II";
                } else {
                    return "Obesidade Grau III";
                }
            }
        });

    }
    }