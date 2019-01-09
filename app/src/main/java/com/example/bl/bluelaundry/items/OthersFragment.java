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

import com.example.bl.bluelaundry.R;
import com.example.bl.bluelaundry.item_detail.ItemDetailActivity;
import com.example.bl.bluelaundry.items.util.ITEM_TYPE;
import com.example.bl.bluelaundry.model.Other;

public class OthersFragment extends Fragment {

    private ListView otherListView;

    public OthersFragment() {
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
        return inflater.inflate(R.layout.fragment_others, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        otherListView = getView().findViewById(R.id.listOther);
        populateData();

        otherListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ItemDetailActivity.class);
                intent.putExtra("ITEM_INDEX", i);
                intent.putExtra("ITEM_TYPE", ITEM_TYPE.OTHER);
                startActivity(intent);
            }
        });
    }

    /**
     * Add other service data to array adapter
     *
     */
    private void populateData() {
        ArrayAdapter<String> arrayAdapterOther = new ArrayAdapter<>(getActivity(), R.layout.list_other, Other.others);
        otherListView.setAdapter(arrayAdapterOther);
    }

}
