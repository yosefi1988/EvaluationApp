package ir.sajjadyosefi.evaluation.activity.evaluation;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.OutputStream;

import ir.sajjadyosefi.evaluation.R;
import ir.sajjadyosefi.evaluation.classes.activity.TubelessActivity;
import ir.sajjadyosefi.evaluation.classes.wiget.DrawableImageView;

public class SignatureActivity extends TubelessActivity  implements View.OnClickListener{

    DrawableImageView choosenImageView;

    Button savePicture;
    Button redButton;

    Bitmap bmp;
    Bitmap alteredBitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);

        choosenImageView = (DrawableImageView) this.findViewById(R.id.ChoosenImageView);

        savePicture = (Button) this.findViewById(R.id.SavePictureButton);
        redButton = (Button) this.findViewById(R.id.redButton);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
                    bmpFactoryOptions.inJustDecodeBounds = true;
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.png_image);
                    bmpFactoryOptions.inJustDecodeBounds = false;
                    bmp = BitmapFactory.decodeResource(getResources(), R.drawable.png_image);
                    alteredBitmap = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), bmp.getConfig());
                    choosenImageView.setNewImage(alteredBitmap,bmp);
                }
                catch (Exception e) {
                    Log.v("ERROR", e.toString());
                }
            }
        });

        savePicture.setOnClickListener(this);





        try {
            BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
            bmpFactoryOptions.inJustDecodeBounds = true;
            bmp = BitmapFactory.decodeResource(getResources(), R.drawable.png_image);
            bmpFactoryOptions.inJustDecodeBounds = false;
            bmp = BitmapFactory.decodeResource(getResources(), R.drawable.png_image);
            alteredBitmap = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), bmp.getConfig());
            choosenImageView.setNewImage(alteredBitmap,bmp);
        }
        catch (Exception e) {
            Log.v("ERROR", e.toString());
        }

    }

    public void onClick(View v){
        if (v == savePicture)
        {
            if (alteredBitmap != null)
            {
                ContentValues contentValues = new ContentValues(3);
                contentValues.put(MediaStore.Audio.Media.DISPLAY_NAME, "Draw On Me");


                Uri imageFileUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                try {
                    OutputStream imageFileOS = getContentResolver()
                            .openOutputStream(imageFileUri);
                    alteredBitmap
                            .compress(Bitmap.CompressFormat.JPEG, 90, imageFileOS);
                    Toast t = Toast
                            .makeText(this, "Saved!", Toast.LENGTH_SHORT);
                    t.show();

                } catch (Exception e) {
                    Log.v("EXCEPTION", e.getMessage());
                }
            }
        }
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == RESULT_OK) {
            Uri imageFileUri = intent.getData();
            try {
                BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
                bmpFactoryOptions.inJustDecodeBounds = true;
                bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageFileUri), null, bmpFactoryOptions);

                bmpFactoryOptions.inJustDecodeBounds = false;
                bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageFileUri), null, bmpFactoryOptions);

                alteredBitmap = Bitmap.createBitmap(bmp.getWidth(),bmp.getHeight(), bmp.getConfig());



                choosenImageView.setNewImage(alteredBitmap, bmp);
            }
            catch (Exception e) {
                Log.v("ERROR", e.toString());
            }
        }
    }
}