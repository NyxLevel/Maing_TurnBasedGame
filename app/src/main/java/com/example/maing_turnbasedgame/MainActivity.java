package com.example.maing_turnbasedgame;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    JUV juv;
    GRF grf;
    Controller system;
    TextView juvhealth, grfhealth,juvmana,grfmana, announce, damage;
    ImageView btnskill, btnnext;
    MediaPlayer bgm, sfx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        juv= new JUV();
        grf= new GRF();
        system= new Controller();
        juvhealth = findViewById(R.id.juvhp);
        grfhealth = findViewById(R.id.grfhp);
        juvmana = findViewById(R.id.juvmp);
        grfmana = findViewById(R.id.grfmp);
        announce = findViewById(R.id.announce);
        damage = findViewById(R.id.damage);
        btnskill = findViewById(R.id.btnskill);
        btnnext = findViewById(R.id.btnnext);
        btnskill.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        displayChanges();
        enableFullscreen();
        damage.setVisibility(View.INVISIBLE);
        bgm = MediaPlayer.create(this, R.raw.bgm);
        sfx = MediaPlayer.create(this,R.raw.sfx);
        bgm.setVolume(15,15);
        sfx.setVolume(100,100);
        bgm.setLooping(true);
        bgm.start();
    }

    public void displayChanges(){
        juvhealth.setText(String.valueOf(juv.getHealth()));
        grfhealth.setText(String.valueOf(grf.getHealth()));
        juvmana.setText(String.valueOf(juv.getMana()));
        grfmana.setText(String.valueOf(grf.getMana()));
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnskill:
                sfx.start();
                system.skill(announce,damage,btnskill,btnnext,juv,grf);
                break;
            case R.id.btnnext:
                system.Turn(announce,damage,btnskill,btnnext,juv,grf);
                break;
            //case R.id.btnrestart:
        }
            displayChanges();
    }
    private void enableFullscreen() {
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            );
        }
    }
}