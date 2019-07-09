package com.wipro.viewmodeldemo;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        TextView textView = findViewById(R.id.name2);
        Log.e(TAG, "onCreate: SecondActivity");
        textView.setText(viewModel.getName("SecondActivity"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
