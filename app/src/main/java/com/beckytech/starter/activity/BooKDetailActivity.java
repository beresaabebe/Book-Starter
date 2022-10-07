package com.beckytech.starter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.beckytech.starter.R;
import com.beckytech.starter.adapter.BookDetailAdapter;
import com.beckytech.starter.contents.CategoryContents;
import com.beckytech.starter.contents.ImageContents;
import com.beckytech.starter.model.BookDetailModel;
import com.beckytech.starter.model.Model;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class BooKDetailActivity extends AppCompatActivity {

    private List<BookDetailModel> modelList;
    private Model model;
    private final ImageContents imageContents = new ImageContents();
    private final CategoryContents categoryContents = new CategoryContents();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        MobileAds.initialize(this, initializationStatus -> {
        });

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        findViewById(R.id.back_book_detail).setOnClickListener(v -> onBackPressed());

        Intent intent = getIntent();
        model = (Model) intent.getSerializableExtra("data");

        TextView title = findViewById(R.id.title_book_detail);
        title.setSelected(true);
        title.setText(model.getTitle());

        TextView subTitle = findViewById(R.id.subTitle_book_detail);
        subTitle.setText(model.getSubtitle());

        RecyclerView recyclerView = findViewById(R.id.recyclerView_book_detail);
        getData();
        BookDetailAdapter adapter = new BookDetailAdapter(modelList);
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        modelList = new ArrayList<>();
        String category = model.getCategory();
        for (int i = 0; i < categoryContents.category.length; i++) {
            if (categoryContents.category[i].equals(category)) {
                modelList.add(new BookDetailModel(imageContents.image[i]));
            }
        }
    }
}