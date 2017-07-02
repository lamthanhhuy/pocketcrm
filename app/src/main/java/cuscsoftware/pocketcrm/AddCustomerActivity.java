package cuscsoftware.pocketcrm;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cuscsoftware.pocketcrm.model.Customer;
import cuscsoftware.pocketcrm.model.CustomerManager;

public class AddCustomerActivity extends Activity {

    private View view;
    TextView tvName;
    TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        tvName = (TextView) findViewById(R.id.name);
        tvPhone = (TextView) findViewById(R.id.phone);
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
        customerManager.add(new Customer(tvName.getText().toString(), tvPhone.getText().toString()));
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

}
