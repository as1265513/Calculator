package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements OnClickListener

{
    //Defining the Views
    EditText Num1;
    EditText Num2;
    Button Add;
    Button Sub;
    Button Mul;

    float result = 0;
    Button Div;
    TextView Result;
    TextView History;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Referring the Views
        Num1 = (EditText) findViewById(R.id.editText1);
        Num2 = (EditText) findViewById(R.id.editText2);
        Add = (Button) findViewById(R.id.Add);
        Sub = (Button) findViewById(R.id.Sub);
        Mul = (Button) findViewById(R.id.Mul);
        History =(TextView) findViewById(R.id.History);
        Div = (Button) findViewById(R.id.Div);
        Result = (TextView) findViewById(R.id.Result);

// set a listener
        Add.setOnClickListener(this);
        Sub.setOnClickListener(this);
        Mul.setOnClickListener(this);
        Div.setOnClickListener(this);
        Result.setOnClickListener(this);
        History.setOnClickListener(this);
    }


    @Override
    public void onClick (View v)
    {
        float num1 = 0;
        float num2 = 0;

        String oper = " ";
        String his = History.getText()+"\n";
// check if the fields are empty
        if (TextUtils.isEmpty(Num1.getText().toString()) || TextUtils.isEmpty(Num2.getText().toString()))
            return;
// read EditText and fill variables with numbers
        num1 = Float.parseFloat(Num1.getText().toString());
        num2 = Float.parseFloat(Num2.getText().toString());
// defines the button that has been clicked and performs the corresponding operation
// write operation into oper, we will use it later for output
        switch (v.getId())
        {
            case R.id.Add:
                oper = "+";
                result = num1 + num2;
                break;

            case R.id.Sub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.Mul:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.Div:
                oper = "/";
                result = num1 / num2;
                break;
            case R.id.Result:
                if(Result.getText()!="Answer is")
                {
                    Num1.setText(result+"");
                    Num2.setText("");
                }
                oper="";
                break;
            case R.id.History:
                if(History.getText()!="History")
                {
                    History.setText("History\n");
                }
                oper="";
                break;
            default:
                break;
        }
// form the output line
            if(oper!="")
            {
                his=his+num1+oper+num2+"="+result+",";
                History.setText(his+"");
            }
            Result.setText(num1 + " " + oper + " " + num2 + " = " + result);

    }



}