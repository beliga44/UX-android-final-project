package com.example.bl.bluelaundry.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.bl.bluelaundry.R;
import com.example.bl.bluelaundry.model.Carousel;
import com.example.bl.bluelaundry.model.User;

public class HomeFragment extends Fragment {

    private final int INTERVAL = 5000;

    private ViewFlipper imageCarouselViewFlipper;
    private TextView greetingTextView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeComponent();
    }

    private void initializeComponent() {
        imageCarouselViewFlipper = getView().findViewById(R.id.vfImageCarousel);

        for (int i = 0; i < Carousel.images.length; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(Carousel.images[i]);
            imageCarouselViewFlipper.addView(imageView);
        }

        imageCarouselViewFlipper.setFlipInterval(INTERVAL);
        imageCarouselViewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        imageCarouselViewFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
        imageCarouselViewFlipper.setAutoStart(true);

        greetingTextView = getView().findViewById(R.id.tvGreeting);
        greetingTextView.setText("Hello, " + User.name);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
