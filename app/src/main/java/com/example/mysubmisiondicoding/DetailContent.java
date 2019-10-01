package com.example.mysubmisiondicoding;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailContent extends AppCompatActivity {
    private TextView  detail;
    private ImageView imageView;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_content);

        detail = findViewById(R.id.Descripsi);
        imageView = findViewById(R.id.img_item_photo);

        Rumah extra = getIntent().getParcelableExtra("objek");
        detail.setText(extra.getDetail());
        imageView.setImageResource(extra.getPhoto());
    }
}
