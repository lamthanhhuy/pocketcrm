package cuscsoftware.pocketcrm.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import cuscsoftware.pocketcrm.db.CustomerDbHelper;
import cuscsoftware.pocketcrm.db.Customer.CustomerEntry;

/**
 * Created by Lam Thanh Huy on 2017/06/08.
 */

public class CustomerManager {
    private CustomerDbHelper customerDbHelper;
    public CustomerManager(Context context)
    {
        customerDbHelper = new CustomerDbHelper(context);
    }
    public ArrayList<Customer> loadCustomers()
    {
        String sql = "SELECT name, phone, photo FROM customer";
        SQLiteDatabase db = customerDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        if (cursor.moveToFirst()) {
            do {
                Customer customer = new Customer(cursor.getString(0), cursor.getString(1), cursor.getBlob(2));
                customers.add(customer);

            }while (cursor.moveToNext());
        }

        return  customers;
    }

    public void add(Customer customer)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CustomerEntry.COLUMN_NAME_NAME, customer.getName());
        contentValues.put(CustomerEntry.COLUMN_NAME_PHONE, customer.getPhoneNumber());
        contentValues.put(CustomerEntry.COLUMN_NAME_PHOTO, customer.getPhoto());
        SQLiteDatabase db = customerDbHelper.getWritableDatabase();
        db.insert(CustomerEntry.TABLE_NAME, null, contentValues);
    }
}
