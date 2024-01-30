package wanpiece.wall.paper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.io.IOException;

public class FullImageActivity extends AppCompatActivity {


    private ImageView fullImage, backbtn;
    private Button apply;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        fullImage = findViewById(R.id.fullImage);
        apply = findViewById(R.id.apply);
        backbtn = findViewById(R.id.backbtn);

        Picasso.get().load(getIntent().getStringExtra("Image")).into(fullImage);
        apply.setOnClickListener(v -> {
            setBackground();
            Toast.makeText(getApplicationContext(), "Wallpaper Applied", Toast.LENGTH_SHORT).show();
        });
        backbtn.setOnClickListener(v -> FullImageActivity.super.onBackPressed());
    }

    private void setBackground(){
        Bitmap bitmap = ((BitmapDrawable)fullImage.getDrawable()).getBitmap();
        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
        try {
            manager.setBitmap(bitmap);
        } catch (IOException e) {
            Toast.makeText(this,"Error :"+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


}