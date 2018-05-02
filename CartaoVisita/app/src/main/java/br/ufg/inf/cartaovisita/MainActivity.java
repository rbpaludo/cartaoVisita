package br.ufg.inf.cartaovisita;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playAnimation(View view){
        Glide.with(this).load(R.drawable.pangolin_animation).into((ImageView) view);
        TextView tView = (TextView) findViewById(R.id.loadingText);
        tView.setText("Carregando...");

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Uri uriUrl = Uri.parse("http://endlesstowergame.com");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        }, 2000);
    }

    protected void onStart(Bundle savedInstanceState) {
        super.onStart();
        ImageView imageView = (ImageView) findViewById(R.id.animation);
        imageView.setImageResource(R.drawable.pangolin);
        TextView tView = (TextView) findViewById(R.id.loadingText);
        tView.setText("");
    }
}
