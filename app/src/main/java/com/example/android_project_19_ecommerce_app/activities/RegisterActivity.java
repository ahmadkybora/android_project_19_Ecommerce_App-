package com.example.android_project_19_ecommerce_app.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android_project_19_ecommerce_app.R;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.Min;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;
import com.mobsandgeeks.saripaar.annotation.Url;

import java.util.List;

public class RegisterActivity extends AppCompatActivity implements Validator.ValidationListener {
    private EditText ed_first_name;
    private EditText ed_last_name;
    private EditText ed_username;
    private EditText ed_email;
    private EditText ed_mobile;
    private EditText ed_home_phone;
    private EditText ed_password;
    private EditText ed_confirmation_password;
    private EditText ed_home_address;
    private EditText ed_work_address;
    private Button btn_login;

    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        validator = new Validator(this);
    }

    private void initViews() {
        ed_first_name = findViewById(R.id.ed_first_name);
        ed_last_name = findViewById(R.id.ed_last_name);
        ed_username = findViewById(R.id.ed_username);
        ed_email = findViewById(R.id.ed_email);
        ed_mobile = findViewById(R.id.ed_mobile);
        ed_home_phone = findViewById(R.id.ed_home_phone);
        ed_home_address = findViewById(R.id.ed_home_address);
        ed_work_address = findViewById(R.id.ed_work_address);
        ed_password = findViewById(R.id.ed_password);
        ed_confirmation_password = findViewById(R.id.ed_confirmation_password);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
                String username = ed_username.getText().toString();
                if (username.equalsIgnoreCase("pmk")) {
                    ed_username.setError(getText(R.string.username_already_exists));
                }
            }
        });
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "we can", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}