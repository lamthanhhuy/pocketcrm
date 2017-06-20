package cuscsoftware.pocketcrm.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import cuscsoftware.pocketcrm.db.CustomerDbHelper;

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
        String sql = "SELECT name, phone FROM customer";
        SQLiteDatabase db = customerDbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<Customer> customers = new ArrayList<Customer>();
        if (cursor.moveToFirst()) {
            do {
                Customer customer = new Customer(cursor.getString(0), cursor.getString(1));
                customers.add(customer);

            }while (cursor.moveToNext());
        }


//        for (int i = 1; i < 50; i++) {
//            Customer customer = new Customer("Customer " + String.valueOf(i), "090123456"+String.valueOf(i));
//            customers.add(customer);
//        }
        return  customers;
    }

    public void add(Customer customer)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", customer.getName());
        SQLiteDatabase db = customerDbHelper.getWritableDatabase();
        db.insert("customer", null, contentValues);
    }
}
