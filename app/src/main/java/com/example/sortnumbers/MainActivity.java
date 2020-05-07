package com.example.sortnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;
        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            } if (triangularNumber == number) {
                return true;
            }else {
                return false;
            }
        }
    }

    public void checkNumber (View view) {

        EditText editText = (EditText) findViewById(R.id.editText);


        String message;
        if (editText.getText().toString().isEmpty()) {
            message = "Please enter a number";
        }else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());

            message = editText.getText().toString();

            if (myNumber.isSquare() && myNumber.isTriangular()) {
                message += " is a square and triangular.";
            } else if (myNumber.isSquare()) {
                message += " is a square.";
            } else if (myNumber.isTriangular()) {
                message += " is a triangular.";
            } else {
                message += " is neither a square nor a triangular.";
            }

            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            System.out.println(myNumber.isSquare());
            Log.i("Info", "button pressed");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
