package com.example.calculator;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;
import java.util.Random;

import unitConversion.Unit;
import unitConversion.UnitConversion;


public class UnitConverterActivity extends AppCompatActivity {

    private Button clearButton, undoButton, downButton, upButton, positiveNegativeButton, decimalButton,
            numberZeroButton, numberOneButton, numberTwoButton, numberThreeButton, numberFourButton, numberFiveButton,
            numberSixButton, numberSevenButton, numberEightButton, numberNineButton, lengthButton, temperatureButton,
            areaButton, massButton, volumeButton, timeButton, dataButton, speedButton, backToMainButton;
    private Spinner spinnerFirstUnit, spinnerSecondUnit;
    private EditText firstEditText, secondEditText;
    private TextView firstTextSymbol, secondTextSymbol;

    private Unit firstUnit, secondUnit;
    boolean isFirstUnitSelected, isNewSelectedType = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_unit_converter);

        setAllViews();
        setOnClickMethods();
        setFirstUnitSelected(true);
    }

    private void setAllViews() {
        // text
        firstTextSymbol = findViewById(R.id.first_unit);
        secondTextSymbol = findViewById(R.id.second_unit);
        firstEditText = findViewById(R.id.first_unit_text);
        secondEditText = findViewById(R.id.second_unit_text);
        firstEditText.setShowSoftInputOnFocus(false);
        secondEditText.setShowSoftInputOnFocus(false);

        // buttons
        undoButton = findViewById(R.id.undo_button);
        clearButton = findViewById(R.id.clear_button);
        downButton = findViewById(R.id.down_button);
        upButton = findViewById(R.id.up_button);
        backToMainButton = findViewById(R.id.back_button);
        positiveNegativeButton = findViewById(R.id.positive_negative);
        decimalButton = findViewById(R.id.number_decimal);
        numberZeroButton = findViewById(R.id.number_zero);
        numberOneButton = findViewById(R.id.number_one);
        numberTwoButton = findViewById(R.id.number_two);
        numberThreeButton = findViewById(R.id.number_three);
        numberFourButton = findViewById(R.id.number_four);
        numberFiveButton = findViewById(R.id.number_five);
        numberSixButton = findViewById(R.id.number_six);
        numberSevenButton = findViewById(R.id.number_seven);
        numberEightButton = findViewById(R.id.number_eight);
        numberNineButton = findViewById(R.id.number_nine);
        temperatureButton = findViewById(R.id.temperature_button);
        lengthButton = findViewById(R.id.length_button);
        areaButton = findViewById(R.id.area_button);
        massButton = findViewById(R.id.mass_button);
        volumeButton = findViewById(R.id.volume_button);
        timeButton = findViewById(R.id.time_button);
        dataButton = findViewById(R.id.data_button);
        speedButton = findViewById(R.id.speed_button);

        // spinners
        spinnerFirstUnit = findViewById(R.id.spinner_first_unit);
        spinnerSecondUnit = findViewById(R.id.spinner_second_unit);

        UnitConversion.setLengthList();
        setUnitArray();
    }

    private void setOnClickMethods() {
        backToMainButton.setOnClickListener(v -> {
            darkenOnClick(v);
            finish();
        });
        clearButton.setOnClickListener(v -> {
            firstUnit.setValue("");
            secondUnit.setValue("");
            secondEditText.setText("");
            firstEditText.setText("");
        });
        undoButton.setOnClickListener(v -> undoText());

        upButton.setOnClickListener(v -> {
            setFirstUnitSelected(true);
            firstEditText.requestFocus();
            firstEditText.setSelection(firstEditText.length());
        });

        downButton.setOnClickListener(v -> {
            setFirstUnitSelected(false);
            secondEditText.requestFocus();
            secondEditText.setSelection(secondEditText.length());
        });

        firstEditText.setOnClickListener(v -> setFirstUnitSelected(true));
        firstEditText.setOnFocusChangeListener((v, hasFocus) -> setFirstUnitSelected(true));
        secondEditText.setOnClickListener(v -> setFirstUnitSelected(false));
        secondEditText.setOnFocusChangeListener((v, hasFocus) -> setFirstUnitSelected(false));

        spinnerFirstUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                firstUnit = (UnitConversion.getUnitList().get(position));
                firstTextSymbol.setText(firstUnit.getUnitSymbol());
                firstEditText.setText(secondUnit.convert(firstUnit));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(UnitConverterActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerSecondUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                secondUnit = (UnitConversion.getUnitList().get(position));

                // to set value when choosing a new unit type
                if (isNewSelectedType) {
                    int randomNumber = new Random().nextInt(UnitConversion.getUnitList().size() - 1);
                    spinnerSecondUnit.setSelection(randomNumber);
                    setSelectedNumberUnit("1");
                    isNewSelectedType = false;
                }

                secondTextSymbol.setText(secondUnit.getUnitSymbol());
                secondEditText.setText(firstUnit.convert(secondUnit));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(UnitConverterActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
            }
        });

        // numberButton
        onClickAbstraction(positiveNegativeButton, "-");
        onClickAbstraction(decimalButton, ".");
        onClickAbstraction(numberZeroButton, "0");
        onClickAbstraction(numberOneButton, "1");
        onClickAbstraction(numberTwoButton, "2");
        onClickAbstraction(numberThreeButton, "3");
        onClickAbstraction(numberFourButton, "4");
        onClickAbstraction(numberFiveButton, "5");
        onClickAbstraction(numberSixButton, "6");
        onClickAbstraction(numberSevenButton, "7");
        onClickAbstraction(numberEightButton, "8");
        onClickAbstraction(numberNineButton, "9");

        // unitSectionButton
        lengthButton.setOnClickListener(v -> {
            lightenOnSelectedUnit(lengthButton);
            UnitConversion.setLengthList();
            isNewSelectedType = true;
            setUnitArray();
        });
        temperatureButton.setOnClickListener(v -> {
            lightenOnSelectedUnit(temperatureButton);
            UnitConversion.setTemperatureList();
            isNewSelectedType = true;
            setUnitArray();
        });

        areaButton.setOnClickListener(v -> {
            lightenOnSelectedUnit(areaButton);
            UnitConversion.setAreaList();
            isNewSelectedType = true;
            setUnitArray();
        });

        massButton.setOnClickListener(v -> {
            lightenOnSelectedUnit(massButton);
            UnitConversion.setMassList();
            isNewSelectedType = true;
            setUnitArray();
        });

        volumeButton.setOnClickListener(v -> {
            lightenOnSelectedUnit(volumeButton);
            UnitConversion.setVolumeList();
            isNewSelectedType = true;
            setUnitArray();
        });

        speedButton.setOnClickListener(v -> {
            lightenOnSelectedUnit(speedButton);
            UnitConversion.setSpeedList();
            isNewSelectedType = true;
            setUnitArray();
        });

        timeButton.setOnClickListener(v -> {
            lightenOnSelectedUnit(timeButton);
            UnitConversion.setTimeList();
            isNewSelectedType = true;
            setUnitArray();
        });

        dataButton.setOnClickListener(v -> {
            lightenOnSelectedUnit(dataButton);
            UnitConversion.setDataList();
            isNewSelectedType = true;
            setUnitArray();
        });
    }

    // for button that only input value
    private void onClickAbstraction(Button button, String text) {
        button.setOnClickListener(v -> {
            addCurrentText(text);
            darkenOnClick(button);
        });
    }

    public void addCurrentText(String text) {
        if (getSelectedEditText().length() >= 15) {
            Toast.makeText(this, "can't enter more than 15 digits.", Toast.LENGTH_SHORT).show();
            return;
        }

        String currentString = getSelectedEditText().getText().toString();
        int cursorPos = getSelectedEditText().getSelectionStart();

        if (currentString.contains(".") && text.equals(".") || text.equals("-") && currentString.length() == 0)
            return;
        else if (!currentString.contains("-") && text.equals("-")) {
            setSelectedNumberUnit(String.format("-%s", currentString));
            getSelectedEditText().requestFocus();
            getSelectedEditText().setSelection(cursorPos + 1);
            return;
        } else if (currentString.contains("-") && text.equals("-")) {
            setSelectedNumberUnit(currentString.replaceFirst("-", ""));
            getSelectedEditText().requestFocus();
            getSelectedEditText().setSelection(cursorPos - 1);
            return;
        }

        String leftString = currentString.substring(0, cursorPos);
        String rightString = currentString.substring(cursorPos);
        currentString = String.format("%s%s%s", leftString, text, rightString);

        setSelectedNumberUnit(currentString);
        getSelectedEditText().requestFocus();
        getSelectedEditText().setSelection(cursorPos + 1);
    }

    private void undoText() {
        String currentString = getSelectedEditText().getText().toString();
        int cursorPos = getSelectedEditText().getSelectionStart();

        if (cursorPos == 0 || currentString.equals("")) {
            return;
        } else if (currentString.contains("-") && currentString.length() == 2) {
            setSelectedNumberUnit("");
            return;
        } else if (cursorPos == currentString.length()) {
            setSelectedNumberUnit(currentString.substring(0, currentString.length() - 1));
            getSelectedEditText().setSelection(cursorPos - 1);
            return;
        }

        String leftString = currentString.substring(0, cursorPos - 1);
        String rightString = currentString.substring(cursorPos);
        currentString = String.format("%s%s", leftString, rightString);

        setSelectedNumberUnit(currentString);
        getSelectedEditText().requestFocus();
        getSelectedEditText().setSelection(cursorPos - 1);
    }

    private void setUnitArray() {
        firstUnit = (UnitConversion.getUnitList().get(0));
        secondUnit = (UnitConversion.getUnitList().get(0));

        ArrayAdapter<Unit> firstAdapter = new ArrayAdapter<>(this, R.layout.spinner_selected_item, UnitConversion.getUnitList());
        firstAdapter.setDropDownViewResource(R.layout.spinner_items);
        spinnerFirstUnit.setAdapter(firstAdapter);

        ArrayAdapter<Unit> secondAdapter = new ArrayAdapter<>(this, R.layout.spinner_selected_item, UnitConversion.getUnitList());
        secondAdapter.setDropDownViewResource(R.layout.spinner_items);
        spinnerSecondUnit.setAdapter(secondAdapter);
    }

    private void setSelectedNumberUnit(String input) {
        getSelectedUnit().setValue(input);
        getSelectedEditText().setText(input);
        try {
            if (isFirstUnitSelected) {
                secondUnit.setValue(firstUnit.convert(secondUnit));
                secondEditText.setText(secondUnit.getValue());
            } else {
                firstUnit.setValue(secondUnit.convert(firstUnit));
                firstEditText.setText(firstUnit.getValue());
            }
        } catch (Exception error) {
            return;
        }
    }

    private Unit getSelectedUnit() {
        if (isFirstUnitSelected)
            return firstUnit;
        else
            return secondUnit;
    }

    private EditText getSelectedEditText() {
        if (isFirstUnitSelected)
            return firstEditText;
        else
            return secondEditText;
    }

    private void setFirstUnitSelected(boolean bol) {
        isFirstUnitSelected = bol;

        if (isFirstUnitSelected) {
            enableDisableButton(upButton, false);
            enableDisableButton(downButton, true);
        } else {
            enableDisableButton(upButton, true);
            enableDisableButton(downButton, false);
        }
    }

    private void enableDisableButton(Button button, boolean enable) {
        button.setEnabled(enable);
        if (enable)
            button.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
        else
            button.setBackgroundTintMode(PorterDuff.Mode.CLEAR);
    }

    private void darkenOnClick(View view) {
        view.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
        new Thread(() -> runOnUiThread(() -> {
            SystemClock.sleep(100);
            view.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
        })).start();
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void lightenOnSelectedUnit(Button button) {
        areaButton.setBackground(getDrawable(R.drawable.round_button_default));
        lengthButton.setBackground(getDrawable(R.drawable.round_button_default));
        massButton.setBackground(getDrawable(R.drawable.round_button_default));
        speedButton.setBackground(getDrawable(R.drawable.round_button_default));
        temperatureButton.setBackground(getDrawable(R.drawable.round_button_default));
        volumeButton.setBackground(getDrawable(R.drawable.round_button_default));
        timeButton.setBackground(getDrawable(R.drawable.round_button_default));
        dataButton.setBackground(getDrawable(R.drawable.round_button_default));

        button.setBackground(getDrawable(R.drawable.round_button_yellow));
    }

}