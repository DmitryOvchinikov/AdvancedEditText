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
        init(context, attrs);
    }

    public AdvancedEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    //Default values
    private static final String DEFAULT_NOT_EMPTY = "It cannot be empty!";
    private static final String DEFAULT_MAXIMUM = "Too many characters!";
    private static final String DEFAULT_MINIMUM = "Not enough characters!";
    private static final String DEFAULT_EMAIL = "That's not an email!";
    private static final String DEFAULT_CUSTOM = "It does not match the custom pattern!";
    private static final int DEFAULT_MAX = 20;
    private static final int DEFAULT_MIN = 5;
    private static final String DEFAULT_CUSTOM_PATTERN = "[a-zA-Z]*";

    //User-created values
    private String not_empty_error;
    private String maximum_error;
    private String minimum_error;
    private String email_error;
    private String custom_error;
    private boolean check_not_empty;
    private boolean check_maximum;
    private boolean check_minimum;
    private boolean check_email;
    private boolean check_custom;
    private int maximum;
    private int minimum;
    private String custom_pattern;

    //Initializing the attributes
    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AdvancedEditText);
        if (typedArray == null) {
            return;
        }

        if (check_not_empty = typedArray.getBoolean(R.styleable.AdvancedEditText_checkNotEmpty, false)) {
            not_empty_error = typedArray.getString(R.styleable.AdvancedEditText_notEmptyError);
        }

        if (check_maximum = typedArray.getBoolean(R.styleable.AdvancedEditText_checkMaximum, false)) {
            maximum_error = typedArray.getString(R.styleable.AdvancedEditText_maximumError);
        }

        if (check_minimum = typedArray.getBoolean(R.styleable.AdvancedEditText_checkMinimum, false)) {
            minimum_error = typedArray.getString(R.styleable.AdvancedEditText_minimumError);
        }

        if (check_email = typedArray.getBoolean(R.styleable.AdvancedEditText_checkEmail, false)) {
            email_error = typedArray.getString(R.styleable.AdvancedEditText_emailError);
        }

        if (check_custom = typedArray.getBoolean(R.styleable.AdvancedEditText_checkCustom, false)) {
            custom_error = typedArray.getString(R.styleable.AdvancedEditText_customError);
        }

        maximum = typedArray.getInt(R.styleable.AdvancedEditText_maximumNumber, DEFAULT_MAX);
        minimum = typedArray.getInt(R.styleable.AdvancedEditText_minimumNumber, DEFAULT_MIN);
        custom_pattern = typedArray.getString(R.styleable.AdvancedEditText_customPattern);

        typedArray.recycle();
    }

    /**
     * @help a default method to check the EditText according to its XML attributes
     */
    public void check() {
        if (check_not_empty) {
            checkNotEmpty(not_empty_error);
        }
        if (check_maximum) {
            checkMaximum(maximum, maximum_error);
        }
        if (check_minimum) {
            checkMinimum(minimum, minimum_error);
        }
        if (check_email) {
            checkEmail(email_error);
        }
        if (check_custom) {
            checkCustom(custom_pattern, custom_error);
        }
    }

    /**
     * @param error the error message to be shown in case the string is empty
     * @return false when the string is empty, otherwise true
     */
    public boolean checkNotEmpty(String error) {
        if (error == null) {
            error = DEFAULT_NOT_EMPTY;
        }
        Log.d("oof", "checkEmpty");
        if (Objects.requireNonNull(this.getText().toString().trim()).length() > 0) {
            return true;
        } else {
            this.setError(error);
            return false;
        }
    }

    /**
     * @param num   the number of maximum chars allowed in the EditText, defaults to 20
     * @param error the error message to be shown in case the amount of chars exceeds num
     * @return false when the amount of chars exceeds num, otherwise true
     */
    public boolean checkMaximum(int num, String error) {
        if (error == null) {
            error = DEFAULT_MAXIMUM;
        }
        if (num <= 0) {
            num = DEFAULT_MAX;
        }
        Log.d("oof", "checkMaximum");
        if (Objects.requireNonNull(this.getText().toString().trim()).length() >= num) {
            this.setError(error);
            return false;
        }
        return true;
    }

    /**
     * @param num   the number of minimum chars allowed in the EditText, defaults to 5
     * @param error the error message to be shown in case the amount of chars exceeds num
     * @return false when the amount of chars is less than num, otherwise true
     */
    public boolean checkMinimum(int num, String error) {
        if (error == null) {
            error = DEFAULT_MINIMUM;
        }
        if (num <= 0) {
            num = DEFAULT_MIN;
        }
        Log.d("oof", "checkMinimum");
        if (Objects.requireNonNull(this.getText().toString().trim()).length() <= num) {
            this.setError(error);
            return false;
        }
        return true;
    }

    /**
     * @param error the error message to be shown in case the string inside the EditText does not
     *              match an email address
     * @return false when the string does not match an email address, otherwise true
     */
    public boolean checkEmail(String error) {
        if (error == null) {
            error = DEFAULT_EMAIL;
        }
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
     * @param custom_pattern your custom pattern to be checked against the text, defaults to [a-zA-Z]*
     * @param error          the error message to be shown in case the string inside the EditText does not
     *                       match your custom pattern
     * @return false when the string does not match your custom pattern, otherwise true
     */
    public boolean checkCustom(String custom_pattern, String error) {
        if (error == null) {
            error = DEFAULT_CUSTOM;
        }
        if (custom_pattern == null) {
            custom_pattern = DEFAULT_CUSTOM_PATTERN;
        }
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
