package com.shindejayesharun.receivingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Intent intent=getIntent();
        String action=intent.getAction();
        if(!action.equals(Intent.ACTION_MAIN)) {
            String type = intent.getType();

            ImageView img = findViewById(R.id.imageView);
            if (intent.getAction() != null || Intent.ACTION_SEND.equals(action)) {
                switch (type) {
                    case "text/plain":
                        String text = intent.getStringExtra(Intent.EXTRA_TEXT);
                        Toast.makeText(this, "Text:- " + text, Toast.LENGTH_SHORT).show();
                        break;
                    case "image/jpeg":
                        Uri uri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                        img.setImageURI(uri);
                        break;
                }
            } else if (Intent.ACTION_SEND_MULTIPLE.equals(action)) {
                ArrayList<Uri> uris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                img.setImageURI(uris.get(0));
            }
        }
    }
}
