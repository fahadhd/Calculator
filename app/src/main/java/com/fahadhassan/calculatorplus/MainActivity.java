package com.fahadhassan.calculatorplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText calcText;
    boolean solutionVisible = false;
    double operationValueOne;
    double operationValueTwo;
    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcText = (EditText) findViewById(R.id.calc_text);

        setupActionListeners();
        setupOperationListeners();
        setupNumberListeners();
    }

    public void setupActionListeners(){
        TextView clear = (TextView) findViewById(R.id.action_clear);
        if(clear != null) clear.setOnClickListener(new ActionListener(this,calcText,"C"));

        TextView changeSign = (TextView) findViewById(R.id.action_change_sign);
        if(changeSign != null) changeSign.setOnClickListener(new ActionListener(this,calcText,"±"));

        TextView percent = (TextView) findViewById(R.id.action_percent);
        if(percent != null) percent.setOnClickListener(new ActionListener(this,calcText,"%"));

        TextView decimal = (TextView) findViewById(R.id.decimal);
        if(decimal != null) decimal.setOnClickListener(new ActionListener(this,calcText,"."));

        TextView squareRoot = (TextView) findViewById(R.id.action_root);
        if(squareRoot != null) squareRoot.setOnClickListener(new ActionListener(this,calcText,"√"));

        TextView squared = (TextView) findViewById(R.id.action_squared);
        if(squared != null) squared.setOnClickListener(new ActionListener(this,calcText,"X²"));

        TextView cubed = (TextView) findViewById(R.id.action_cubed);
        if(cubed != null) cubed.setOnClickListener(new ActionListener(this,calcText,"X³"));

        TextView naturalLog = (TextView) findViewById(R.id.action_natural_log);
        if(naturalLog != null) naturalLog.setOnClickListener(new ActionListener(this,calcText,"ln"));

        TextView commonLog = (TextView) findViewById(R.id.action_log_base10);
        if(commonLog != null) commonLog.setOnClickListener(new ActionListener(this,calcText,"log10"));

        TextView sin = (TextView) findViewById(R.id.action_sin);
        if(sin != null) sin.setOnClickListener(new ActionListener(this,calcText,"sin(x)"));

        TextView cos = (TextView) findViewById(R.id.action_cos);
        if(cos != null) cos.setOnClickListener(new ActionListener(this,calcText,"cos(x)"));

        TextView tan = (TextView) findViewById(R.id.action_tan);
        if(tan != null) tan.setOnClickListener(new ActionListener(this,calcText,"tan(x)"));

        TextView pi = (TextView) findViewById(R.id.action_pi);
        if(pi != null) pi.setOnClickListener(new ActionListener(this,calcText,"π"));

        TextView e = (TextView) findViewById(R.id.action_e);
        if(e != null) e.setOnClickListener(new ActionListener(this,calcText,"e"));

    }

    public void setupOperationListeners(){
        TextView divide = (TextView) findViewById(R.id.divide);
        if(divide != null) divide.setOnClickListener(new OperationListener(this,calcText,"÷"));

        TextView multiply = (TextView) findViewById(R.id.multiply);
        if(multiply != null) multiply.setOnClickListener(new OperationListener(this,calcText,"×"));

        TextView subtract = (TextView) findViewById(R.id.subtract);
        if(subtract != null) subtract.setOnClickListener(new OperationListener(this,calcText,"–"));

        TextView add = (TextView) findViewById(R.id.add);
        if(add != null) add.setOnClickListener(new OperationListener(this,calcText,"+"));

        TextView equals = (TextView) findViewById(R.id.equals);
        if(equals != null) equals.setOnClickListener(new OperationListener(this,calcText,"="));
    }

    public void setupNumberListeners(){
        TextView num_1  = (TextView) findViewById(R.id.one);
        if(num_1 != null) num_1.setOnClickListener(new NumberListener(this,calcText,1));

        TextView num_2  = (TextView) findViewById(R.id.two);
        if(num_2 != null) num_2.setOnClickListener(new NumberListener(this,calcText,2));

        TextView num_3  = (TextView) findViewById(R.id.three);
        if(num_3 != null) num_3.setOnClickListener(new NumberListener(this,calcText,3));

        TextView num_4  = (TextView) findViewById(R.id.four);
        if(num_4 != null) num_4.setOnClickListener(new NumberListener(this,calcText,4));

        TextView num_5  = (TextView) findViewById(R.id.five);
        if(num_5 != null) num_5.setOnClickListener(new NumberListener(this,calcText,5));

        TextView num_6  = (TextView) findViewById(R.id.six);
        if(num_6 != null) num_6.setOnClickListener(new NumberListener(this,calcText,6));

        TextView num_7  = (TextView) findViewById(R.id.seven);
        if(num_7 != null) num_7.setOnClickListener(new NumberListener(this,calcText,7));

        TextView num_8  = (TextView) findViewById(R.id.eight);
        if(num_8 != null) num_8.setOnClickListener(new NumberListener(this,calcText,8));

        TextView num_9  = (TextView) findViewById(R.id.nine);
        if(num_9 != null) num_9.setOnClickListener(new NumberListener(this,calcText,9));

        TextView num_0  = (TextView) findViewById(R.id.zero);
        if(num_0 != null) num_0.setOnClickListener(new NumberListener(this,calcText,0));

    }


}
