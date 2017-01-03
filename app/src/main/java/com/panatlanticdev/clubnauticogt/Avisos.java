package com.panatlanticdev.clubnauticogt;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class Avisos extends AppCompatActivity {

    private ListView listView;
    List<ParseObject> avisosObject;
    ProgressDialog mProgressDialog;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);
        new RemoteDataTask().execute();
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(Avisos.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Listado de Avisos");
            // Set progressdialog message
            mProgressDialog.setMessage("Cargando...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Locate the class table named "Country" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Avisos");
            query.orderByDescending("createdAt");
            try {
                avisosObject = query.find();
            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listView = (ListView) findViewById(R.id.listView2);
            // Pass the results into an ArrayAdapter
            adapter = new ArrayAdapter<String>(Avisos.this,R.layout.single_aviso);
            // Retrieve object "name" from Parse.com database
            for (ParseObject country : avisosObject) {
                adapter.add((String) country.get("titulo"));
            }
            // Binds the Adapter to the ListView
            listView.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
            // Capture button clicks on ListView items
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // Send single item click data to SingleItemView Class
                    Intent i = new Intent(Avisos.this, VistaAviso.class);
                    // Pass data "name" followed by the position
                    i.putExtra("tituloAviso", avisosObject.get(position).getString("titulo").toString());
                    i.putExtra("infoAviso", avisosObject.get(position).getString("informacion").toString());
                    // Open SingleItemView.java Activity
                    startActivity(i);
                }
            });
        }
    }
}
