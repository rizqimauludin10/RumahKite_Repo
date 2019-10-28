package com.example.rumahkite;

import com.example.rumahkite.model.Home;
import com.example.rumahkite.R;

import java.util.ArrayList;

public class HomeDummy {
    private static String[] propertyType = {
            "Rumah",
            "Rumah",
            "Rumah",
            "Rumah",
            "Rumah",
            "Rumah"
    };

    private static String[] homePrice = {
            "Rp.300.000.000",
            "Rp.400.000.000",
            "Rp.500.000.000",
            "Rp.800.000.000",
            "Rp.900.000.000",
            "Rp.1.200.000.000"
    };

    private static String[] homeDesc = {
            "Lokasi di Jalan Karet no 77  Dengan akses jalan selebar 5 meter, kurang lebih 10 menit dari pasar teratai",
            "Lokasi di Jalan PGA no 77  Dengan akses jalan selebar 3 meter, jarak antar rumah sekitar 2 meter, kurang lebih 5 menit dari pasar kemuning",
            "Lokasi di Jalan Tebu no 77  Dengan akses jalan selebar 5 meter, pas di depan Sekolah Tunas Bakti ",
            "Lokasi di Jalan Ahmad Yani no 77  Dekat dengan KFC A Yani serta bisa juga lewat di jalan gajah mada",
            "Lokasi di Jalan Sejahtera no 77 Dengan akses jalan sebear 4 meter, kurang lebih 5 menit untuk menuju Jln Ahmad Yani",
            "Lokasi di Jalan Perintis Kota Baru Ujung no 77  Dengan akses jalan selebar 5 meter, kurang lebih 10 menit dari Jln Ampera",


    };

    private static String[] homeSale = {
            "DIJUAL",
            "DIJUAL",
            "DIJUAL",
            "DIJUAL",
            "DIJUAL",
            "DIJUAL"
    };

    private static String[] homeKecamatan = {
            "Pontianak Barat",
            "Pontianak Utara",
            "Pontianak Timur",
            "Pontianak Selatan",
            "Pontianak Tenggara",
            "Pontianak Kota"
    };

    private static String[] homeJarak = {
            "5.21 Km",
            "2.44 Km",
            "7.30 Km",
            "1.32 Km",
            "9.32 Km",
            "3.32 Km",
    };

    private static int[] homeImages = {
            R.drawable.tipe21,
            R.drawable.tipe36,
            R.drawable.tipe45,
            R.drawable.tipe54,
            R.drawable.tipe60,
            R.drawable.type70
    };

    private static String[] homeType = {
            "Type 21",
            "Type 36",
            "Type 45",
            "Type 54",
            "Type 60",
            "Type 70"
    };

    private static String[] homeBed = {
            "3",
            "2",
            "4",
            "5",
            "2",
            "1"
    };

    private static String[] homeBath = {
            "1",
            "2",
            "2",
            "1",
            "1",
            "1"
    };

    private static String[] homeFacility = {
            "3",
            "2",
            "4",
            "2",
            "3",
            "2"
    };

    private static String[] homeCertifcate = {
            "SHM",
            "SHM",
            "SHM",
            "SHM",
            "SHM",
            "SHM"

    };

    private static String[] homeAddress = {
            "Jalan Karet no 77",
            "Jalan PGA no 77",
            "Jalan Tebu no 77",
            "Jalan Ahmad Yani no 77",
            "Jalan Sejahtera no 77",
            "Jalan Peintis no 77"


    };

    private static String[] homeAgent = {
            "Rinaldy Eka Saputra",
            "Eko Alfianto",
            "Rizqi Mauludin",
            "Alzri Parwansyah",
            "Nahel Sumanto",
            "Angga Aladin"
    };

    private static String[] homeElectry = {
            "900 Watt",
            "1200 Watt",
            "900 Watt",
            "1200 Watt",
            "900 Watt",
            "1200 Watt"

    };

    private static String[] homeGarden = {
            "1",
            "1",
            "1",
            "1",
            "1",
            "1"

    };

    private static String[] homeLandsize = {
            "24 M",
            "37 M",
            "21 M",
            "32 M",
            "22 M",
            "30 M"
    };

    private static String[] homeFloor = {
            "1",
            "1",
            "1",
            "2",
            "2",
            "2"
    };

    private static String[] homeSince = {
            "2015",
            "2017",
            "2018",
            "2014",
            "2015",
            "2016",
    };

    public static ArrayList<Home> getListData() {
        ArrayList<Home> list = new ArrayList<>();
        for (int position = 0; position < propertyType.length; position++) {
            Home home = new Home();
            home.setProperty(propertyType[position]);
            home.setHarga(homePrice[position]);
            home.setDeskripsi(homeDesc[position]);
            home.setFoto(homeImages[position]);
            home.setKecamatan(homeKecamatan[position]);
            home.setKilojarak(homeJarak[position]);
            home.setmSale(homeSale[position]);
            home.setType_home(homeType[position]);
            home.setHomeFacility(homeFacility[position]);
            home.setkBath(homeBath[position]);
            home.setNamaAgent(homeAgent[position]);
            home.setkSleep(homeBed[position]);
            home.setTipeSertifikat(homeCertifcate[position]);
            home.setAlamat(homeAddress[position]);
            home.setElectric(homeElectry[position]);
            home.setGarden(homeGarden[position]);
            home.setSince(homeSince[position]);
            home.setFloor(homeFloor[position]);
            home.setLandsize(homeLandsize[position]);
            list.add(home);
        }
        return list;
    }
}
