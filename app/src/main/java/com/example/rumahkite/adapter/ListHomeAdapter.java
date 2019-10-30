package com.example.rumahkite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rumahkite.model.Home;
import com.example.rumahkite.R;

import java.util.ArrayList;

public class ListHomeAdapter extends RecyclerView.Adapter<ListHomeAdapter.ListViewHolder> {
    private ArrayList<Home> listHome;
    private OnItemClickCallBack onItemClickCallBack;


    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }


    public ListHomeAdapter(ArrayList<Home> list) {
        this.listHome = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Home home = listHome.get(position);
        Glide.with(holder.itemView.getContext())
                .load(home.getFoto())
                .apply(new RequestOptions())
                .into(holder.imgHome);
       /* holder.tvElectry.setText(home.getElectric());
        holder.tvFloor.setText(home.getFloor());
        holder.tvGarden.setText(home.getGarden());
        holder.tvLandsize.setText(home.getLandsize());
        holder.tvSince.setText(home.getSince());
        holder.tvKecamatan.setText(home.getKecamatan());
        holder.tvSale.setText(home.getmSale());
        holder.tvJarak.setText(home.getKilojarak());
        holder.tvProperty.setText(home.getProperty());
        holder.tvPrice.setText(home.getHarga());
        holder.tvDesc.setText(home.getDeskripsi());
        holder.tvType.setText(home.getType_home());
        holder.tvAgent.setText(home.getNamaAgent());
        holder.tvBath.setText(home.getkBath());
        holder.tvBed.setText(home.getkSleep());
        holder.tvFacility.setText(home.getHomeFacility());
        holder.tvCertificate.setText(home.getTipeSertifikat());
        holder.tvAlamat.setText(home.getAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked(listHome.get(holder.getAdapterPosition()));
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return listHome.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHome;
        TextView tvProperty, tvPrice, tvDesc, tvJarak, tvSale, tvKecamatan,
                tvType, tvAgent, tvBed, tvBath, tvFacility, tvCertificate,
                tvAlamat, tvLandsize, tvElectry, tvFloor, tvGarden, tvSince;

        ListViewHolder(View itemView) {
            super(itemView);
            /*tvSince = itemView.findViewById(R.id.tv_since);
            tvGarden = itemView.findViewById(R.id.tv_garden);
            tvFloor = itemView.findViewById(R.id.tv_floor);
            tvElectry = itemView.findViewById(R.id.tv_electry);
            tvLandsize = itemView.findViewById(R.id.tv_landsize);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvCertificate = itemView.findViewById(R.id.tipe_sertifikat);
            tvFacility = itemView.findViewById(R.id.fasilitas);
            tvBath = itemView.findViewById(R.id.kamar_mandi);
            tvBed = itemView.findViewById(R.id.kamar_tidur);
            tvAgent = itemView.findViewById(R.id.tv_agent);
            imgHome = itemView.findViewById(R.id.img_item_photo);
            tvType = itemView.findViewById(R.id.type);
            tvProperty = itemView.findViewById(R.id.tv_property);
            tvPrice = itemView.findViewById(R.id.tv_harga);
            tvJarak = itemView.findViewById(R.id.jarak);
            tvSale = itemView.findViewById(R.id.sale);
            tvKecamatan = itemView.findViewById(R.id.kecamatan);
            tvDesc = itemView.findViewById(R.id.tv_deskripsi);*/

            imgHome = itemView.findViewById(R.id.img_item_photo);
        }
    }


    public interface OnItemClickCallBack {
        void onItemClicked(Home data);
    }
}
