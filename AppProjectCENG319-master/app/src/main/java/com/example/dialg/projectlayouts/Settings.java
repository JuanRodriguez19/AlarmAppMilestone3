package com.example.dialg.projectlayouts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Toast;

public class Settings extends AppCompatActivity implements View.OnClickListener {

    SwitchCompat colorSwitch;
    boolean stateSwitch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        findViewById(R.id.check).setOnClickListener(this);
        findViewById(R.id.aboutus).setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Settings");

        final SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        stateSwitch1 = preferences.getBoolean("switch1", false);

        colorSwitch = (SwitchCompat) findViewById(R.id.color_switch);

        colorSwitch.setChecked(stateSwitch1);

        colorSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch1 = !stateSwitch1;
                colorSwitch.setChecked(stateSwitch1);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch1", stateSwitch1);
                editor.apply();
            }
        });
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.check:
                Toast.makeText(getApplicationContext(),"No update required", Toast.LENGTH_SHORT).show();
                break;

            case R.id.aboutus:
                startActivity(new Intent(this, AboutUs.class));

                break;
        }
    }
}
