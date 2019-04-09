package net.hafiznaufalr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import net.hafiznaufalr.calc.HitungGain;
import net.hafiznaufalr.calc.HitungLoss;
import net.hafiznaufalr.calc.hitungdaya;

public class CalculatorMenu extends AppCompatActivity implements View.OnClickListener {
    CardView c1,c2,c3,c4,c5,c6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_menu);

        c1 = (CardView) findViewById(R.id.utas);
        c1.setOnClickListener((View.OnClickListener) this);
        c5 = (CardView) findViewById(R.id.lima);
        c5.setOnClickListener((View.OnClickListener) this);
        c6 = (CardView) findViewById(R.id.enam);
        c6.setOnClickListener((View.OnClickListener) this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.utas:
                Intent lIntent = new Intent(CalculatorMenu.this, hitungdaya.class);
                startActivity(lIntent);
                break;
            case R.id.lima:
                Intent enIntent = new Intent(CalculatorMenu.this, HitungGain.class);
                startActivity(enIntent);
                break;
            case R.id.enam:
                Intent nIntent = new Intent(CalculatorMenu.this, HitungLoss.class);
                startActivity(nIntent);
                break;



        }


    }
}
