package com.example.bl.bluelaundry.item_detail;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bl.bluelaundry.R;
import com.example.bl.bluelaundry.items.util.ITEM_TYPE;
import com.example.bl.bluelaundry.model.Cloth;
import com.example.bl.bluelaundry.model.Other;

public class ItemDetailActivity extends AppCompatActivity {

    private int ITEM_INDEX;
    private ITEM_TYPE ITEM_TYPE_ENUM;

    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView priceTextView;
    private TextInputEditText quantityEditText;
    private TextInputEditText totalPriceEditText;
    private TextInputLayout quantityTextInputLayout;
    private TextInputLayout totalPriceTextInputLayout;
    private MaterialButton submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        nameTextView = findViewById(R.id.tvName);
        descriptionTextView = findViewById(R.id.tvDescription);
        priceTextView = findViewById(R.id.tvPrice);
        quantityEditText = findViewById(R.id.etQuantity);
        totalPriceEditText = findViewById(R.id.etTotalPrice);
        quantityTextInputLayout = findViewById(R.id.tilQuantity);
        totalPriceTextInputLayout = findViewById(R.id.tilTotalPrice);
        submitButton = findViewById(R.id.btnSubmit);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ITEM_INDEX = extras.getInt("ITEM_INDEX");
            ITEM_TYPE_ENUM = (ITEM_TYPE) extras.get("ITEM_TYPE");

            initializeData();
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int qty = Integer.parseInt(quantityEditText.getText().toString());
                    if (qty < 1) {
                        quantityTextInputLayout.setError("Quantitiy must more than equals 1 !");
                    } else {
                        if (ITEM_TYPE_ENUM == ITEM_TYPE.CLOTHING)
                            totalPriceEditText.setText("Rp. " + (Cloth.prices[ITEM_INDEX] * qty));
                        else
                            totalPriceEditText.setText("Rp. " + (Other.prices[ITEM_INDEX] * qty));

                        Snackbar.make(view, "Item has been Bought !", Snackbar.LENGTH_LONG)
                                .setAction("Success", null).show();
                    }
                } catch (Exception e) {
                    quantityTextInputLayout.setError("Quantitiy must more than equals 1 !");
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeData() {
        switch (ITEM_TYPE_ENUM) {
            case CLOTHING:
                nameTextView.setText(Cloth.clothes[ITEM_INDEX]);
                descriptionTextView.setText(Cloth.descriptions[ITEM_INDEX]);
                priceTextView.setText("Rp. " + Cloth.prices[ITEM_INDEX]);
                break;

            case OTHER:
                nameTextView.setText(Other.others[ITEM_INDEX]);
                descriptionTextView.setText(Other.descriptions[ITEM_INDEX]);
                priceTextView.setText("Rp. " + Other.prices[ITEM_INDEX]);
                break;
        }
    }
}
