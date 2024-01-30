package wanpiece.wall.paper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.VideoView;



/** @noinspection ALL*/
public class LoadingUI extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024,1024);
        setContentView(R.layout.activity_loading_ui);




        mediaPlayer = MediaPlayer.create(this, R.raw.mp3music);
        mediaPlayer.start();

        VideoView splash = findViewById(R.id.videoView);
        Uri splashFile = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);
        splash.setVideoURI(splashFile);
        splash.start();

        new Handler().postDelayed(() -> {
            splash.stopPlayback();
            splash.setVisibility(View.GONE);

            Intent appContent = new Intent(LoadingUI.this, MainActivity.class);
            appContent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(appContent);
        }, 5400);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the media player when the activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
