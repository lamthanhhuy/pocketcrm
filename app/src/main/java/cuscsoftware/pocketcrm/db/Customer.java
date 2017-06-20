package cuscsoftware.pocketcrm.db;

import android.provider.BaseColumns;

/**
 * Created by user on 2017/06/11.
 */

public final class Customer {
    private Customer(){}
    public static class CustomerEntry implements BaseColumns {
        public static final String TABLE_NAME = "customer";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_LOCATION = "location";
    }
}
