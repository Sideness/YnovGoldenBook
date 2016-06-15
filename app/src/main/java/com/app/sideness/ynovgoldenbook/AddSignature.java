package com.app.sideness.ynovgoldenbook;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddSignature extends AppCompatActivity {

    String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_signature);

        final EditText etNom = (EditText) findViewById(R.id.etNom);
        final EditText etMessage = (EditText) findViewById(R.id.etMessage);
        final Button btPhoto = (Button) findViewById(R.id.btPhoto);
        btPhoto.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dispatchTakePictureIntent();
                if(mCurrentPhotoPath != null){
                    btPhoto.setEnabled(false);
                }
            }
        });

        Button btFinish = (Button) findViewById(R.id.btFinish);
        btFinish.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(etMessage.getText().toString().length() > 0 && etNom.getText().toString().length() > 0
                        && mCurrentPhotoPath != null){
                    String[] result = new String[3];
                    result[0] = etNom.getText().toString();
                    result[1] = etMessage.getText().toString();
                    result[2] = mCurrentPhotoPath;

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",result);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Tous les champs ne sont pas remplis !", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    static final int REQUEST_TAKE_PHOTO = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }
}
