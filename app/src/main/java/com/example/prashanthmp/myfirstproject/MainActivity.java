package com.example.prashanthmp.myfirstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    float balanceAmount,emiAmou,interest =0.009f,carPrice1,minDownPayment1,month1;
    EditText carPrice,mincarDownPayment,emiMOnth;
    TextView carLoan,emiMonthly;
    Button calButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        carPrice = (EditText)findViewById(R.id.carPriceEditText);
        mincarDownPayment = (EditText)findViewById(R.id.carDownpaymentEditText);
        emiMOnth = (EditText)findViewById(R.id.emiMonthEditText);
        calButton = (Button)findViewById(R.id.calButton);

        carLoan = (TextView)findViewById(R.id.loanAmountTextview);
        emiMonthly = (TextView)findViewById(R.id.monthlyTextview);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carPrice1 = Float.parseFloat(carPrice.getText().toString());
                minDownPayment1 = Float.parseFloat(mincarDownPayment.getText().toString());
                month1 = Float.parseFloat(emiMOnth.getText().toString());


                remainingAmount(carPrice1,minDownPayment1);
                emiAmountformonthly(month1);
            }
        });




    }


        public void remainingAmount(float carPrice1, float minDownPayment1){
            balanceAmount = carPrice1 - minDownPayment1;
            String val = String.valueOf(balanceAmount);
            carLoan.setText(val);
            Toast.makeText(getApplicationContext(),val,Toast.LENGTH_LONG).show();

        }

        public void emiAmountformonthly(float month1) {
            emiAmou = (balanceAmount+((balanceAmount * interest)*(month1/12)))/month1;
            String emiVal = String.valueOf(emiAmou);
            emiMonthly.setText(emiVal);
            Toast.makeText(getApplicationContext(), emiVal,Toast.LENGTH_LONG).show();

        }

}
