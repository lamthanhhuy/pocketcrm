package cuscsoftware.pocketcrm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2017/06/11.
 */

public class CustomerDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "PocketCrm.db";
    public CustomerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createCustomerTable = "CREATE TABLE `customer` (\n" +
                "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`name`\tVARCHAR(50) NOT NULL,\n" +
                "\t`phone`\tVARCHAR(50),\n" +
                "\t`address`\tVARCHAR(250),\n" +
                "\t`location`\tVARCHAR(50),\n" +
                "\t`sort`\tINTEGER DEFAULT \"0\"\n" +
                ");";
        db.execSQL(createCustomerTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS customer");
        onCreate(db);
    }
}
