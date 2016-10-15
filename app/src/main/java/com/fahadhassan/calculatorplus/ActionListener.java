package com.fahadhassan.calculatorplus;

import android.view.View;
import android.widget.EditText;


public class ActionListener implements View.OnClickListener {
    MainActivity activity;
    EditText calcText;
    String action;
    public ActionListener(MainActivity activity, EditText calcText, String action){
        this.activity = activity;
        this.calcText = calcText;
        this.action = action;
    }

    @Override
    public void onClick(View v) {
        if(calcText != null && !calcText.getText().toString().isEmpty()){
            double value = Double.parseDouble(calcText.getText().toString());
            switch (action){
                case "ac":
                    calcText.setText("");
                    activity.operationValueOne = 0;
                    activity.operationValueTwo = 0;
                    calcText.setText("");
                    break;

                case "±":
                    if(value == activity.operationValueOne) activity.operationValueOne *= -1;
                    if(value == activity.operationValueTwo) activity.operationValueTwo *= -1;
                    if(value % 1 == 0)
                        calcText.setText(Integer.toString((int)(value*-1)));
                    else
                        calcText.setText(Double.toString(value*-1));
                    break;

                case "%":
                    if(value == activity.operationValueOne) activity.operationValueOne *= 0.01;
                    if(value == activity.operationValueTwo) activity.operationValueTwo *= 0.01;

                    calcText.setText(Double.toString(value*0.01));

                    break;
                case ".":
                    String currCalculation = calcText.getText().toString();
                    if(currCalculation.charAt(currCalculation.length()-1) != '.')
                        currCalculation += '.';

                    calcText.setText(currCalculation);

                    break;
            }
        }
    }
}
