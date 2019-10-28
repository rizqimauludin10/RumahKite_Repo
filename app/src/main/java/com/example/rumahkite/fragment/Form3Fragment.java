package com.example.rumahkite.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rumahkite.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

public class Form3Fragment extends Fragment implements Step {
    View v;
    private EditText EtAlamat;
    private TextView TvAlamat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.form3_fragment, container, false);

        EtAlamat = v.findViewById(R.id.etAlamat);
        TvAlamat = v.findViewById(R.id.tvAlamat);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "font/TitilliumWeb-SemiBold.ttf");
        Typeface font2 = Typeface.createFromAsset(getActivity().getAssets(), "font/TitilliumWeb-Regular.ttf");
        TvAlamat.setTypeface(font);
        EtAlamat.setTypeface(font2);

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
}
