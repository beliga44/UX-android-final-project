package com.example.bl.bluelaundry.items;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bl.bluelaundry.item_detail.ItemDetailActivity;
import com.example.bl.bluelaundry.R;
import com.example.bl.bluelaundry.items.util.ITEM_TYPE;
import com.example.bl.bluelaundry.model.Cloth;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClothingFragment extends Fragment {

    private ListView clothListView;

    public ClothingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clothing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        clothListView = getView().findViewById(R.id.listCloth);
        populateData();

        clothListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ItemDetailActivity.class);
                intent.putExtra("ITEM_INDEX", i);
                intent.putExtra("ITEM_TYPE", ITEM_TYPE.CLOTHING);
                startActivity(intent);
            }
        });
    }

    /**
     * Add clothes data to array adapter
     *
     */
    private void populateData() {
        ArrayAdapter<String> arrayAdapterClothes = new ArrayAdapter<>(getActivity(), R.layout.list_cloth, Cloth.clothes);
        clothListView.setAdapter(arrayAdapterClothes);
    }
}
