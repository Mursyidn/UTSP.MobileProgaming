package com.example.mridwan.utspmobpro;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MartabakMonkey extends AppCompatActivity {

    Intent tangkap;
    TextView judul , konten;
    ImageView gambar;
    String alamat;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_s1);

        judul= (TextView)findViewById(R.id.txtJudul);
        konten= (TextView)findViewById(R.id.txtKonten);
        gambar= (ImageView)findViewById(R.id.imgGambar);
        tangkap = getIntent();


        String alamat;

        String paramHasil = tangkap.getStringExtra("param");

        if (paramHasil.equals("0"))
        {
            judul.setText("Martabak Cococrunch");
            konten.setText("Martabak dengan lapisan cococrunch yang gurih membuat lidah tidak bisa berenti");

        }else  if (paramHasil.equals("1"))

        {
            judul.setText("Martabak Blueberry");
            konten.setText("Martabak Blueberry dengan lapisan slay segar serta aroma yang alami membuat kita ketagihan.");

        }else  if (paramHasil.equals("2"))
        {
            judul.setText("Martabak Keju");
            konten.setText("Buat pecinta keju,wajib nyobain yang satu ini dengan keju yang meleleh membuat rasanya selalu terbayang");

        }else  if (paramHasil.equals("3"))
        {
            judul.setText("Martabak Greentea");
            konten.setText("Untuk yang suka alami kini hadir martabak greentea aromanya membuat ketenangan dari kehidupan UTS yang menerka.");

        }else  if (paramHasil.equals("4"))
        {
            judul.setText("Martabak Special");
            gambar.setImageResource(R.drawable.special);
            konten.setText("Yang special tentu berbeda dengan 4 varian rasa menjadi satu kenikmatan dan bisa kalian miliki saat ini juga segera order!");

        }

    }
}


