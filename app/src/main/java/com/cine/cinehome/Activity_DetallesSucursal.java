package com.cine.cinehome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

public class Activity_DetallesSucursal extends Activity {
    ImageView img_back;
    ImageView img_foto;
    TextView titulo;
    TextView tv_domicilio;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_sucursal);
        titulo = (TextView)findViewById(R.id.activity_sucursales_tv_nombre_sucursal);
        tv_domicilio = (TextView)findViewById(R.id.activity_sucursales_tv_domicilio);

        img_foto = (ImageView)findViewById(R.id.activity_sucursales_img_foto);
        img_back = (ImageView)findViewById(R.id.btn_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        downloadImage();
    }
    public void downloadImage(){
        String URL ="";
        if(Constantes.marketSelected ==0)
        {
            URL =  "https://media.timeout.com/images/103679189/630/472/image.jpg";
            titulo.setText("LAS PALMAS MX");
            tv_domicilio.setText(getResources().getString(R.string.Domicilio));
        }
        else if (Constantes.marketSelected ==1){
            titulo.setText("COYOACAN FRESA");
            URL =  "https://mas-mexico.com.mx/wp-content/uploads/2018/11/iztacalco-principal.jpg";
            tv_domicilio.setText(getResources().getString(R.string.Domicilio_coyoacan));
        }

        Picasso.with(this).load(URL)
                .resize(1000,500)
                .centerInside()
                .placeholder(R.drawable.ic_back)
                .error(R.drawable.ic_back)
                .into(img_foto);
    }
}
