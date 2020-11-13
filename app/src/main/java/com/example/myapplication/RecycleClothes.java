package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class RecycleClothes extends AppCompatActivity {

    Button test;
    CardView cardView;
    ImageButton cameraButton;
    ImageView photoImgView, closePopUp;
    Bitmap bitmap;
    CameraPopUpDialog cameraPopUpDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_clothes);

        test = findViewById(R.id.test_pop_up_btn);

        cameraButton = findViewById(R.id.camera_btn);
        cardView = findViewById(R.id.recycle_clothes_cardview);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraPopUpDialog = new CameraPopUpDialog(RecycleClothes.this, bitmap);
                cameraPopUpDialog.show();
            }
        });

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

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            bitmap = (Bitmap) data.getExtras().get("data");

            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();

            /*cameraPopUpDialog = new CameraPopUpDialog(this, bitmap);
            cameraPopUpDialog.show();*/

            /*photoImgView = findViewById(R.id.recycle_clothes_photo_imgview);
            closePopUp = findViewById(R.id.recycle_clothes_close_pop_up_imgview);

            //cardView.setVisibility(View.VISIBLE);
            photoImgView.setImageBitmap(bitmap);

            closePopUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cardView.setVisibility(View.INVISIBLE);
                }
            });*/

        }
    }

}
