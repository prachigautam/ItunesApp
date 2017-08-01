package com.prachigautam.itunesapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {

    TextView tvTrackName;
    TextView tvArtistName;
    TextView tvGenreName;
    TextView tvDuration;
    TextView tvTrackPrice;
    CircleImageView imgArtwork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getCOntrols();
    }

    private void getCOntrols() {
        tvTrackName = (TextView) findViewById(R.id.tvTrackName);
        tvArtistName = (TextView) findViewById(R.id.tvArtistName);
        tvGenreName = (TextView) findViewById(R.id.tvGenreName);
        tvDuration = (TextView) findViewById(R.id.tvDuration);
        tvTrackPrice = (TextView) findViewById(R.id.tvTrackPrice);
        imgArtwork = (CircleImageView) findViewById(R.id.imgArtwork);

        getData();
    }

    private void getData() {
        MusicPojo.Results result = (MusicPojo.Results) getIntent().getSerializableExtra("result");

        if (result != null) {

            tvArtistName.setText(result.getArtistName());
            tvTrackName.setText(result.getTrackName());
            tvGenreName.setText(result.getPrimaryGenreName());
            tvDuration.setText(String.valueOf(result.getTrackTimeMillis()));
            tvTrackPrice.setText(String.valueOf(result.getTrackPrice()));

            if ((result.getArtworkUrl100() != null) && (result.getArtworkUrl100().length() > 0)) {
                Uri uri = Uri.parse(result.getArtworkUrl100());

                Glide.with(DetailsActivity.this)
                        .load(uri)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(imgArtwork);

            } else if ((result.getArtworkUrl100() == null) || (result.getArtworkUrl100().length() == 0)) {
                Glide.with(DetailsActivity.this)
                        .load(R.drawable.music).
                        diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(imgArtwork);
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
