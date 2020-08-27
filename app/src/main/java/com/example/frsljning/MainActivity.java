package com.example.frsljning;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inPrice;
    private EditText margin;
    private TextView outPrice;
    private Integer outPriceText;
    private Button oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn, backDelBtn, clearBtn;
    private static final String MY_PREF = "SHAREDPREF";


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inPrice = findViewById(R.id.inPrice);
        margin = findViewById(R.id.margin);
        outPrice = findViewById(R.id.outPrice);

        //initiate number buttons and set onClickListeners to them
        oneBtn = findViewById(R.id.oneBtn);
            oneBtn.setOnClickListener((View.OnClickListener) this);
        twoBtn = findViewById(R.id.twoBtn);
        twoBtn.setOnClickListener((View.OnClickListener) this);
        threeBtn = findViewById(R.id.threeBtn);
            threeBtn.setOnClickListener((View.OnClickListener) this);
        fourBtn = findViewById(R.id.fourBtn);
            fourBtn.setOnClickListener((View.OnClickListener) this);
        fiveBtn = findViewById(R.id.fiveBtn);
            fiveBtn.setOnClickListener((View.OnClickListener) this);
        sixBtn = findViewById(R.id.sixBtn);
            sixBtn.setOnClickListener((View.OnClickListener) this);
        sevenBtn = findViewById(R.id.sevenBtn);
            sevenBtn.setOnClickListener((View.OnClickListener) this);
        eightBtn = findViewById(R.id.eightBtn);
            eightBtn.setOnClickListener((View.OnClickListener) this);
        nineBtn = findViewById(R.id.nineBtn);
            nineBtn.setOnClickListener((View.OnClickListener) this);
        zeroBtn = findViewById(R.id.zeroBtn);
            zeroBtn.setOnClickListener((View.OnClickListener) this);
        backDelBtn = findViewById(R.id.backDelBtn);
            backDelBtn.setOnClickListener((View.OnClickListener) this);
        clearBtn = findViewById(R.id.clearBtn);
            clearBtn.setOnClickListener((View.OnClickListener) this);

        inPrice.requestFocus();


        //lägg en TextWatcher på flera EditText-fält
        inPrice.addTextChangedListener(priceTextWatcher);
        margin.addTextChangedListener(priceTextWatcher);


        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //stop soft keyboard from showing/popping up
        inPrice.setShowSoftInputOnFocus(false);
        margin.setShowSoftInputOnFocus(false);

        loadData(); //call function to restore data to views


    }



    //läs om det skrivs något i inPrice OCH margin ...
    private TextWatcher priceTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String inPriceEnter = inPrice.getText().toString();
            String marginEnter = margin.getText().toString();


            if(inPriceEnter.length()>0 && marginEnter.length()>0 && marginEnter.length()<3){    //length <3 (max 99%)
                String inValueText = inPrice.getText().toString();  //inpris som text
                    int inValueInt = Integer.parseInt(inValueText);        //inpris som int

                String marginText = margin.getText().toString();    //margin som text
                    Double marginValueDbl = Double.parseDouble(marginText)/100;    //margin som int

                int outPriceInt = (int) Math.round(inValueInt/(1 - marginValueDbl));      //beräkna utPris, som Int
                    String outPriceText = String.valueOf(outPriceInt);  //gör String av utPris

                outPrice.setText(outPriceText);

            }
            else{
                outPrice.setText("");
            }

        }

        @Override
        public void afterTextChanged(Editable s) {
        }

    };


    //assign action for each clickable button
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.oneBtn:
                enterOne();
                break;
            case R.id.twoBtn:
                enterTwo();
                break;
            case R.id.threeBtn:
                enterThree();
                break;
            case R.id.fourBtn:
                enterFour();
                break;
            case R.id.fiveBtn:
                enterFive();
                break;
            case R.id.sixBtn:
                enterSix();
                break;
            case R.id.sevenBtn:
                enterSeven();
                break;
            case R.id.eightBtn:
                enterEight();
                break;
            case R.id.nineBtn:
                enterNine();
                break;
            case R.id.zeroBtn:
                enterZero();
                break;
            case R.id.backDelBtn:
                backDelete();
                break;
            case R.id.clearBtn:
                clearAll();
                break;
        }
    }

    public void enterOne(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "1");
        }else
            {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "1");
        }
    }

    public void enterTwo(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "2");
        }else
        {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "2");
        }
    }

    public void enterThree(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "3");
        }else
        {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "3");
        }
    }

    public void enterFour(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "4");
        }else
        {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "4");
        }
    }

    public void enterFive(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "5");
        }else
        {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "5");
        }
    }

    public void enterSix(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "6");
        }else
        {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "6");
        }
    }

    public void enterSeven(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "7");
        }else
        {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "7");
        }
    }

    public void enterEight(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "8");
        }else
        {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "8");
        }
    }

    public void enterNine(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "9");
        }else
        {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "9");
        }
    }

    public void enterZero(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
            Editable editable = inPrice.getText();
            editable.insert(cursorPosition, "0");
        }else
        {
            int cursorPosition = margin.getSelectionStart();
            Editable editable = margin.getText();
            editable.insert(cursorPosition, "0");
        }
    }

    public void backDelete(){
        if(inPrice.isFocused()){
            int cursorPosition = inPrice.getSelectionStart();
                if(cursorPosition >=1){    //secure cursor position (app crashes if you backDelete when no numbers in view)
                Editable editable = inPrice.getText();
                editable.delete(cursorPosition-1, cursorPosition);
                }
        }else {
            int cursorPosition = margin.getSelectionStart();
                if (cursorPosition >= 1) {    //secure cursor position (app crashes if you backDelete when no numbers in view)
                Editable editable = margin.getText();
                editable.delete(cursorPosition - 1, cursorPosition);
            }
        }
    }

    public void clearAll(){
        inPrice.setText("");
        margin.setText("");
        inPrice.requestFocus();
    }



    //ActionBar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }
    // create action for each item in ActionBar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.exit:
                Toast.makeText(this, "Avslutar app ...", Toast.LENGTH_SHORT).show();
                finish();
                //return(true);
        }
        return(super.onOptionsItemSelected(item));
    }


    //show activity with info about this app
