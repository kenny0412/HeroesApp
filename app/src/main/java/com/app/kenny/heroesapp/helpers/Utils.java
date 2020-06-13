package com.app.kenny.heroesapp.helpers;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.app.kenny.heroesapp.R;

import java.util.Objects;

public class Utils {

    public static int getRandomNumber(){
        int min = 1;
        int max = 731;
        return  (int)(Math.random() * (max - min + 1) + min);
    }

    public static void showDialog(Context context,String info){
        final Dialog dialog = new Dialog(context, R.style.Theme_Dialog_Translucent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_info);
        TextView texto = dialog.findViewById(R.id.txt_texto);
        texto.setText(info);
        dialog.setCancelable(false);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        Button btnAceptar = dialog.findViewById(R.id.btn_aceptar);
        btnAceptar.setOnClickListener(v -> dialog.dismiss());
    }
}
