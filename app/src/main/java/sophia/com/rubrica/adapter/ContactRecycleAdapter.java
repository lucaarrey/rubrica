package sophia.com.rubrica.adapter;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import sophia.com.rubrica.R;
import sophia.com.rubrica.data.Contact;

/**
 * Created by archimede on 23/05/17.
 */

public class ContactRecycleAdapter extends RecyclerView.Adapter<ContactRecycleAdapter.ViewHolder> {

    private List<Contact> contactList;
    private Context context;
    private OnAdapterItemClickListner listner;

    public ContactRecycleAdapter(Context context, List<Contact> contactList){
        this.contactList = contactList;
        this.context = context;
        this.listner = (OnAdapterItemClickListner)context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_row, parent, false);

        TextView fullname = (TextView) v.findViewById(R.id.fullName);//a) procedimento, passo 3
        TextView phone = (TextView) v.findViewById(R.id.phone);
        ImageButton callButton = (ImageButton) v.findViewById(R.id.callButton);//b) procedimento, passo 2
        ImageButton messageButton = (ImageButton) v.findViewById(R.id.messagButton);
        ImageButton emailgButton = (ImageButton) v.findViewById(R.id.emailgButton);
        ViewHolder vh = new ViewHolder(v,fullname, phone);////(a) procedimento, passo 4

        vh.callButton = callButton;//b) procedimento, passo 3 (perchè callbutton dichiarata come variabile pubblica
        vh.messagButton = messageButton;
        vh.emailgButton = emailgButton;

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OnClickListner", v.getTag().toString());

                if(listner != null) {
                    listner.OnItemClick((int) v.getTag()) ;
                }

            }
        });

        vh.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OnItemOnCall", v.getTag().toString());

                if(listner != null) {
                    listner.OnItemPhoneClick((int) v.getTag());
                }
            }

        });

        vh.messagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("message", v.getTag().toString());

                if(listner != null) {
                    listner.OnItemMessageClick((int) v.getTag());
                }
            }

        });

        vh.emailgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(listner != null) {
                    listner.OnItemEmailClick((int) v.getTag());

                }
            }
        });

        return vh;



    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.fullName.setText(contactList.get(position).getFullname());
        holder.phone.setText(contactList.get(position).getPhone());

        holder.itemView.setTag(position);
        holder.callButton.setTag(position);
        holder.messagButton.setTag(position);
        holder.emailgButton.setTag(position);


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView fullName;//(a) procedimento con passaggio al costruttore, passo 1
        public TextView phone;
        public ImageButton callButton;//(n) procedimento senza passaggio al costruttore, passo 1
        public ImageButton messagButton;
        public ImageButton emailgButton;

        public ViewHolder(final View container, TextView v, TextView v2) {
            super(container);
            fullName = v;//(a) procedimento, passo 2
            phone = v2;




        }
    }
}