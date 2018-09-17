package cuscsoftware.pocketcrm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import cuscsoftware.pocketcrm.model.Customer;
import cuscsoftware.pocketcrm.model.CustomerManager;

public class AddCustomerActivity extends Activity {

    private View view;
    TextView tvName;
    TextView tvPhone;
    ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        tvName = (TextView) findViewById(R.id.name);
        tvPhone = (TextView) findViewById(R.id.phone);
        ivPhoto = (ImageView) findViewById(R.id.photo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_customer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void saveCustomerButtonClick(View view){
        CustomerManager customerManager = new CustomerManager(this);
        Bitmap bitmap = ((BitmapDrawable)ivPhoto.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] imageInByte = baos.toByteArray();
        customerManager.add(new Customer(tvName.getText().toString(), tvPhone.getText().toString(), imageInByte ));
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void changeImage(View view){
        Toast.makeText(this, "image click", Toast.LENGTH_SHORT).show();
        Intent photopicker = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(photopicker, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    ivPhoto.setImageURI(selectedImage);
                }

                break;
        }
    }

}
