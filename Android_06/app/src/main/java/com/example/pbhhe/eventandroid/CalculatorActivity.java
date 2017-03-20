package com.example.pbhhe.eventandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextDisplay;
    private TextView mTextInput;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton0;
    private Button mButtonDiv;
    private Button mButtonDelete;
    private Button mButtonMul;
    private Button mButtonSub;
    private Button mButtonAdd;
    private Button mButtonEqual;
    private Button mButtonDot;
    private char mOperation;
    private boolean mIsFloat = false;
    private float mNum1;
    private float mNum2;
    private float mRes;
    private TextView mTextOperation;
    private boolean mIsSetOperation = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        mTextDisplay = (TextView) findViewById(R.id.text_display);
        mTextInput = (TextView) findViewById(R.id.text_input);
        mButton0 = (Button) findViewById(R.id.button_0);
        mButton1 = (Button) findViewById(R.id.button_1);
        mButton2 = (Button) findViewById(R.id.button_2);
        mButton3 = (Button) findViewById(R.id.button_3);
        mButton4 = (Button) findViewById(R.id.button_4);
        mButton5 = (Button) findViewById(R.id.button_5);
        mButton6 = (Button) findViewById(R.id.button_6);
        mButton7 = (Button) findViewById(R.id.button_7);
        mButton8 = (Button) findViewById(R.id.button_8);
        mButton9 = (Button) findViewById(R.id.button_9);
        mButtonDelete = (Button) findViewById(R.id.button_delete);
        mButtonDiv = (Button) findViewById(R.id.button_div);
        mButtonMul = (Button) findViewById(R.id.button_mul);
        mButtonSub = (Button) findViewById(R.id.button_sub);
        mButtonAdd = (Button) findViewById(R.id.button_add);
        mButtonEqual = (Button) findViewById(R.id.button_equal);
        mButtonDot = (Button) findViewById(R.id.button_dot);
        mTextOperation = (TextView) findViewById(R.id.text_operation);
        mButton0.setOnClickListener(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButtonDelete.setOnClickListener(this);
        mButtonDiv.setOnClickListener(this);
        mButtonMul.setOnClickListener(this);
        mButtonSub.setOnClickListener(this);
        mButtonAdd.setOnClickListener(this);
        mButtonEqual.setOnClickListener(this);
        mButtonDot.setOnClickListener(this);
        mTextOperation.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_0:
                if(mTextInput.getText().length()<1) {
                    break;
                }
                else {
                    mTextInput.setText(mTextInput.getText() + "0");
                }
                break;
            case R.id.button_1:
                mTextInput.setText(mTextInput.getText()+"1");
                break;
            case R.id.button_2:
                mTextInput.setText(mTextInput.getText()+"2");
                break;
            case R.id.button_3:
                mTextInput.setText(mTextInput.getText()+"3");
                break;
            case R.id.button_4:
                mTextInput.setText(mTextInput.getText()+"4");
                break;
            case R.id.button_5:
                mTextInput.setText(mTextInput.getText()+"5");
                break;
            case R.id.button_6:
                mTextInput.setText(mTextInput.getText()+"6");
                break;
            case R.id.button_7:
                mTextInput.setText(mTextInput.getText()+"7");
                break;
            case R.id.button_8:
                mTextInput.setText(mTextInput.getText()+"8");
                break;
            case R.id.button_9:
                mTextInput.setText(mTextInput.getText()+"9");
                break;
            case R.id.button_delete:
                for(int i = 0; i < mTextInput.getText().length() - 1; i++) {
                    if ((int) mTextInput.getText().charAt(i) == (int) '.') {
                        mIsFloat = false;
                    }
                }
                if (mTextInput.getText().length() > 0) {
                    mTextInput.setText(mTextInput.getText().subSequence(0, mTextInput.getText().length() - 1));
                }
                break;
            case R.id.button_dot:
                if(!mIsFloat) {
                    mTextInput.setText(mTextInput.getText() + ".");
                    mIsFloat = true;
                }
                break;
            case R.id.button_div:
                mOperation = '/';
                if (mTextInput.getText().length() > 0) {
                    mTextDisplay.setText(mTextInput.getText());
                    mTextInput.setText("");
                    mTextOperation.setText("/");
                    mIsFloat = false;
                    mIsSetOperation = true;
                }
                else{
                    mTextDisplay.setText(mTextDisplay.getText());
                }
                break;
            case R.id.button_mul:
                mOperation = '*';
                mTextOperation.setText("x");
                mIsFloat = false;
                mIsSetOperation = true;
                if (mTextInput.getText().length() > 0) {
                    mTextDisplay.setText(mTextInput.getText());
                    mTextInput.setText("");
                }
                else{
                    mTextDisplay.setText(mTextDisplay.getText());
                }
                break;
            case R.id.button_sub:
                mOperation = '-';
                mTextOperation.setText("-");
                mIsFloat = false;
                mIsSetOperation = true;
                if (mTextInput.getText().length() > 0) {
                    mTextDisplay.setText(mTextInput.getText());
                    mTextInput.setText("");
                }
                break;
            case R.id.button_add:
                mOperation = '+';
                mTextOperation.setText("+");
                mIsFloat = false;
                mIsSetOperation = true;
                if (mTextInput.getText().length() > 0) {
                    mTextDisplay.setText(mTextInput.getText());
                    mTextInput.setText("");
                }
                else{
                    mTextDisplay.setText(mTextDisplay.getText());
                }
                break;
            case R.id.button_equal:
                if (mTextInput.getText().length() > 0){
                    mIsFloat = false;
                    mTextOperation.setText("=");
                    if (mIsSetOperation) {
                        switch (mOperation) {
                            case '/':
                                mNum1 = toFloat(mTextDisplay.getText());
                                mNum2 = toFloat(mTextInput.getText());
                                mRes = mNum1 / mNum2;
                                mTextDisplay.setText(Float.toString(mRes));
                                mTextInput.setText("");
                                break;
                            case '*':
                                mNum1 = toFloat(mTextDisplay.getText());
                                mNum2 = toFloat(mTextInput.getText());
                                mRes = mNum1 * mNum2;
                                mTextDisplay.setText(Float.toString(mRes));
                                mTextInput.setText("");
                                break;
                            case '-':
                                mNum1 = toFloat(mTextDisplay.getText());
                                mNum2 = toFloat(mTextInput.getText());
                                mRes = mNum1 - mNum2;
                                mTextDisplay.setText(Float.toString(mRes));
                                mTextInput.setText("");
                                break;
                            case '+':
                                mNum1 = toFloat(mTextDisplay.getText());
                                mNum2 = toFloat(mTextInput.getText());
                                mRes = mNum1 + mNum2;
                                mTextDisplay.setText(Float.toString(mRes));
                                mTextInput.setText("");
                                break;
                        }
                        mIsSetOperation = false;
                    }
                    else{
                        mTextDisplay.setText(mTextInput.getText());
                        mTextInput.setText("");
                    }
                }
                break;
        }
    }
    //Hàm đổi CharSequence thành Float để tính
    public float toFloat(CharSequence s) {
        float res = 0;
        int digit;
        int dot = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++){
            digit = Character.getNumericValue(s.charAt(i));
            if (digit == Character.getNumericValue('.')){
                dot = 1;
            }
            else{
                if(dot == 0){
                    res = res * 10 + digit;
                }
                else{
                    res += (float) digit / (10 * dot);
                    dot++;
                }
            }
        }
        return res;
    }
}
