package com.fahadhassan.calculatorplus;

import android.view.View;
import android.widget.EditText;

/**
 * Created by admin on 10/15/2016.
 */
public class OperationListener implements View.OnClickListener  {
    EditText calcText;
    String operation;
    MainActivity activity;
    public OperationListener(MainActivity activity, EditText calcText, String operation){
        this.activity = activity;
        this.calcText = calcText;
        this.operation = operation;
    }
    @Override
    public void onClick(View v) {

        if(calcText != null){
            if(!operation.equals("=")) {
                String currCalculation = calcText.getText().toString();

                if(!currCalculation.isEmpty()) {
                    activity.operationValueOne = Double.parseDouble(currCalculation);
                }
                activity.operation = operation;
                activity.solutionVisible = false;

               calcText.setText("");
            }
            else{
                double solution = 0;
                double valueOne = activity.operationValueOne;
                double valueTwo = activity.operationValueTwo;

                switch (activity.operation){
                    case "+": solution = valueOne + valueTwo; break;
                    case "–": solution = valueOne - valueTwo; break;
                    case "×": solution = valueOne * valueTwo; break;
                    case "÷": solution = valueOne / valueTwo; break;
                }
                activity.operationValueOne = solution;
                activity.solutionVisible = true;
                if(solution % 1 == 0) calcText.setText(Integer.toString((int)solution));
                else calcText.setText(Double.toString(solution));
            }
        }
    }
}
