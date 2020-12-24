package com.example.homedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CarouselView carouselView;
    private int[] images = new int[] {
        R.drawable.banner1, R.drawable.banner2, R.drawable.banner3
    };
    private RecyclerView rcv;
    private ArrayList<Store> arrStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        createCarousel();
        loadData();
    }

    public void addControl() {
        carouselView = findViewById(R.id.carousel);
        rcv = findViewById(R.id.rcv);
    }

    public void createCarousel() {
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        });
    }

    public void loadData() {
        arrStore = new ArrayList<>();
        arrStore.add(new Store("Cửa hàng 1", "Địa chỉ 1",R.drawable.s1));
        arrStore.add(new Store("Cửa hàng 2", "Địa chỉ 2",R.drawable.s2));
        arrStore.add(new Store("Cửa hàng 3", "Địa chỉ 3",R.drawable.s3));
        arrStore.add(new Store("Cửa hàng 4", "Địa chỉ 1",R.drawable.s4));

        StoreAdapter adapter = new StoreAdapter(getApplicationContext(), arrStore);
        rcv.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rcv.setAdapter(adapter);
    }
}