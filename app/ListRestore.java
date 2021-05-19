package com.example.project;

import androidx.annotation.Nullable;

public class ListRestore {

    private String previous_text;
    private String answer_text;

    public ListRestore(String previous_text, String answer_text) {
        this.previous_text = previous_text;
        this.answer_text = answer_text;
    }

    public String getPrevious_text() {
        return previous_text;
    }

    public void setPrevious_text(String previous_text) {
        this.previous_text = previous_text;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

}
