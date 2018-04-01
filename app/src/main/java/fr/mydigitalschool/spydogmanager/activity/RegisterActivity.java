package fr.mydigitalschool.spydogmanager.activity;

import android.content.Intent;
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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register);
        final EditText pwd   = (EditText)findViewById(R.id.et_register_password);
        final EditText login   = (EditText)findViewById(R.id.et_register_name);
        final EditText email   = (EditText)findViewById(R.id.et_register_email);
        final Button registerButton = (Button) findViewById(R.id.btn_register_register);
        final TextView tv_error = (TextView) findViewById( R.id.tv_register_error );
        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                String url ="http://5.51.221.85:1337/api/auth/register";


                StringRequest postRequest = new StringRequest( Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Log.d(":", response);
                                Intent intent = new Intent(RegisterActivity.this, ConnectActivity.class);
                                startActivity(intent);
                                //tvGET.setText("Response is: "+ response);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                tv_error.setText( "erreur dans le formulaire d'inscription" );
                                Log.d("Error.Response", String.valueOf( error ) );
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();

                    params.put("password", pwd.getText().toString());
                    params.put("name", login.getText().toString());
                    params.put("email", email.getText().toString());

                        return params;
                    }
                };

                queue.add(postRequest);

            }
        });


    }


}
