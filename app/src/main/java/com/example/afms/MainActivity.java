package com.example.afms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.afms.databinding.ActivityMainBinding;
import com.github.tutorialsandroid.appxupdater.AppUpdater;
import com.github.tutorialsandroid.appxupdater.enums.Display;
import com.github.tutorialsandroid.appxupdater.enums.UpdateFrom;

public class MainActivity extends AppCompatActivity {

    //Context
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.mContext = this;
        setSupportActionBar(binding.toolbar);
		
        binding.fab.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://veereport.in/opapp/"))));

        binding.included.dialogUpdateChangelog.setOnClickListener(view -> new AppUpdater(mContext)
                .setUpdateFrom(UpdateFrom.JSON)
                .setUpdateXML("https://raw.githubusercontent.com/kombiahrk/AFMS-App/master/update.xml")
                .setDisplay(Display.DIALOG)
                .showAppUpdated(true)
                .start());

        binding.included.dialogUpdate.setOnClickListener(view -> new AppUpdater(mContext)
                .setUpdateFrom(UpdateFrom.JSON)
                .setUpdateXML("https://raw.githubusercontent.com/kombiahrk/AFMS-App/master/update.xml")
                .setDisplay(Display.DIALOG)
                .showAppUpdated(true)
                .start());

        binding.included.snackbarUpdate.setOnClickListener(view -> new AppUpdater(mContext)
                .setUpdateFrom(UpdateFrom.XML)
                .setUpdateXML("https://raw.githubusercontent.com/kombiahrk/AFMS-App/master/update.xml")
                .setDisplay(Display.SNACKBAR)
                .showAppUpdated(true)
                .start());

        binding.included.notificationUpdate.setOnClickListener(view -> new AppUpdater(mContext)
                .setUpdateFrom(UpdateFrom.XML)
                .setUpdateXML("https://raw.githubusercontent.com/kombiahrk/AFMS-App/master/update.xml")
                .setDisplay(Display.NOTIFICATION)
                .showAppUpdated(true)
                .start());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}