package com.sina.credit.binnertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sinaflashmoney.credit.sina.com.mylibrary.banner.AccordionTransformer;
import sinaflashmoney.credit.sina.com.mylibrary.banner.Banner;
import sinaflashmoney.credit.sina.com.mylibrary.banner.GlideImageLoader;
import sinaflashmoney.credit.sina.com.mylibrary.banner.OnBannerListener;

public class MainActivity extends AppCompatActivity implements OnBannerListener {

    private Banner banner;
    public static List<?> images=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] urls = getResources().getStringArray(R.array.url);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);

        banner = (Banner) findViewById(R.id.banner);
        banner.setBannerAnimation(AccordionTransformer.class);
        banner.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getApplicationContext(),"你点击了："+position,Toast.LENGTH_SHORT).show();
    }


}
