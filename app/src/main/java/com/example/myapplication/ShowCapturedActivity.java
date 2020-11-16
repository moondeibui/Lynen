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
    ClothesTypeSpinnerActivity clothesTypeSpinnerActivity;
    ClothesMaterialSpinnerActivity clothesMaterialSpinnerActivity;
    ClothesGenderSpinnerActivity clothesGenderSpinnerActivity;
    Spinner clothesTypeSpinner, clothesMaterialSpinner, clothesGenderSpinner;

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

        /*Clothes Type Spinner*/
        clothesTypeSpinnerActivity = new ClothesTypeSpinnerActivity();

        clothesTypeSpinner = findViewById(R.id.clothes_type_spinner);
        clothesTypeSpinner.setOnItemSelectedListener(clothesTypeSpinnerActivity);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.clothes_type_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        clothesTypeSpinner.setAdapter(adapter);


        /*Clothes Material Spinner*/
        clothesMaterialSpinnerActivity = new ClothesMaterialSpinnerActivity();

        clothesMaterialSpinner = findViewById(R.id.clothes_material_spinner);
        clothesMaterialSpinner.setOnItemSelectedListener(clothesMaterialSpinnerActivity);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.clothes_material_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        clothesMaterialSpinner.setAdapter(adapter2);


        /*Clothes Gender Spinner*/
        clothesGenderSpinnerActivity = new ClothesGenderSpinnerActivity();

        clothesGenderSpinner = findViewById(R.id.clothes_gender_spinner);
        clothesGenderSpinner.setOnItemSelectedListener(clothesGenderSpinnerActivity);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.clothes_gender_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        clothesGenderSpinner.setAdapter(adapter3);
    }

    private Bitmap rotate(Bitmap decodeBitmap) {
        int w = decodeBitmap.getWidth();
        int h = decodeBitmap.getHeight();

        Matrix  matrix = new Matrix();
        matrix.setRotate(90);

        return Bitmap.createBitmap(decodeBitmap, 0, 0, w, h, matrix, true);
    }

    public class ClothesTypeSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    public class ClothesMaterialSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    public class ClothesGenderSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

}