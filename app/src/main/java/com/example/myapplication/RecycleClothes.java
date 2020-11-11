package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class RecycleClothes extends AppCompatActivity {

    ImageButton cameraButton;
    Dialog photoDialog;
    ImageView photoImgView, closePopUp;
    //Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_clothes);

        cameraButton = findViewById(R.id.camera_btn);

        if (ContextCompat.checkSelfPermission(RecycleClothes.this, Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(RecycleClothes.this, new String[]{
                    Manifest.permission.CAMERA
            }, 100);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        photoDialog = new Dialog(this);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1000);
                //showPhotoPopUp(bitmap);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 100) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            photoDialog = new Dialog(this);

            photoDialog.setContentView(R.layout.camera_pop_up_dialog);

            photoImgView = findViewById(R.id.photo_imgview);
            closePopUp = findViewById(R.id.close_pop_up_imgview);

            photoImgView.setImageBitmap(bitmap);

            closePopUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    photoDialog.dismiss();
                }
            });

        }
    }

    public void showPhotoPopUp(Bitmap bitmap) {
        photoDialog.setContentView(R.layout.camera_pop_up_dialog);

        photoImgView = findViewById(R.id.photo_imgview);
        closePopUp = findViewById(R.id.close_pop_up_imgview);

        //photoImgView.setImageBitmap(bitmap);

        closePopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photoDialog.dismiss();
            }
        });
    }
}
