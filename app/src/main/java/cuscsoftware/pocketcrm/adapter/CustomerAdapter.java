package cuscsoftware.pocketcrm.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;

import cuscsoftware.pocketcrm.R;
import cuscsoftware.pocketcrm.model.Customer;

/**
 * Created by Lam Thanh Huy on 2017/06/08.
 */

public class CustomerAdapter extends android.widget.ArrayAdapter<Customer> {
    private Context context;
    private int resource;
    private List<Customer> customers;

    public class ViewHolder {
        TextView tvName, tvNumberPhone;
        ImageView imAvatar;

    }

    public CustomerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Customer> customers) {
        super(context, resource, customers);
        this.context = context;
        this.resource = resource;
        this.customers = customers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.customer_list, parent, false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imAvatar);
            imageView.setImageResource(R.drawable.customer_default_avatar);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvNumberPhone = (TextView) convertView.findViewById(R.id.tvPhoneNumber);
            //viewHolder.imAvatar = (ImageView) convertView.findViewById(R.id.imAvatar);
            viewHolder.imAvatar = imageView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Customer customer = customers.get(position);
        //viewHolder.tvAvatar.setBackgroundColor();
        //viewHolder.imAvatar.;
        viewHolder.tvName.setText(customer.getName());
        viewHolder.tvNumberPhone.setText(customer.getPhoneNumber());
        Bitmap bm = BitmapFactory.decodeByteArray(customer.getPhoto(), 0, customer.getPhoto().length);
        viewHolder.imAvatar.setImageBitmap(bm);
        return convertView;
    }
}
