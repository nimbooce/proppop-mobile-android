package com.proppop.mobile.android.fragments.models;

/**
 * Created by animal@martus.org on 10/28/16.
 */

public class ChoiceItem {

    private String code;
    private String label;

    public ChoiceItem(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
