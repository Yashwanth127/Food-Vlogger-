package com.example.food;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddWasteActivity extends AppCompatActivity {

    private EditText typeEditText, quantityEditText, reasonEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_waste);

        typeEditText = findViewById(R.id.typeEditText);
        quantityEditText = findViewById(R.id.QuantityEditText);
        reasonEditText = findViewById(R.id.reasonEditText);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = typeEditText.getText().toString();
                String quantity = quantityEditText.getText().toString();
                String reason = reasonEditText.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("type", type);
                resultIntent.putExtra("quantity", quantity);
                resultIntent.putExtra("reason", reason);
                setResult(RESULT_OK, resultIntent);
                finish(); // Close AddWasteActivity and return to MainActivity
            }
        });
    }
}
