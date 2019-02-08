package com.example.user.constrntset_sharedanmtn;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class Main2Activity extends AppCompatActivity {
    CircularImageView imageView;
    ImageView imgg;
    TextView txtvw;
    boolean[] isOpen = {false};
    ConstraintSet oldlayout1,newlayout2;
    ConstraintLayout constraintlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView=findViewById(R.id.imageView);
        imgg=findViewById(R.id.imageeee);
        txtvw=findViewById(R.id.textView);
//        Window w=getWindow();
//        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        oldlayout1 = new ConstraintSet();
        newlayout2 = new ConstraintSet();
        constraintlayout =findViewById(R.id.con1);
        newlayout2.clone(this,R.layout.activity_main3);
        oldlayout1.clone(constraintlayout);
        imgg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(!isOpen[0])
                {
                    TransitionManager.beginDelayedTransition(constraintlayout);
                    newlayout2.applyTo(constraintlayout);
                    isOpen[0] =!isOpen[0];
                }
                else {

                    TransitionManager.beginDelayedTransition(constraintlayout);
                    oldlayout1.applyTo(constraintlayout);
                    isOpen[0] = !isOpen[0];

                }
            }
        });
    }
}