//    public void aboutApp_FromActionBar(){
//        Intent intentAboutApp = new Intent(MainActivity.this, AboutActivity.class);
//        startActivity(intentAboutApp);
//    }
    //show activity to create API








    //save data when pressing onBack button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SharedPreferences sh = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sh.edit();

        editor.putString("margin", margin.getText().toString());
        editor.apply();
    }

    //restore data when re-opening app
    public void loadData(){
        SharedPreferences sh = getSharedPreferences(MY_PREF, MODE_PRIVATE);
        String savedStateMargin = sh.getString("margin","");
        margin.setText(savedStateMargin);
    }




}








//getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//hideSoftKeyboard();



//UIUtil.hideKeyboard(this);  //should hide soft keyboard, with dependency in build.gradle

//hideSoftKeyboard();
//margin.setInputType(InputType.TYPE_NULL);




//        inPrice.setInputType(InputType.TYPE_NULL);
//        if (android.os.Build.VERSION.SDK_INT >= 11) {
//            inPrice.setRawInputType(InputType.TYPE_CLASS_TEXT);
//            inPrice.setTextIsSelectable(true);
//            hideSoftKeyboard();
//        }



//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



//        //hide soft keyboard when pressing et inPrice
//        //inPrice.setCursorVisible(false); //This code is used when you do not want the cursor to be visible at startup
//        inPrice.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                v.onTouchEvent(event);   // handle the event first
//                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (imm != null) {
//
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);  // hide the soft keyboard
//                    inPrice.setCursorVisible(true); //This is to display cursor when upon onTouch of Edittext
//                }
//                return true;
//            }
//        });
//
//        //hide soft keyboard when pressing et Margin
//        margin.setCursorVisible(false); //This code is used when you do not want the cursor to be visible at startup
//        margin.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                v.onTouchEvent(event);   // handle the event first
//                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                if (imm != null) {
//
//                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);  // hide the soft keyboard
//                    margin.setCursorVisible(true); //This is to display cursor when upon onTouch of Edittext
//                }
//                return true;
//            }
//        });


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
//            inPrice.setShowSoftInputOnFocus(false);
//        } else { // API 11-20
//            inPrice.setTextIsSelectable(true);
//        }

//        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(inPrice.getWindowToken(), 0);
//        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(margin.getWindowToken(), 0);





//    private void hideSoftKeyboard() {
//        View view = this.getCurrentFocus();
//        if (view != null) {
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        }
//    }



//}




//    private void hideSoftKeyboard() {
//        View view = this.getCurrentFocus();
//        if (view != null) {
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        }
//    }







//    public void hideSoftKeyboard(View view){
//        InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }





//    public void hideSoftKeyboard() {
//        if(getCurrentFocus()!=null) {
//            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
//        }
//    }





//    public static void hideKeyboard(Activity activity) {
//        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        //Find the currently focused view, so we can grab the correct window token from it.
//        View view = activity.getCurrentFocus();
//        //If no view currently has focus, create a new one, just so we can grab a window token from it
//        if (view == null) {
//            view = new View(activity);
//        }
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }





//    public static void hideKeyboard(Activity activity) {
//        View view = activity.findViewById(android.R.id.content);
//        if (view != null) {
//            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        }
//    }














































