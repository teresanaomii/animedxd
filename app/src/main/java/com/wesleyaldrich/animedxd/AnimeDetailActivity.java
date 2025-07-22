package com.wesleyaldrich.animedxd;

import android.app.AlertDialog;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class AnimeDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ANIME_TITLE = "extra_anime_title";
    public static final String EXTRA_ANIME_SYNOPSIS = "extra_anime_description";
    public static final String EXTRA_ANIME_GENRE = "extra_anime_genre";
    public static final String EXTRA_ANIME_IMAGE = "extra_anime_image";

    private Button btnReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);

        ImageView customBackButton = findViewById(R.id.customBackButton);
        ImageView detailAnimeImageView = findViewById(R.id.detailAnimeImageView);
        TextView detailAnimeTitleTextView = findViewById(R.id.detailAnimeTitleTextView);
        TextView detailAnimeGenreTextView = findViewById(R.id.detailAnimeGenreTextView);
        TextView detailAnimeDescriptionTextView = findViewById(R.id.detailAnimeDescriptionTextView);
        btnReview = findViewById(R.id.btnReview);

        customBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnReview.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(AnimeDetailActivity.this, R.color.light_blue)));
                showReviewDialog();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String title = extras.getString(EXTRA_ANIME_TITLE);
            String synopsis = extras.getString(EXTRA_ANIME_SYNOPSIS);
            String genre = extras.getString(EXTRA_ANIME_GENRE);
            int imageResId = extras.getInt(EXTRA_ANIME_IMAGE);

            detailAnimeTitleTextView.setText(title);
            detailAnimeDescriptionTextView.setText(synopsis);
            detailAnimeGenreTextView.setText(genre);
            detailAnimeImageView.setImageResource(imageResId);
        }
    }

    private void showReviewDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.pop_up_review, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setCancelable(true);
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        ImageView btnClose = dialogView.findViewById(R.id.btnCloseReviewDialog);
        EditText etReviewInput = dialogView.findViewById(R.id.etReviewInput);
        Button btnSend = dialogView.findViewById(R.id.btnSendReview);
        TextView tvReviewSuccessMessage = dialogView.findViewById(R.id.tvReviewSuccessMessage);
        TextView tvReviewWarning = dialogView.findViewById(R.id.tvReviewWarning);

        btnSend.setEnabled(true);
        btnSend.setAlpha(1.0f);
        tvReviewWarning.setVisibility(View.INVISIBLE);

        etReviewInput.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvReviewWarning.setVisibility(View.GONE);
            }

            @Override public void afterTextChanged(Editable s) {}
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                btnReview.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(AnimeDetailActivity.this, R.color.blue)));
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ReviewDialog", "Tombol SEND diklik!");
                String reviewText = etReviewInput.getText().toString().trim();

                if (reviewText.isEmpty()) {
                    Log.d("ReviewDialog", "Review kosong. Menampilkan warning.");
                    tvReviewWarning.setVisibility(View.VISIBLE);
                } else {
                    Log.d("ReviewDialog", "Review diisi. Mengirim review.");
                    tvReviewWarning.setVisibility(View.GONE);

                    btnSend.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(AnimeDetailActivity.this, R.color.light_blue)));
                    Toast.makeText(AnimeDetailActivity.this, "Review sent: " + reviewText, Toast.LENGTH_SHORT).show();

                    tvReviewSuccessMessage.setVisibility(View.VISIBLE);
                    etReviewInput.setEnabled(false);
                    btnSend.setEnabled(false);
                    btnSend.setAlpha(0.5f);

                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    alertDialog.dismiss();
                                    btnReview.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(AnimeDetailActivity.this, R.color.blue)));
                                }
                            }, 1000
                    );
                }
            }
        });

        alertDialog.setOnDismissListener(dialog -> {
            btnReview.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(AnimeDetailActivity.this, R.color.blue)));
        });

        alertDialog.show();
    }

}