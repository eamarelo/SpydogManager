package fr.mydigitalschool.spydogmanager.activity;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import fr.mydigitalschool.spydogmanager.R;

public class ConnectActivity extends AppCompatActivity {
    private final String URL = "http://5.51.221.85:1337/users/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        final EditText pwd   = (EditText)findViewById(R.id.et_main_password);
        final EditText email   = (EditText)findViewById(R.id.et_main_email);
        final TextView tv_error = (TextView) findViewById( R.id.tv_main_error );


        final Button registerButton = (Button) findViewById(R.id.btn_main_register);
        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ConnectActivity.this, RegisterActivity.class);
                startActivity(intent);
            }

        });
        final Button loginButton = (Button) findViewById(R.id.btn_main_login);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(ConnectActivity.this);
                String url ="http://5.51.221.85:1337/api/auth/login";


                StringRequest postRequest = new StringRequest( Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Log.d("test:", response);
                                Intent intent = new Intent(ConnectActivity.this, ListVictimeActivity.class);
                                startActivity(intent);
                                //tvGET.setText("Response is: "+ response);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                tv_error.setText( "erreur dans le formulaire de connection" );
                                Log.d("Error.Response", String.valueOf( error ) );
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();

                        params.put("password", pwd.getText().toString());
                        params.put("email", email.getText().toString());

                        return params;
                    }

                };

                queue.add(postRequest);

            }

    });
    }


    public void activityregister(View view) {
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
