package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

public class ShowCapturedActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    Bitmap bitmap;
    ClothesTypeSpinnerActivity clothesTypeSpinnerActivity;
    ClothesMaterialSpinnerActivity clothesMaterialSpinnerActivity;
    ClothesGenderSpinnerActivity clothesGenderSpinnerActivity;
    ClothesBinLocationSpinnerActivity clothesBinLocationSpinnerActivity;
    Spinner clothesTypeSpinner, clothesMaterialSpinner, clothesGenderSpinner, clothesBinLocationSpinner;
    ImageButton submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_captured);

        myDb = new DatabaseHelper(this);

        // Dialog Back to Home
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("You have successfully submitted you clothing.")
                .setTitle("Submitted Successfully");

        builder.setPositiveButton(R.string.back_home, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(ShowCapturedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        AlertDialog dialogHome = builder.create();


        try {
            bitmap = BitmapFactory.decodeStream(getApplication().openFileInput("imageToSend"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            finish();
            return;
        }

        ImageView mImage = findViewById(R.id.image_captured);
        mImage.setImageBitmap(bitmap);

        // Convert to Bitmap
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte imageInByte[] = stream.toByteArray();

        // Confirmation Dialog
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this, R.style.AlertDialogTheme);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder2.setMessage("Please confirm if you would like to recycle your clothes.")
                .setTitle("Confirmation");

        builder2.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String type = clothesTypeSpinner.getSelectedItem().toString();
                String material = clothesMaterialSpinner.getSelectedItem().toString();
                String binLocation = clothesBinLocationSpinner.getSelectedItem().toString();
                String gender = clothesGenderSpinner.getSelectedItem().toString();
                boolean isInserted = myDb.insertData(type,material,binLocation,gender,imageInByte);
                if (isInserted == true){
                    Toast.makeText(ShowCapturedActivity.this, "Submitted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ShowCapturedActivity.this, "NOT Submitted!", Toast.LENGTH_SHORT).show();
                }
                dialogHome.show();
            }
        });
        builder2.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(ShowCapturedActivity.this, MainActivity.class);
                startActivity(intent);
                dialog.cancel();
            }
        });
        // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        AlertDialog dialogConfirm = builder2.create();

        /*Clothes Type Spinner*/
        clothesTypeSpinnerActivity = new ClothesTypeSpinnerActivity();

        clothesTypeSpinner = findViewById(R.id.clothes_type_spinner);
        clothesTypeSpinner.setOnItemSelectedListener(clothesTypeSpinnerActivity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.clothes_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothesTypeSpinner.setAdapter(adapter);


        /*Clothes Material Spinner*/
        clothesMaterialSpinnerActivity = new ClothesMaterialSpinnerActivity();

        clothesMaterialSpinner = findViewById(R.id.clothes_material_spinner);
        clothesMaterialSpinner.setOnItemSelectedListener(clothesMaterialSpinnerActivity);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.clothes_material_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothesMaterialSpinner.setAdapter(adapter2);

        /*Clothes Bin Location Spinner*/
        clothesBinLocationSpinnerActivity = new ClothesBinLocationSpinnerActivity();

        clothesBinLocationSpinner = findViewById(R.id.clothes_bin_location_spinner);
        clothesBinLocationSpinner.setOnItemSelectedListener(clothesBinLocationSpinnerActivity);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.clothes_bin_location_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothesBinLocationSpinner.setAdapter(adapter4);


        /*Clothes Gender Spinner*/
        clothesGenderSpinnerActivity = new ClothesGenderSpinnerActivity();

        clothesGenderSpinner = findViewById(R.id.clothes_gender_spinner);
        clothesGenderSpinner.setOnItemSelectedListener(clothesGenderSpinnerActivity);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.clothes_gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothesGenderSpinner.setAdapter(adapter3);

        submitButton = findViewById(R.id.show_capture_submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogConfirm.show();
            }
        });
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

    public class ClothesBinLocationSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

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