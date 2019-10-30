package com.example.rumahkite.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rumahkite.DetailActivity;
import com.example.rumahkite.HomeDummy;
import com.example.rumahkite.ListHomeActivity;
import com.example.rumahkite.R;
import com.example.rumahkite.adapter.ListHomeAdapter;
import com.example.rumahkite.adapter.TabAdapter;
import com.example.rumahkite.model.Home;

import java.util.ArrayList;

public class TabListFragment extends Fragment {

    private RecyclerView rvHome;
    private ArrayList<Home> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_list, container, false);

        rvHome = view.findViewById(R.id.rvhome);
        rvHome.setHasFixedSize(true);

        list.addAll(HomeDummy.getListData());
        showRecycler();

        return view;
    }

    private void showRecycler() {
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListHomeAdapter listHomeAdapter = new ListHomeAdapter(list);
        rvHome.setAdapter(listHomeAdapter);

        listHomeAdapter.setOnItemClickCallBack(new ListHomeAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Home data) {
                //showSelectedHome(data);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TYPE, data.getType_home());
                intent.putExtra(DetailActivity.EXTRA_PRICE, data.getHarga());
                intent.putExtra(DetailActivity.EXTRA_DESC, data.getDeskripsi());
                intent.putExtra(DetailActivity.EXTRA_PIC, data.getFoto());
                intent.putExtra(DetailActivity.EXTRA_KEC, data.getKecamatan());
                intent.putExtra(DetailActivity.EXTRA_SALE, data.getmSale());
                intent.putExtra(DetailActivity.EXTRA_AGENT, data.getNamaAgent());
                intent.putExtra(DetailActivity.EXTRA_BED, data.getkSleep());
                intent.putExtra(DetailActivity.EXTRA_BATH, data.getkBath());
                intent.putExtra(DetailActivity.EXTRA_LANDSIZE, data.getLandsize());
                intent.putExtra(DetailActivity.EXTRA_CERTIFICATE, data.getTipeSertifikat());
                intent.putExtra(DetailActivity.EXTRA_ELECTRY, data.getElectric());
                intent.putExtra(DetailActivity.EXTRA_GARDEN, data.getGarden());
                intent.putExtra(DetailActivity.EXTRA_SINCE, data.getSince());
                intent.putExtra(DetailActivity.EXTRA_FLOOR, data.getFloor());

                startActivity(intent);
            }
        });
    }


}
