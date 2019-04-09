package net.hafiznaufalr.calc;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.hafiznaufalr.R;

import java.util.ArrayList;
import java.util.List;

public class hitungdaya extends AppCompatActivity {
    private EditText angka1;
    private TextView hasil;
    private Spinner spin1,spin2;
    private Button btnHitung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitungdaya);
        angka1 = (EditText)findViewById(R.id.editPertama);
        hasil = (TextView) findViewById(R.id.hasill);
        spin1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list1 = new ArrayList<>();
        list1.add("DBm");
        list1.add("DBw");
        list1.add("Watt");
        list1.add("mWatt");
        ArrayAdapter dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,list1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(dataAdapter);

        spin2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list2 = new ArrayList<>();
        list2.add("DBm");
        list2.add("DBw");
        list2.add("Watt");
        list2.add("mWatt");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(dataAdapter2);
        btnHitung = (Button) findViewById(R.id.btnHitung);

        hitung();

    }

    private void hitung() {
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selected1 = (String) spin1.getSelectedItem();
                String selected2 = (String) spin2.getSelectedItem();

                if (selected1.trim().equals("DBm") && selected2.trim().equals("Watt")) {
                    Double dbmValue = Double.parseDouble(angka1.getText().toString());
                    Double exponent = dbmValue / 10;
                    String result = String.format("%.2f", Math.pow(10.0, exponent) / 1000);
                    hasil.setText(result + " Watt");
                } else if (selected1.trim().equals("DBm") && selected2.trim().equals("DBw")) {
                    Double dbmValue = Double.parseDouble(angka1.getText().toString());
                    String result = String.format("%.2f", dbmValue - 30);
                    hasil.setText(result + " Dbw");
                }else if (selected1.trim().equals("DBw") && selected2.trim().equals("DBm")) {
                    Double dbmValue = Double.parseDouble(angka1.getText().toString());
                    String result = String.format("%.2f", dbmValue + 30);
                    hasil.setText(result + " DBm");
                }else if (selected1.trim().equals("DBw") && selected2.trim().equals("Watt")) {
                    Double dbwValue = Double.parseDouble(angka1.getText().toString());
                    Double exponent = dbwValue / 10;
                    String result = String.format("%.2f", Math.pow(10.0, exponent));
                    hasil.setText(result + " Watt");
                }else if (selected1.trim().equals("Watt") && selected2.trim().equals("DBm")) {
                    Double wattValue = Double.parseDouble(angka1.getText().toString());
                    Double y = wattValue * 1000;
                    Double exponent = Math.log(y) / Math.log(10) * 10;
                    Double x = Math.ceil(exponent);
                    String result = x.toString();
                    hasil.setText(result + " DBm");
                }else if (selected1.trim().equals("Watt") && selected2.trim().equals("DBw")) {
                    Double wattValue = Double.parseDouble(angka1.getText().toString());
                    Double x = wattValue ;
                    Double y = Math.log(x) / Math.log(10) * 10;
                    Double z = Math.ceil(y);
                    String result = z.toString();
                    hasil.setText(result + " DBw");

                    //update terakhir//////////////////////////////////////////////////////////////

                }else if (selected1.trim().equals("DBm") && selected2.trim().equals("mWatt")) {
                    Double dbmValue = Double.parseDouble(angka1.getText().toString());
                    Double exponent = dbmValue / 10;
                    String result = String.format("%.2f", Math.pow(10.0, exponent));
                    hasil.setText(result + " mWatt");
                }else if (selected1.trim().equals("DBw") && selected2.trim().equals("mWatt")) {
                    Double dbwValue = Double.parseDouble(angka1.getText().toString());
                    Double exponent = dbwValue / 10;
                    String result = String.format("%.2f", Math.pow(10.0, exponent) * 1000);
                    hasil.setText(result + " mWatt");
                }else if(selected1.trim().equals("Watt") && selected2.trim().equals("mWatt")){
                    Double wattValue = Double.parseDouble(angka1.getText().toString());
                    Double result = wattValue *1000;
                    hasil.setText(result + " mWatt");
                }else if (selected1.trim().equals("mWatt") && selected2.trim().equals("DBm")) {
                    Double mWattValue = Double.parseDouble(angka1.getText().toString());
                    Double x = mWattValue;
                    Double y = Math.log(x) / Math.log(10) * 10;
                    Double z = Math.ceil(y);
                    String result = z.toString();
                    hasil.setText(result + " DBm");
                }else if (selected1.trim().equals("mWatt") && selected2.trim().equals("DBw")) {
                    Double mWattValue = Double.parseDouble(angka1.getText().toString());
                    Double x = mWattValue / 1000;
                    Double y = Math.log(x) / Math.log(10) * 10;
                    Double z = Math.ceil(y);
                    String result = z.toString();
                    hasil.setText(result + " DBw");
                }else if(selected1.trim().equals("mWatt") && selected2.trim().equals("Watt")) {
                    Double wattValue = Double.parseDouble(angka1.getText().toString());
                    Double result = wattValue / 1000;
                    hasil.setText(result + " Watt");
                }
            }
        });

    }
}