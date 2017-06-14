package sophia.com.rubrica;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ShowContactActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView lastnameTextView;
    private TextView nicknameTextView;
    private TextView phoneTextView;
    private TextView mobileTextView;
    private TextView emailTextView;
    public ImageButton callButton2;
    public ImageButton messagButton2;
    public ImageButton emailgButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);

        nameTextView = (TextView) findViewById(R.id.name);
        lastnameTextView = (TextView) findViewById(R.id.lastname);
        nicknameTextView = (TextView) findViewById(R.id.nickname);
        phoneTextView = (TextView) findViewById(R.id.phone);
        mobileTextView = (TextView) findViewById(R.id.mobile);
        emailTextView = (TextView) findViewById(R.id.email);
        callButton2 = (ImageButton) findViewById(R.id.callButton2);
        messagButton2 = (ImageButton) findViewById(R.id.messagButton2);
        emailgButton2 = (ImageButton) findViewById(R.id.emailgButton2);

        Bundle extras = getIntent().getExtras();
        if (extras != null){

            int position = extras.getInt("position");




            String name = extras.getString("name");
            String lastname = extras.getString("lastname");
            String nickname = extras.getString("nickname");
            final String phone = extras.getString("phone");
            final String mobile = extras.getString("mobile");
            final String email = extras.getString("email");


            nameTextView.setText(name);
            lastnameTextView.setText(lastname);
            nicknameTextView.setText(nickname);
            phoneTextView.setText(phone);
            mobileTextView.setText(mobile);
            emailTextView.setText(email);
            callButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                    if (ActivityCompat.checkSelfPermission(ShowContactActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
            });

            messagButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + mobile));
                    startActivity((intent));
                }
            });

            emailgButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mail:" + email));
                    startActivity(intent);
                }
            });


        }



    }
}
