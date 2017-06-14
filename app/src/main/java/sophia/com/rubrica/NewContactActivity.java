package sophia.com.rubrica;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import sophia.com.rubrica.data.Contact;

public class NewContactActivity extends AppCompatActivity {

    private TextInputLayout name;
    private TextInputLayout lastname;
    private TextInputLayout nickname;
    private TextInputLayout phone;
    private TextInputLayout mobile;
    private TextInputLayout email;

    private Button buttonSave;

    private Contact contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextInputLayout) findViewById(R.id.name);
        lastname = (TextInputLayout) findViewById(R.id.lastname);
        nickname = (TextInputLayout) findViewById(R.id.nickname);
        phone = (TextInputLayout) findViewById(R.id.phone);
        mobile = (TextInputLayout) findViewById(R.id.mobile);
        email = (TextInputLayout) findViewById(R.id.email);

        Button buttonSave = (Button) findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact = new Contact(
                        name.getEditText().getText().toString(),
                        lastname.getEditText().getText().toString(),
                        nickname.getEditText().getText().toString(),
                        phone.getEditText().getText().toString(),
                        mobile.getEditText().getText().toString(),
                        email.getEditText().getText().toString()
                );

                    Log.d("contact", contact.toString());
            }
        });
    }
}
