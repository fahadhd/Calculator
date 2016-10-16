package com.fahadhassan.calculatorplus;

import android.renderscript.Double2;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by admin on 10/15/2016.
 */
public class NumberListener implements View.OnClickListener {
    MainActivity activity;
    EditText calcText;
    long number;

    public NumberListener(MainActivity activity, EditText calcText, long number){
        this.activity = activity;
        this.calcText = calcText;
        this.number = number;
    }


    @Override
    public void onClick(View v) {
        if(calcText != null){
            //Handle case if the solution is on screen ie don't add anything to it.
            if(activity.solutionVisible){
                activity.solutionVisible = false;
                activity.operationValueOne = number;
                activity.operationValueTwo = 0;
                activity.operation = "";

                calcText.setText(Long.toString(number));
            }
            else {
                String currCalculation = calcText.getText().toString();

                currCalculation += number;
                calcText.setText(currCalculation);

                if (!activity.operation.isEmpty()) {
                    activity.operationValueTwo = Double.parseDouble(currCalculation);
                }
            }

        }
    }
}
