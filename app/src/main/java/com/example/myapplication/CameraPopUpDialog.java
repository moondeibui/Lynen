package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;

public class CameraPopUpDialog extends Dialog implements View.OnClickListener{

    private final Bitmap bitmap;
    ImageView photoImgView, closePopUp;

    public CameraPopUpDialog(@NonNull Context context, Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_pop_up_dialog);
        photoImgView = findViewById(R.id.recycle_clothes_photo_imgview);
        closePopUp = findViewById(R.id.recycle_clothes_close_pop_up_imgview);

        closePopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
