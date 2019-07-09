package com.wipro.viewmodeldemo;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView name = findViewById(R.id.name);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        Log.e(TAG, "onCreate: MainActivity");
        name.setText(viewModel.getName("MainActivity"));

        Button next = findViewById(R.id.next_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivity = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(secondActivity);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Code : "+viewModel.getName("MainActivity"), Toast.LENGTH_SHORT).show();
    }
}
