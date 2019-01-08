package com.example.bl.bluelaundry.model;

import com.example.bl.bluelaundry.R;

public class Carousel {
    private int[] images = {
            R.drawable.laundry,
            R.drawable.clothes,
            R.drawable.iron_carousel,
            R.drawable.deliv
    };

    public int getImages(int idx) {
        return images[idx];
    }

    public int imagesSize() {
        return images.length;
    }
}
