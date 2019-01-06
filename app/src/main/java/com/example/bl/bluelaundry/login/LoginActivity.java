package com.example.bl.bluelaundry.login;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bl.bluelaundry.R;
import com.example.bl.bluelaundry.model.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText usernameEditText;
    private TextInputEditText passwordEditText;
    private TextInputLayout usernameInputLayout;
    private TextInputLayout passwordInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.etUsername);
        passwordEditText = findViewById(R.id.etPassword);
        usernameInputLayout = findViewById(R.id.tilUsername);
        passwordInputLayout = findViewById(R.id.tilPassword);
    }

    @Override
    public void onClick(View view) {
    }

    public void loginButtonOnClick(View view) {
        if (hasInvalidInput())
            return;

        clearInputLayout();
        User.name = usernameEditText.getText().toString();

        /**
         * TODO
         * Move to home activity
         */
    }

    private boolean hasInvalidInput() {
        int flag = 0;

        if (usernameEditText.getText().toString().isEmpty()) {
            usernameInputLayout.setError("Username cannot empty !");
            flag = 1;
        }

        if (passwordEditText.getText().toString().isEmpty()) {
            passwordInputLayout.setError("Password cannot empty !");
            flag = 1;
        }

        if (usernameEditText.getText().toString().length() < 5 && !usernameEditText.getText().toString().isEmpty()) {
            usernameInputLayout.setError("Username must be greater than 5 characters !");
            flag = 1;
        }

        return flag == 1;
    }

    private void clearInputLayout() {
        usernameInputLayout.setError(null);
        passwordInputLayout.setError(null);
        usernameEditText.setText(null);
        passwordEditText.setText(null);
    }
}
