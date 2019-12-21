package com.ishan.ocrWithHistory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.ishan.ocrWithHistory.camera.CameraSource;
import com.ishan.ocrWithHistory.camera.CameraSourcePreview;
import com.ishan.ocrWithHistory.others.GraphicOverlay;
import com.ishan.ocrWithHistory.text_detection.TextRecognitionProcessor;
import com.google.firebase.FirebaseApp;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if ( id == R.id.home){
            Toast.makeText(this, "This is Home", Toast.LENGTH_SHORT).show();
        }
        if ( id == R.id.history){
            Toast.makeText(this, "This is History", Toast.LENGTH_SHORT).show();
        }
        if ( id == R.id.ocr){
            Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
            // myIntent.putExtra("key", value); //Optional parameters
            MainActivity.this.startActivity(myIntent);
            Toast.makeText(this, "This is exit", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}


