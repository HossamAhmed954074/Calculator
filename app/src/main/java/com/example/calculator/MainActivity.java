package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView txt_result;
    private String old_Number = "";
    private String new_Number = "";
    private String old_Operator = "";
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_result = findViewById(R.id.calculator_display);

    }


    public void clickDigit(View view) {
        Button b = (Button) view;
        if (txt_result.getText().toString().contains(".") && b.getText().toString().contains(".")) {
            return;
        }
        txt_result.append(b.getText().toString());
        new_Number = txt_result.getText().toString();

    }

    public void ClickOperation(View view) {
        Button operation = (Button) view;
        if (old_Operator.isEmpty()) {
            old_Number = txt_result.getText().toString();

        } else {
            new_Number = txt_result.getText().toString();

        }
        old_Operator = operation.getText().toString();
        txt_result.setText("");

    }

    public void clickSummation(View view) {
        if (!old_Operator.isEmpty() && !old_Number.isEmpty() && !new_Number.isEmpty()) {
            result = calcNumbers(old_Number, old_Operator, new_Number);
            txt_result.setText(result);
            old_Number = result;
            old_Operator = "";
            new_Number = "";
            result = "";
        } else {

            old_Operator = "";
            new_Number = "";
            old_Number = "";
            result = "";
        }


    }

    public void clearAllData(View view) {
        if (!txt_result.getText().toString().isEmpty()) {
            txt_result.setText("");
            old_Operator = "";
            new_Number = "";
            old_Number = "";
        }

    }

    public void deleteLastDigit(View v) {
        if (!txt_result.getText().toString().isEmpty()) {
            StringBuilder text = new StringBuilder(txt_result.getText().toString());
            text.delete(text.length() - 1, text.length());
            txt_result.setText(text.toString());
        }
    }

    private String calcNumbers(String num1, String operator, String num2) {
        if (num1.contains(".") || num2.contains(".")) {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            switch (operator) {
                case "+":
                    return (n1 + n2) + "";
                case "-":
                    return (n1 - n2) + "";
                case "x":
                    return (n1 * n2) + "";
                case "÷":
                    if (n2 > 0)
                        return (n1 / n2) + "";
                    else
                        return "Cannot divide by zero";
                case "%":
                    if (n1 > n2)
                        return (n1 % n2) + "";
                    else
                        return n1 + "";
                case "^":{
                    double result=1;
                    for(int i=1;i<=n2;i++){
                        result*=n1;
                    }
                    return (result)+"";
                }


                default:
                    return "Not Allowed The Operator";
            }
        } else {
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);
            switch (operator) {
                case "+":
                    return (n1 + n2) + "";
                case "-":
                    return (n1 - n2) + "";
                case "x":
                    return (n1 * n2) + "";
                case "÷":
                    if (n2 > 0)
                        return (n1 / n2) + "";
                    else
                        return "Cannot divide by zero";
                case "%":
                    if (n1 > n2)
                        return (n1 % n2) + "";
                    else
                        return n1 + "";
                case "^":{
                    int result=1;
                    for(int i=1;i<=n2;i++){
                        result*=n1;
                    }
                    return result+"";
                }
                default:
                    return "Not Allowed The Operator";
            }
        }

    }


}