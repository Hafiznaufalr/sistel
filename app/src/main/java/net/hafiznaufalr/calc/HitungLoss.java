package net.hafiznaufalr.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.hafiznaufalr.R;

public class HitungLoss extends AppCompatActivity {
    EditText edtInput,edtOutput;
    Button btnHitung, btnReset;
    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_loss);

        edtInput = (EditText)findViewById(R.id.input);
        edtOutput = (EditText)findViewById(R.id.output);
        btnHitung = (Button) findViewById(R.id.btnHitung);
        txtHasil = (TextView)findViewById(R.id.txtHasil);
        btnReset= (Button) findViewById(R.id.btnReset);

        initEvent();
        reset();
    }

    private void reset() {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtInput.setText("");
                edtOutput.setText("");
                txtHasil.setText("");
            }
        });
    }

    private void initEvent() {
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtInput.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    edtInput.setError("err");
                }
                else if (edtOutput.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    edtOutput.setError("err");
                }else
                    hitungLos();
            }
        });
    }

    private void hitungLos() {
        Double input = Double.parseDouble(edtInput.getText().toString());
        Double output = Double.parseDouble(edtOutput.getText().toString());
        txtHasil.setText(String.valueOf(10 * Math.log10 (output/input)));

        if (input < output){
            Toast.makeText(getApplicationContext(), "Output Tidak Boleh Lebih Besar", Toast.LENGTH_SHORT).show();
            txtHasil.setText("error");
        }



    }
}