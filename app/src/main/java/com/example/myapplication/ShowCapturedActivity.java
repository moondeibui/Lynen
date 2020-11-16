package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.FileNotFoundException;

public class ShowCapturedActivity extends AppCompatActivity {

    Bitmap bitmap;
    SpinnerActivity spinnerActivity;
    Spinner clothesTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_captured);

        try {
            bitmap = BitmapFactory.decodeStream(getApplication().openFileInput("imageToSend"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            finish();
            return;
        }

        ImageView mImage = findViewById(R.id.image_captured);
        mImage.setImageBitmap(bitmap);

        spinnerActivity = new SpinnerActivity();

        clothesTypeSpinner = findViewById(R.id.clothes_type_spinner);
        clothesTypeSpinner.setOnItemSelectedListener(spinnerActivity);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.clothes_type_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        clothesTypeSpinner.setAdapter(adapter);
    }

    private Bitmap rotate(Bitmap decodeBitmap) {
        int w = decodeBitmap.getWidth();
        int h = decodeBitmap.getHeight();

        Matrix  matrix = new Matrix();
        matrix.setRotate(90);

        return Bitmap.createBitmap(decodeBitmap, 0, 0, w, h, matrix, true);
    }
}