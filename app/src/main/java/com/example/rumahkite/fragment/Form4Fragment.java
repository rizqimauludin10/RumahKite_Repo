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

public class Form4Fragment extends Fragment implements Step {
    View v;
    private EditText EtTotalHari, EtAlamat2, EtTanggal2, EtDesc2;
    private TextView caption, TvTotalHari, TvKali, TvHargaHari, TvTanggal1, TvDesc2, TvAlamat2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.form4_fragment, container, false);
        caption = v.findViewById(R.id.caption);
        TvTotalHari = v.findViewById(R.id.tvTotalHari);
        TvKali = v.findViewById(R.id.tvkali);
        TvHargaHari = v.findViewById(R.id.tvHargaHari);
        TvTanggal1 = v.findViewById(R.id.tvTanggal1);
        TvDesc2 = v.findViewById(R.id.tvDesc2);
        TvAlamat2 = v.findViewById(R.id.tvAlamat2);

        EtTotalHari = v.findViewById(R.id.etTotalHari);
        EtAlamat2 = v.findViewById(R.id.etAlamat2);
        EtTanggal2 = v.findViewById(R.id.etTanggal2);
        EtDesc2 = v.findViewById(R.id.etDesc2);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "font/TitilliumWeb-SemiBold.ttf");
        Typeface font2 = Typeface.createFromAsset(getActivity().getAssets(), "font/TitilliumWeb-Regular.ttf");
        Typeface font3 = Typeface.createFromAsset(getActivity().getAssets(), "font/TitilliumWeb-Bold.ttf");
        caption.setTypeface(font3);
        TvTotalHari.setTypeface(font);
        TvKali.setTypeface(font);
        TvHargaHari.setTypeface(font);
        TvTanggal1.setTypeface(font);
        TvDesc2.setTypeface(font);
        TvAlamat2.setTypeface(font);

        EtTotalHari.setTypeface(font2);
        EtAlamat2.setTypeface(font2);
        EtTanggal2.setTypeface(font2);
        EtDesc2.setTypeface(font2);

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
