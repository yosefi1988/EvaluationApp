package ir.sajjadyosefi.evaluation.classes.libraries.tofiraImagePicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import static com.yalantis.ucrop.UCrop.REQUEST_CROP;

//import static com.yalantis.ucrop.UCrop.REQUEST_CROP;


public class TempActivity extends Activity {

    PickerManager pickerManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.pickerManager = GlobalHolder.getInstance().getPickerManager();
        this.pickerManager.setActivity(TempActivity.this);
        this.pickerManager.pickPhotoWithPermission();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            finish();
            return;
        }
        switch (requestCode) {
            case PickerManager.REQUEST_CODE_SELECT_IMAGE:
                Uri uri;
                if (data != null)
                    uri = data.getData();
                else
                    uri = pickerManager.getImageFile();

                pickerManager.setUri(uri);
                pickerManager.startCropActivity();
                break;
            case REQUEST_CROP:
                if (data != null) {
                    pickerManager.handleCropResult(data);
                } else
                    finish();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == PickerManager.REQUEST_CODE_IMAGE_PERMISSION)
            pickerManager.handlePermissionResult(grantResults);
        else
            finish();

    }

}