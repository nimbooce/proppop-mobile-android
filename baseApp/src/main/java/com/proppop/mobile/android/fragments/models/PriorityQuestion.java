package com.proppop.mobile.android.fragments.models;

import java.util.ArrayList;

/**
 * Created by animal@martus.org on 10/28/16.
 */

public class PriorityQuestion extends AbstractQuestion
{
    protected void initChoices()
    {
        addChoice(new ChoiceItem("", "Unprioritized"));
        addChoice(new ChoiceItem("low", "Low"));
        addChoice(new ChoiceItem("medium", "Medium"));
        addChoice(new ChoiceItem("high", "High"));
        addChoice(new ChoiceItem("urgent", "Urgent"));
    }
}
