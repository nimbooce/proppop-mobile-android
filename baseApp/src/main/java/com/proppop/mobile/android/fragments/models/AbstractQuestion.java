package com.proppop.mobile.android.fragments.models;

import java.util.ArrayList;

/**
 * Created by animal@martus.org on 12/9/16.
 */

abstract public class AbstractQuestion
{
    private ArrayList<ChoiceItem> choices;

    public AbstractQuestion()
    {
        choices = new ArrayList<>();
        initChoices();
    }

    public ArrayList<ChoiceItem> getChoices()
    {
        return choices;
    }

    protected void addChoice(ChoiceItem newChoiceItem)
    {
        choices.add(newChoiceItem);
    }

    public String findStatusLabel(String codeToMatch)
    {
        for (ChoiceItem choiceItem : getChoices())
        {
            if (choiceItem.getCode().equals(codeToMatch))
                return choiceItem.getLabel();
        }

        return "";
    }

    abstract protected void initChoices();
}
