package com.example.rumahkite.adapter;

import android.content.Context;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.example.rumahkite.fragment.Form2Fragment;
import com.example.rumahkite.fragment.Form3Fragment;
import com.example.rumahkite.fragment.Form4Fragment;
import com.example.rumahkite.fragment.FormFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import java.util.ArrayList;

public class FormStepperAdapter extends AbstractFragmentStepAdapter {
    //private static final String CURRENT_STEP_POSITION_KEY = ;
    ArrayList<FormStepperAdapter> formStepperAdapters = new ArrayList<>();


    public FormStepperAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
       /* final FormFragment formFragment = new FormFragment();
        final Form2Fragment form2Fragment = new Form2Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Position", position);
        formFragment.setArguments(bundle);
        form2Fragment.setArguments(bundle);
        return formFragment;*/
        Step step = null;

        switch (position) {
            case 0:
                final FormFragment formFragment = new FormFragment();
                /*Bundle bundle1 = new Bundle();
                bundle1.putInt("Position", position);
                formFragment.setArguments(bundle1);
                return formFragment;*/
                step = formFragment;
                break;
            case 1:
                final Form2Fragment form2Fragment = new Form2Fragment();
                /*Bundle bundle2 = new Bundle();
                bundle2.putInt("Position", position);
                form2Fragment.setArguments(bundle2);
                return form2Fragment;*/
                step = form2Fragment;
                break;
            case 2:
                final Form3Fragment form3Fragment = new Form3Fragment();
                step = form3Fragment;
                break;

            case 3:
                final Form4Fragment form4Fragment = new Form4Fragment();
                step = form4Fragment;

            default:

        }


        return step;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0)int position) {
        StepViewModel.Builder builder = new StepViewModel.Builder(context);

        switch (position) {
            case 0:
                builder.setTitle("Step1");
                break;
            case 1:
                builder.setTitle("Step2");
                break;
            case 2:
                builder.setTitle("Step3");
                break;
            case 3:
                builder.setTitle("Step4");
                break;
            default:
        }
        return builder.create();
    }


}
