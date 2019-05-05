package com.example.caculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnDivide;
    private Button btnMultiply;
    private Button btnMinus;
    private Button btnPlus;
    private Button btnEnter;
    private Button btnDot;
    private Button btnClear;
    private Button btnDel;
    private TextView textBereken;
    private TextView textAntwoorden;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonViews();

        //Button Numbers
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + "9");
            }
        });

        //Button Command (Divide Multiply Minus Plus)
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compute();
                ACTION = DIVISION;
                textAntwoorden.setText(String.valueOf(val1) + "/");
                textBereken.setText(null);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compute();
                ACTION = MULTIPLICATION;
                textAntwoorden.setText(String.valueOf(val1) + "*");
                textBereken.setText(null);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compute();
                ACTION = SUBTRACTION;
                textAntwoorden.setText(String.valueOf(val1) + "-");
                textBereken.setText(null);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compute();
                ACTION = ADDITION;
                textAntwoorden.setText(String.valueOf(val1) + "+");
                textBereken.setText(null);
            }
        });

        //Button Big Command (Enter Dot Delete Clear)
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compute();
                ACTION = EQU;
                textAntwoorden.setText(textAntwoorden.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                textBereken.setText(null);
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textBereken.setText(textBereken.getText().toString() + ".");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                textBereken.setText(null);
                textAntwoorden.setText(null);
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textBereken.getText().length() > 0) {
                    CharSequence name = textBereken.getText().toString();
                    textBereken.setText(name.subSequence(0, name.length() - 1));
                }
            }
        });

    }

    //Button Views
        private void buttonViews() {
            btn0 = (Button) findViewById(R.id.btn0);
            btn1 = (Button) findViewById(R.id.btn1);
            btn2 = (Button) findViewById(R.id.btn2);
            btn3 = (Button) findViewById(R.id.btn3);
            btn4 = (Button) findViewById(R.id.btn4);
            btn5 = (Button) findViewById(R.id.btn5);
            btn6 = (Button) findViewById(R.id.btn6);
            btn7 = (Button) findViewById(R.id.btn7);
            btn8 = (Button) findViewById(R.id.btn8);
            btn9 = (Button) findViewById(R.id.btn9);
            btnDel = (Button) findViewById(R.id.btnDel);
            btnClear = (Button) findViewById(R.id.btnClear);
            btnDivide = (Button) findViewById(R.id.btnDivide);
            btnMultiply = (Button) findViewById(R.id.btnMultiply);
            btnMinus = (Button) findViewById(R.id.btnMinus);
            btnPlus = (Button) findViewById(R.id.btnPlus);
            btnEnter = (Button) findViewById(R.id.btnEnter);
            btnDot = (Button) findViewById(R.id.btnDot);
            textBereken = (TextView) findViewById(R.id.textBereken);
            textAntwoorden = (TextView) findViewById(R.id.textAntwoorden);
        }

        //Compute
        private void Compute() {
            if (!Double.isNaN(val1)) {
                val2 = Double.parseDouble(textBereken.getText().toString());

                switch (ACTION) {
                    case ADDITION:
                        val1 = val1 + val2;
                        break;

                    case SUBTRACTION:
                        val1 = val1 - val2;

                    case DIVISION:
                        val1 = val1 / val2;
                        break;

                    case MULTIPLICATION:
                        val1 = val1 * val2;

                    case EQU:
                        break;
                }
            } else {
                val1 = Double.parseDouble(textBereken.getText().toString());
            }
        }
    }
