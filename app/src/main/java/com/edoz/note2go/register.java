package com.edoz.note2go;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    TextView registrar;
    EditText correo, pass, reppass;
    String str_correo, str_pass,str_reppass;
    String url = "https://appandroidnotetogo.000webhostapp.com/loginphp/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registrar = findViewById(R.id.registrar);
        correo = findViewById(R.id.registerCorreo);
        pass = findViewById(R.id.registerPass);
        reppass = findViewById(R.id.registerReppass);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registro();
            }
        });
    }


    private void registro(){
        final ProgressDialog progressDialog = new ProgressDialog(register.this);
        progressDialog.setMessage("Registrando ... ");

        if (correo.getText().toString().equals("") || pass.getText().toString().equals("") || reppass.getText().toString().equals("")){
            Toast.makeText(register.this, "Llene los campos", Toast.LENGTH_SHORT).show();
        }else if(!pass.getText().toString().equals(reppass.getText().toString())){
            Toast.makeText(register.this, "Las contrasenas no coinciden", Toast.LENGTH_SHORT).show();
        } else {

            progressDialog.show();
            str_correo = correo.getText().toString().trim();
            str_pass = pass.getText().toString().trim();
            str_reppass = reppass.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Datos insertados")){

                                Toast.makeText(register.this, "Datos insertados", Toast.LENGTH_SHORT).show();

                                progressDialog.dismiss();

                                Intent intent=new Intent(register.this,MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(register.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                Toast.makeText(register.this, "No se puede insrtar", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(register.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    params.put("correo",str_correo);
                    params.put("pass",str_pass);

                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(register.this);
            requestQueue.add(request);

        }

        }
    };
