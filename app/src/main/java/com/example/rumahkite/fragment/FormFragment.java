package com.example.rumahkite.fragment;

import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rumahkite.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormFragment extends Fragment implements Step {
    View v;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText EtDateResult, EtHari, EtDesc;
    private TextView TvHari, TvDate, TvDesc, TvCaption, TvHarga1, TvHr;
    private ImageView btDatePicker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.form1_fragment, container, false);


        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        EtDateResult = v.findViewById(R.id.date);
        btDatePicker = v.findViewById(R.id.dateIc);
        EtHari = v.findViewById(R.id.etHari);
        EtDesc = v.findViewById(R.id.etDesc);
        TvHari = v.findViewById(R.id.tvHari);
        TvDate = v.findViewById(R.id.tvDate);
        TvDesc = v.findViewById(R.id.tvDesc);
        TvCaption = v.findViewById(R.id.captionform1);
        TvHarga1 = v.findViewById(R.id.tv_harga1);
        TvHr = v.findViewById(R.id.hr);


        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "font/TitilliumWeb-SemiBold.ttf");
        Typeface font2 = Typeface.createFromAsset(getActivity().getAssets(), "font/TitilliumWeb-Regular.ttf");
        EtDateResult.setTypeface(font2);
        EtDesc.setTypeface(font2);
        EtHari.setTypeface(font2);
        TvHari.setTypeface(font);
        TvDesc.setTypeface(font);
        TvDate.setTypeface(font);
        TvCaption.setTypeface(font);
        TvHarga1.setTypeface(font);
        TvHr.setTypeface(font);

        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogDate();
            }
        });

        return v;

    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void showDialogDate() {

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                EtDateResult.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
