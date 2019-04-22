package com.wipro.wiproregistrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private DatePicker datePickerBirth;
    private RadioGroup radioGroupGender;
    private EditText editTextAddressOne;
    private EditText editTextAddressTwo;
    private EditText editTextCounty;
    private EditText editTextEircode;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstName = findViewById(R.id.edit_text_first_name);
        editTextLastName = findViewById(R.id.edit_text_last_name);
        editTextEmail = findViewById(R.id.edit_text_email);
        datePickerBirth = findViewById(R.id.date_picker);
        radioGroupGender = findViewById(R.id.radio_group_gender);
        editTextAddressOne = findViewById(R.id.edit_text_address_one);
        editTextAddressTwo = findViewById(R.id.edit_text_address_two);
        editTextCounty = findViewById(R.id.edit_text_county);
        editTextEircode = findViewById(R.id.edit_text_eircode);
        Button buttonRegistration = findViewById(R.id.button_register);
        message = "from MAIN Activity!";

        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWidgetsValidation();
            }
        });
        Log.i("TAG_ACTIVITY_LIFE_CYCLE","ON CREATE " + message);
    }

    // Validate all the user inputs
    private void checkWidgetsValidation() {
        int radioGroupSelectedRadioButtonId = radioGroupGender.getCheckedRadioButtonId();

        if (editTextFirstName.length() < 2 || editTextLastName.length() < 2) {
            showDialogMessage("Provide your Name, please!");
        } else if (!ValidationUtility.isEmailValidFormat(editTextEmail.getText().toString())) {
            showDialogMessage("Provide a Valid Format Email, please!");
        } else if (radioGroupSelectedRadioButtonId == -1) {
            showDialogMessage("Select your Gender, please!");
        } else if (editTextAddressOne.length() < 5 || editTextAddressTwo.length() < 5) {
            showDialogMessage("Provide your Address, please!");
        } else if (editTextCounty.length() < 4 || (!ValidationUtility.isString(editTextCounty.getText().toString()))) {
            showDialogMessage("Provide the County, please!");
        } else if ((editTextEircode.getText().toString().trim()).length() != 7 || (!ValidationUtility.isEircodeValidFormat(editTextEircode.getText().toString()))) {
            showDialogMessage("Provide a correct Eircode, please!");
        } else {
            Button selectedRadioButton = (RadioButton)findViewById(radioGroupSelectedRadioButtonId);

            Log.i("TEST", String.valueOf("*********************\nName: " + editTextFirstName.getText() + " " + editTextLastName.getText() +
                                             "\nEmail: " + editTextEmail.getText() + "\nGender: " + selectedRadioButton.getText().toString() +
                                             "\nDate of Birth: " + datePickerBirth.getDayOfMonth() + "-" + datePickerBirth.getMonth() + "-" + datePickerBirth.getYear() +
                                             "\nAddress: " + editTextAddressOne.getText().toString() + ", " + editTextAddressTwo.getText().toString() +
                                             "\nCounty: " + editTextCounty.getText().toString() + "\nEircode: " + editTextEircode.getText().toString()));

            Intent intent = new Intent(MainActivity.this, LifeCycleActivity.class);
            startActivity(intent);
        }
    }

    // Display the Dialog Box message
    private void showDialogMessage(String message) {
        Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG_ACTIVITY_LIFE_CYCLE","ON START " + message);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG_ACTIVITY_LIFE_CYCLE", "ON PAUSE " + message);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG_ACTIVITY_LIFE_CYCLE", "ON RESUME " + message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG_ACTIVITY_LIFE_CYCLE", "ON STOP " + message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG_ACTIVITY_LIFE_CYCLE", "ON DESTROY " + message);
    }
}
