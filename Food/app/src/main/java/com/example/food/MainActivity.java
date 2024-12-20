package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.food.WasteItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<WasteItem> wasteList;
    private WasteAdapter wasteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wasteList = new ArrayList<>();
        wasteAdapter = new WasteAdapter(this, wasteList);

        ListView wasteListView = findViewById(R.id.wasteListView);
        wasteListView.setAdapter(wasteAdapter);

        Button addWasteButton = findViewById(R.id.addWasteButton);
        addWasteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddWasteActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Get the waste details from AddWasteActivity
            String type = data.getStringExtra("type");
            String quantity = data.getStringExtra("quantity");
            String reason = data.getStringExtra("reason");

            // Add to waste list and update the adapter
            wasteList.add(new WasteItem(type, quantity, reason));
            wasteAdapter.notifyDataSetChanged(); // Refresh the ListView
        }
    }
}
