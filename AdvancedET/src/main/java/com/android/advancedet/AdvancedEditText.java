package com.android.advancedet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedEditText extends androidx.appcompat.widget.AppCompatEditText {

    public AdvancedEditText(@NonNull Context context) {
        super(context);
    }

    public AdvancedEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public AdvancedEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private static final String DEFAULT_NOT_EMPTY = "It cannot be empty!";
    private static final String DEFAULT_MAXIMUM = "Too many characters!";
    private static final String DEFAULT_MINIMUM = "Not enough characters!";
    private static final String DEFAULT_EMAIL = "That's not an email!";
    private static final String DEFAULT_CUSTOM = "It does not match the custom pattern!";

    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.AdvancedEditText);

        typedArray.recycle();
    }

    public void check() {

    }

    /**
     *
     * @param error the error message to be shown in case the string is empty
     * @return false when the string is empty, otherwise true
     */
    public boolean checkNotEmpty(String error) {
        Log.d("oof", "checkEmpty");
        if (Objects.requireNonNull(this.getText().toString().trim()).length() > 0) {
            return true;
        } else {
            this.setError(error);
            return false;
        }
    }

    /**
     *
     * @param num the number of maximum chars allowed in the EditText
     * @param error the error message to be shown in case the amount of chars exceeds num
     * @return false when the amount of chars exceeds num, otherwise true
     */
    public boolean checkMaximum(int num, String error) {
        Log.d("oof", "checkMaximum");
        if (Objects.requireNonNull(this.getText().toString().trim()).length() >= num) {
            this.setError(error);
            return false;
        }
        return true;
    }

    /**
     *
     * @param num the number of minimum chars allowed in the EditText
     * @param error the error message to be shown in case the amount of chars exceeds num
     * @return false when the amount of chars is less than num, otherwise true
     */
    public boolean checkMinimum(int num, String error) {
        Log.d("oof", "checkMinimum");
        if (Objects.requireNonNull(this.getText().toString().trim()).length() <= num) {
            this.setError(error);
            return false;
        }
        return true;
    }

    /**
     *
     * @param error the error message to be shown in case the string inside the EditText does not
     *              match an email address
     * @return false when the string does not match an email address, otherwise true
     */
    public boolean checkEmail(String error) {
        Log.d("oof", "checkEmail");
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher matcher = pattern.matcher(Objects.requireNonNull(this.getText().toString().trim()));
        if (!matcher.matches()) {
            this.setError(error);
            return false;
        }
        return true;
    }

    /**
     *
     * @param custom_pattern your custom pattern to be checked against the text
     * @param error the error message to be shown in case the string inside the EditText does not
     *              match your custom pattern
     * @return false when the string does not match your custom pattern, otherwise true
     */
    public boolean checkCustom(String custom_pattern, String error) {
        Log.d("oof", "checkCustom");
        Pattern pattern = Pattern.compile(custom_pattern);
        Matcher matcher = pattern.matcher(Objects.requireNonNull(this.getText().toString().trim()));
        if (!matcher.matches()) {
            this.setError(error);
            return false;
        }
        return true;
    }
}
