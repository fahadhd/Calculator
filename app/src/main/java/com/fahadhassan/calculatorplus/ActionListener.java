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

        //Calculator text is empty so handle corner case for pi and e.
        if(calcText!= null && calcText.getText().toString().isEmpty()) {
            if (action.equals("π")) {
                if(activity.operationValueOne == 0)
                    activity.operationValueOne = Math.PI;
                else
                    activity.operationValueTwo = Math.PI;

                calcText.setText(Double.toString(Math.PI));
            }
            if (action.equals("e")) {
                if(activity.operationValueOne == 0)
                    activity.operationValueOne = Math.E;
                else
                    activity.operationValueTwo = Math.E;

                calcText.setText(Double.toString(Math.E));
            }
        }
        //Update operation values and the edit text field depending on the action.
        if (calcText != null && !calcText.getText().toString().isEmpty()) {
            double value = Double.parseDouble(calcText.getText().toString());
            switch (action) {
                //Action - Clearing calculator text field
                case "C":
                    calcText.setText("");
                    activity.operationValueOne = 0;
                    activity.operationValueTwo = 0;
                    calcText.setText("");
                    break;
                //Action - Change sign of the number
                case "±":
                    if (value == activity.operationValueOne) activity.operationValueOne *= -1;
                    if (value == activity.operationValueTwo) activity.operationValueTwo *= -1;
                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value * -1)));
                    else
                        calcText.setText(Double.toString(value * -1));
                    break;
                //Action - Change number to its percent
                case "%":
                    if (value == activity.operationValueOne) activity.operationValueOne *= 0.01;
                    if (value == activity.operationValueTwo) activity.operationValueTwo *= 0.01;

                    calcText.setText(Double.toString(value * 0.01));
                    break;
                //Action - Add a decimal to the calculator text field
                case ".":
                    String currCalculation = calcText.getText().toString();
                    if (currCalculation.charAt(currCalculation.length() - 1) != '.')
                        currCalculation += '.';
                    calcText.setText(currCalculation);
                    break;
                //Action - Get square root of the number
                case "√":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne = Math.sqrt(activity.operationValueOne);
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo = Math.sqrt(activity.operationValueTwo);

                    value = Math.sqrt(value);

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
                //Action - Get square of the number
                case "X²":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne *= activity.operationValueOne;
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo *= activity.operationValueTwo;

                    value *= value;

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
                //Action - Get cube of the number
                case "X³":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne *= activity.operationValueOne * activity.operationValueOne;
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo *= activity.operationValueTwo * activity.operationValueTwo;

                    value *= value * value;

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
                //Action - Get natural log of the number
                case "ln":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne = Math.log(activity.operationValueOne);
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo = Math.log(activity.operationValueTwo);

                    value = Math.log(value);

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
                //Action - Get common log of the number
                case "log10":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne = Math.log10(activity.operationValueOne);
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo = Math.log10(activity.operationValueTwo);

                    value = Math.log10(value);

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
                //Action - Get sine of the number.
                case "sin(x)":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne = Math.sin(activity.operationValueOne);
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo = Math.sin(activity.operationValueTwo);

                    value = Math.sin(value);

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
                //Action - Get cosine of the number.
                case "cos(x)":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne = Math.cos(activity.operationValueOne);
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo = Math.cos(activity.operationValueTwo);

                    value = Math.cos(value);

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
                //Action - Get tangent of the number.
                case "tan(x)":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne = Math.tan(activity.operationValueOne);
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo = Math.tan(activity.operationValueTwo);

                    value = Math.tan(value);

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
                //Action - Replace number with pi.
                case "π":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne = Math.PI;
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo = Math.PI;

                    value = Math.PI;

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
                //Action - Replace number with e.
                case "e":
                    if (value == activity.operationValueOne)
                        activity.operationValueOne = Math.E;
                    if (value == activity.operationValueTwo)
                        activity.operationValueTwo = Math.E;

                    value = Math.E;

                    if (value % 1 == 0)
                        calcText.setText(Integer.toString((int) (value)));
                    else
                        calcText.setText(Double.toString(value));
                    break;
            }
        }
    }
}
