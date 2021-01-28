package com.tza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sarnava.textwriter.TextWriter;

public class Splashscreen extends AppCompatActivity {

    TextWriter textWriter;
    Animation fade_animation;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        textWriter =findViewById(R.id.textWriter);
        fade_animation = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        textWriter.setAnimation(fade_animation);
        img = findViewById(R.id.imageView);
        img.setAnimation(fade_animation);

        Glide.with(this).load(R.raw.animation).into(img);
        textWriter
                .setWidth(12)
                .setDelay(30)
                .setColor(Color.RED)
                .setConfig(TextWriter.Configuration.INTERMEDIATE)
                .setSizeFactor(30f)
                .setLetterSpacing(25f)
                .setText("WELCOME")
                .setListener(new TextWriter.Listener() {
                    @Override
                    public void WritingFinished() {
                        Intent intent = new Intent(Splashscreen.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        //do stuff after animation is finished
                    }
                })
                .startAnimation();
    }
}