package sophia.com.rubrica.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sophia.com.rubrica.R;
import sophia.com.rubrica.data.Contact;

/**
 * Created by archimede on 16/05/17.
 */

public class ContactListAdapter extends BaseAdapter {
    private Context ctx;
    private List<Contact> contactList;

    public ContactListAdapter(Context ctx, List<Contact> contactList) {
        this.ctx = ctx;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList == null ? 0 : contactList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return contactList == null ? null : contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contactList == null ? 0 : contactList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextHolder th = null;
        if (v == null) {
            LayoutInflater linf = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = linf.inflate(R.layout.contact_list_row, null);
            TextView fullname = (TextView) v.findViewById(R.id.fullName);
            TextView phone = (TextView) v.findViewById(R.id.phone);
            th = new TextHolder();
            th.fullname = fullname;
            th.phone = phone;
            v.setTag(th);
        }
        else
            th = (TextHolder) v.getTag();

        //String fullname = contactList.get(position).getName() + " " + contactList.get(position).getLastname();

        //th.fullname.setText(fullname);

        th.fullname.setText(contactList.get(position).getFullname());
        th.phone.setText(contactList.get(position).getPhone());
        return  v;


    }

    static class TextHolder {

        TextView fullname;
        TextView phone;

    }
}
