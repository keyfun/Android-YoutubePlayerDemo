package app.keyfun.youtubeplayerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.examples.youtubeapidemo.DeveloperKey;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.OnFullscreenListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setContentView(R.layout.fragments_demo);

        YouTubePlayerSupportFragment youTubePlayerFragment =
                (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);
        youTubePlayerFragment.initialize(DeveloperKey.DEVELOPER_KEY, this);
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo("nCgQDjiotG0");
        }
        player.setFullscreen(false);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.d(TAG, "onInitializationFailure = " + youTubeInitializationResult);
    }

    @Override
    public void onFullscreen(boolean b) {
        Log.d(TAG, "onFullscreen = " + b);
    }
}
