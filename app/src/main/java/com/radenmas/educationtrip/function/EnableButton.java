package com.radenmas.educationtrip.function;

import android.widget.TextView;

public class EnableButton {
    TextView choice1, choice2, choice3, choice4;

    public EnableButton() {
    }

    public EnableButton(TextView choice1, TextView choice2, TextView choice3, TextView choice4) {
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        choice1.setEnabled(true);
        choice2.setEnabled(true);
        choice3.setEnabled(true);
        choice4.setEnabled(true);
    }

    public TextView getChoice1() {
        return choice1;
    }

    public TextView getChoice2() {
        return choice2;
    }

    public TextView getChoice3() {
        return choice3;
    }

    public TextView getChoice4() {
        return choice4;
    }
}
