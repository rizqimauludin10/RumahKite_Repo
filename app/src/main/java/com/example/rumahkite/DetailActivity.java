package com.example.rumahkite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_TYPE = "extra_type";
    public static final String EXTRA_PRICE = "extra_price";
    public static final String EXTRA_DESC = "extra_desc";
    public static final String EXTRA_PIC = "extra_pic";
    public static final String EXTRA_KEC = "extra_kec";
    public static final String EXTRA_SALE = "extra_sale";
    public static final String EXTRA_AGENT = "extra_agent";
    public static final String EXTRA_BED = "extra_bed";
    public static final String EXTRA_BATH = "extra_bath";
    public static final String EXTRA_FACILITY = "extra_facility";
    public static final String EXTRA_CERTIFICATE = "extra_certificate";
    public static final String EXTRA_ADDRESS = "extra_address";
    public static final String EXTRA_JARAK = "extra_jarak";
    public static final String EXTRA_LANDSIZE = "extra_landsize";
    public static final String EXTRA_GARDEN = "extra_garden";
    public static final String EXTRA_ELECTRY = "extra_electry";
    public static final String EXTRA_SINCE = "extra_since";
    public static final String EXTRA_FLOOR = "extra_floor";

    TextView getType, getPrice, getDesc, getProperty, getKecamatan, getSale, getJarak, getAgent,
            getBed, getBath, getFacility, getCertificate, getAddress, getLandsize, getGarden, getElectry, getSince, getFloor;
    ImageView getImg;
    String mType, mPrice, mDesc, mProperty, mKecamatan, mSale, mAgent, mBed, mBath, mCertificate, mAddress, mLandsize, mGarden, mElectry,
            mSince, mFloor;
    int mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getType = findViewById(R.id.get_type);
        getPrice = findViewById(R.id.get_price);
        getDesc = findViewById(R.id.get_desc);
        getImg = findViewById(R.id.get_image);
        getKecamatan = findViewById(R.id.get_kecamatan);
        getProperty = findViewById(R.id.get_property);
        getSale = findViewById(R.id.get_sale);
        //getJarak = findViewById(R.id.get_k)
        getAddress = findViewById(R.id.get_address);
        getAgent = findViewById(R.id.get_agent);
        getBed = findViewById(R.id.get_bed);
        getBath = findViewById(R.id.get_bath);
        getCertificate = findViewById(R.id.get_certificate);
        getLandsize = findViewById(R.id.get_landsize);
        getGarden = findViewById(R.id.get_garden);
        getElectry = findViewById(R.id.get_electry);
        getSince = findViewById(R.id.get_since);
        getFloor = findViewById(R.id.get_floor);


        mKecamatan = getIntent().getStringExtra(EXTRA_KEC);
        mSale = getIntent().getStringExtra(EXTRA_SALE);
        mAddress = getIntent().getStringExtra(EXTRA_ADDRESS);
        mAgent = getIntent().getStringExtra(EXTRA_AGENT);
        mBed = getIntent().getStringExtra(EXTRA_BED);
        mBath = getIntent().getStringExtra(EXTRA_BATH);
        mCertificate = getIntent().getStringExtra(EXTRA_CERTIFICATE);
        mLandsize = getIntent().getStringExtra(EXTRA_LANDSIZE);
        mGarden = getIntent().getStringExtra(EXTRA_GARDEN);
        mElectry = getIntent().getStringExtra(EXTRA_ELECTRY);
        mSince = getIntent().getStringExtra(EXTRA_SINCE);
        mFloor = getIntent().getStringExtra(EXTRA_FLOOR);
        mType = getIntent().getStringExtra(EXTRA_TYPE);
        mPrice = getIntent().getStringExtra(EXTRA_PRICE);
        mDesc = getIntent().getStringExtra(EXTRA_DESC);
        mImg = getIntent().getIntExtra(EXTRA_PIC, 0);

        getFloor.setText(mFloor);
        getSince.setText(mSince);
        getElectry.setText(mElectry);
        getGarden.setText(mGarden);
        getLandsize.setText(mLandsize);
        getCertificate.setText(mCertificate);
        getBath.setText(mBath);
        getBed.setText(mBed);
        getAgent.setText(mAgent);
        getAddress.setText(mAddress);
        getSale.setText(mSale);
        getKecamatan.setText(mKecamatan);
        getType.setText(mType);
        getPrice.setText(mPrice);
        getDesc.setText(mDesc);
        getImg.setImageResource(mImg);

    }
}
