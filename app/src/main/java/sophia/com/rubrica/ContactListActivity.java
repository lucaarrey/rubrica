package sophia.com.rubrica;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import sophia.com.rubrica.adapter.ContactListAdapter;
import sophia.com.rubrica.adapter.ContactRecycleAdapter;
import sophia.com.rubrica.adapter.OnAdapterItemClickListner;
import sophia.com.rubrica.data.Contact;

import static android.util.Log.d;

public class ContactListActivity extends AppCompatActivity implements OnAdapterItemClickListner {

    private Button newContact;
    private ListView contactlistView;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Contact> contactList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conact_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        //mAdapter = new MyAdapter(myDataset);
        //mRecyclerView.setAdapter(mAdapter);


        mRecyclerView.setHasFixedSize(true);


        newContact = (Button) findViewById(R.id.newContact);

        //contactlistView = (ListView) findViewById(R.id.contactlistView);


        for (int i = 0; i < 20; i++)
            contactList.add(new Contact(
                    i + " Mario",
                    i + " Rossi",
                    i + " MR",
                    i + " 05743933",
                    i + " 3459755296",
                    i + " mario.rossio@pippo.it"));


        ContactRecycleAdapter contactRecycleAdapter = new ContactRecycleAdapter(this, contactList);

        mRecyclerView.setAdapter(contactRecycleAdapter);

//        ContactListAdapter contactListAdapter = new ContactListAdapter(this, contactList);
//
//        contactlistView.setAdapter(contactListAdapter);
//
//        contactlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Log.d("ContactListActivity", contactList.get(position).getFullname());
//
//                Intent i = new Intent(ContactListActivity.this, ShowContactActivity.class);
//                i.putExtra("name", contactList.get(position).getName());
//                i.putExtra("lastname", contactList.get(position).getLastname());
//                i.putExtra("nickname", contactList.get(position).getNickname());
//                i.putExtra("phone", contactList.get(position).getPhone());
//                i.putExtra("mobile", contactList.get(position).getMobile());
//                i.putExtra("email", contactList.get(position).getEmail());
//                startActivity(i);
//
//            }
//        });

        newContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContactListActivity.this, NewContactActivity.class);
                startActivity(i);

            }
        });

    }

    @Override
    public void OnItemClick(int position) {
        Log.d("OnItemclick", "clicked position: " + position);



        Intent i = new Intent(ContactListActivity.this, ShowContactActivity.class);
                i.putExtra("name", contactList.get(position).getName());
                i.putExtra("lastname", contactList.get(position).getLastname());
                i.putExtra("nickname", contactList.get(position).getNickname());
                i.putExtra("phone", contactList.get(position).getPhone());
                i.putExtra("mobile", contactList.get(position).getMobile());
                i.putExtra("email", contactList.get(position).getEmail());
                startActivity(i);

    }

    @Override
    public void OnItemPhoneClick(int position) {
        Log.d("OnPhoneCall", "clicked position: " + contactList.get(position).getPhone());

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contactList.get(position).getPhone()));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    @Override
    public void OnItemMessageClick(int position) {
        Log.d("Onmessage","clicked position: " + position);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + contactList.get(position).getPhone()));
       startActivity((intent));

    }

    @Override
    public void OnItemEmailClick(int position) {
        Log.d("Onemail","clicked position: " + position);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + contactList.get(position).getEmail()));
        startActivity((intent));
    }
}
