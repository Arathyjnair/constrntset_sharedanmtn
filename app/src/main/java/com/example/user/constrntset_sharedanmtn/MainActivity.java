package com.example.user.constrntset_sharedanmtn;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class MainActivity extends AppCompatActivity {


   CircularImageView  imageView;
    TextView txtvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        txtvw=findViewById(R.id.textView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent shared=new Intent(MainActivity.this,Main2Activity.class);
                Pair[] pairs=new Pair[1];
                pairs[0]=new Pair<View,String>(imageView,"shared");
                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(shared,options.toBundle());
            }
        });
    }
}