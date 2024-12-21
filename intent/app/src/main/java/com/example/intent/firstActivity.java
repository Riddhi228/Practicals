package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class firstActivity extends AppCompatActivity {
    Button btnNext;

    EditText etName,etCno,etAge,etPass;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btnNext.setOnClickListener(v -> {
            String name=etName.getText().toString().trim();
            String strAge=etAge.getText().toString().trim();
            int age=Integer.parseInt(strAge);
            String strCno=etCno.getText().toString().trim();
            int cno=Integer.parseInt(strCno);
            String pass=etPass.getText().toString().trim();

            Intent i1=new Intent(this,secActivity.class);
            i1.putExtra("NAME",name);
            i1.putExtra("AGE",age);
            i1.putExtra("CONTACTNO",cno);
            i1.putExtra("PASSWORD",pass);
            startActivity(i1);
            finish();

            Intent i2=getIntent();
            tvName.setText(i2.getStringExtra("NAME"));
            tvAge.setText(i2.getIntExtra("AGE",0)+"");
            tvCno.setText(i2.getIntExtra("CONTACTNO",0)+"");
            tvPass.setText(i2.getStringExtra("PASSWORD"));

            btnPrev.setOnClickListener(v -> {
                Intent intent=new Intent(this, exActivity.class);
                startActivity(intent);
            });
            });
    }
}