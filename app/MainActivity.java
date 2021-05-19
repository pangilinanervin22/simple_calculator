package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.*;

import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static Button parenthesisButton, percentButton, equalButton, clearTextButton, positiveNegativeButton, redoButton, divisionButton,
            multiplicationButton, additionButton, subtractionButton, numberOneButton, numberTwoButton, numberThreeButton, numberFourButton,
            numberFiveButton, numberSixButton, numberSevenButton, numberEightButton, numberNineButton, numberZeroButton, DecimalButton,
            restoreListButton, converterStartButton, clearHistory;

    private static TextView currentText, answerText;
    private RelativeLayout restoreSection;
    private final RestoreListAdapter adapter = new RestoreListAdapter(this);

    public static LinkedList<ListRestore> restorePoints = new LinkedList<>();
    private final static StringManipulation stringManipulation = new StringManipulation();
    public static String currentString = "";
    private static int lengthToResize;
    private boolean isRestoreSectionClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);


        // main start
        setAllViews();
        onClickAction();
    }

    private void setAllViews() {
        // layout
        RecyclerView restoreList = findViewById(R.id.restore_list);
        restoreSection = findViewById(R.id.restore_section);

        //text
        currentText = findViewById(R.id.current_text);
        answerText = findViewById(R.id.answer_result);

        // button
        converterStartButton = findViewById(R.id.converter_start_button);
        clearHistory = findViewById(R.id.clear_history);
        restoreListButton = findViewById(R.id.restore_button);
        parenthesisButton = findViewById(R.id.parenthesis_button);
        percentButton = findViewById(R.id.modulo_sign);
        equalButton = findViewById(R.id.equal_sign);
        clearTextButton = findViewById(R.id.clear_button);
        positiveNegativeButton = findViewById(R.id.positive_negative);
        redoButton = findViewById(R.id.redo_button);
        divisionButton = findViewById(R.id.division_sign);
        multiplicationButton = findViewById(R.id.multiplication_sign);
        additionButton = findViewById(R.id.addition_sign);
        subtractionButton = findViewById(R.id.subtraction_sign);
        numberOneButton = findViewById(R.id.number_one);
        numberTwoButton = findViewById(R.id.number_two);
        numberThreeButton = findViewById(R.id.number_three);
        numberFourButton = findViewById(R.id.number_four);
        numberFiveButton = findViewById(R.id.number_five);
        numberSixButton = findViewById(R.id.number_six);
        numberSevenButton = findViewById(R.id.number_seven);
        numberEightButton = findViewById(R.id.number_eight);
        numberNineButton = findViewById(R.id.number_nine);
        numberZeroButton = findViewById(R.id.number_zero);
        DecimalButton = findViewById(R.id.number_decimal);

        // set adapter
        adapter.setItemLinkedList(restorePoints);
        restoreList.setAdapter(adapter);
        restoreList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }


    //  all onclick method
    @SuppressLint("UseCompatLoadingForDrawables")
    private void onClickAction() {
        // operation buttons
        onClickAbstraction(percentButton, "%");
        onClickAbstraction(subtractionButton, " – ");  // "–" em dash for minus sign
        onClickAbstraction(additionButton, " + ");
        onClickAbstraction(multiplicationButton, " × ");
        onClickAbstraction(divisionButton, " ÷ ");
        onClickAbstraction(positiveNegativeButton, "-");  // "–" hyphen for negative value

        // number buttons
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

        //special buttons
        parenthesisButton.setOnClickListener(v -> {
            darkenOnClick(parenthesisButton);
            String temp = stringManipulation.addingParenthesis(currentString);
            addCurrentText(temp);
        });

        DecimalButton.setOnClickListener(v -> {
            darkenOnClick(DecimalButton);
            String temp = stringManipulation.addingDecimal(currentString);
            addCurrentText(temp);
        });

        clearTextButton.setOnClickListener(v -> {
            darkenOnClick(clearTextButton);
            clearCurrentText();
        });

        redoButton.setOnClickListener(v -> {
            darkenOnClick(redoButton);
            undoCurrentText();
        });

        equalButton.setOnClickListener(v -> {
            darkenOnClick(equalButton);

            String temp = answerText.getText().toString();
            if (temp.equals(getString(R.string.creator_string)) ||  temp.equals("") || !stringManipulation.checkSyntaxAnswer(currentString).equals(""))
                return;

            currentString = stringManipulation.cleanUpParenthesis(currentString);

            addToRestoreList(currentString, temp);
            clearCurrentText();
            addCurrentText(temp);
        });

        clearHistory.setOnClickListener(v -> {
            restorePoints.clear();
            darkenOnClick(clearHistory);
            adapter.setItemLinkedList(restorePoints);
        });

        restoreListButton.setOnClickListener(v -> {
            if (isRestoreSectionClick) {
                restoreSection.setVisibility(View.VISIBLE);
                restoreListButton.setBackground(getDrawable(R.drawable.ic_calculate));
            } else {
                restoreSection.setVisibility(View.GONE);
                restoreListButton.setBackground(getDrawable(R.drawable.ic_restore));
            }
            isRestoreSectionClick = !isRestoreSectionClick;
        });

        converterStartButton.setOnClickListener(v -> startActivity(new Intent(this, UnitConverterActivity.class)));
    }

    // for button that input number
    private void onClickAbstraction(Button button, String text) {
        button.setOnClickListener(v -> {
            darkenOnClick(button);
            addCurrentText(text);
        });
    }

    private void darkenOnClick(View view) {
        view.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
        new Thread(() -> runOnUiThread(() -> {
            SystemClock.sleep(100);
            view.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
        })).start();
    }

    // special methods for edit text
    public static void addCurrentText(String text) {
        setCurrentString(text);
        setAnswerText(currentString);
    }

    private static void setCurrentString(String text) {
        currentString = stringManipulation.updateCurrentString(currentString, text);
        currentText.setText(currentString);
        textResize();
    }

    private static void setAnswerText(String text) {
        String temp = stringManipulation.calculateText(text);
        if (temp.equals(stringManipulation.checkSyntaxAnswer(temp))) {
            answerText.setText(temp);
            return;
        }

        answerText.setText("");
    }

    private void clearCurrentText() {
        currentString = "";
        setAnswerText("");
        currentText.setText("");
    }

    private void undoCurrentText() {
        if (currentString.equals(""))
            return;

        String temp = stringManipulation.removeLogic(currentString);
        clearCurrentText();
        addCurrentText(temp);
    }

    private static void textResize() {
        if (currentString.length() < 20) {
            currentText.setTextSize(45);
            lengthToResize = 20;
        } else if (currentString.length() > lengthToResize) {
            currentText.setTextSize(currentText.getTextSize() / 3);
            lengthToResize += 20;
        }
    }

    public boolean checkLinkedListContain(String currentString, String answer) {
        boolean isSameAnswer = false;
        boolean isSameCurrent = false;
        for (ListRestore restore : restorePoints) {
            System.out.println(isSameAnswer);
            isSameAnswer = restore.getAnswer_text().equals(answer);
            isSameCurrent = restore.getPrevious_text().equals(currentString);

            if (isSameAnswer && isSameCurrent)
                return isSameAnswer && isSameCurrent;
        }
        return isSameAnswer && isSameCurrent;
    }

    public void addToRestoreList(String currentString, String answer) {
        if (!currentString.equals(answer) && !checkLinkedListContain(currentString, answer)) {
            restorePoints.add(new ListRestore(currentString, answer));
            if (restorePoints.size() > 10)
                restorePoints.removeFirst();
            adapter.setItemLinkedList(restorePoints);
        }
    }

}