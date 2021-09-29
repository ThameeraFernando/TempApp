package com.example.tempcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate,SubmitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //resource allowcations are done in Oncreate
        btnCalculate=findViewById(R.id.button);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempCal();
            }
        });

    }

    private void tempCal(){
        EditText et=findViewById(R.id.etTemp);
       String temp= et.getText().toString();

        if(temp.equals("")){

            Toast.makeText(this, "Please add a value",Toast.LENGTH_LONG).show();
        }
    else{

        //validate values
            Float tNum=0.0f;
            Boolean error=Boolean.FALSE;
            try{
               tNum= Float.parseFloat(temp);
            }catch (NumberFormatException e){
                Toast.makeText(this, "Please add a valid value",Toast.LENGTH_LONG).show();
                error=Boolean.TRUE;
            }
                    if (!error){
                        TextView tv=findViewById(R.id.tvTemp);
                        RadioGroup rg=findViewById(R.id.radioGroup);
                        int id=rg.getCheckedRadioButtonId();
                        float answer=0.0f;
                        if(id==R.id.rbtnCel){

                            answer=convertFahrenheitToCelcius(tNum);

                        }
                        else{

                            answer=convertCelciusToFahrenheit(tNum);

                        }
                        tv.setText(answer+"");

                    }

        }


    }

    protected float convertCelciusToFahrenheit(Float value) {
        Float ans = (value * 9/5) + 32;
        return ans;
    }
    protected float convertFahrenheitToCelcius(Float value) {
        Float ans = (value - 32) * 5/9;
        return ans;
    }


}
