package com.example.rumahkite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rumahkite.adapter.FormStepperAdapter;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.uncopt.android.widget.text.justify.JustifiedTextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TukangFormActivity extends AppCompatActivity implements StepperLayout.StepperListener {

    private StepperLayout mStepperLayout;
    private Dialog epicDialog;
    LayoutInflater inflater;
    View dialogView;
    JustifiedTextView justifiedTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tukang_form);

        mStepperLayout = findViewById(R.id.formstepperlayout);
        mStepperLayout.setAdapter(new FormStepperAdapter(getSupportFragmentManager(), this));
        mStepperLayout.setListener(this);

        epicDialog = new Dialog(this);
        justifiedTextView = findViewById(R.id.descThree);
        justifiedTextView = findViewById(R.id.descFive);
        justifiedTextView = findViewById(R.id.descSix);
        justifiedTextView = findViewById(R.id.descSeven);
        justifiedTextView = findViewById(R.id.descEight);


    }

    @Override
    public void onCompleted(View completeButton) {
        dialogDesc();

        //Toast.makeText(this, "onCompleted!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(VerificationError verificationError) {
        //Toast.makeText(this, "onError! -> " + verificationError.getErrorMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStepSelected(int newStepPosition) {
        //Toast.makeText(this, "onStepSelected! -> " + newStepPosition, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onReturn() {
        finish();

    }

    public void dialogDesc() {
       /* epicDialog = new AlertDialog.Builder(TukangFormActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_form, null);
        epicDialog.setView(dialogView);*/
        epicDialog.setContentView(R.layout.dialog_form);
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();


    }



}
