package com.panatlanticdev.clubnauticogt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Fotos extends AppCompatActivity {

    private ListView postListView;
    private ArrayList<Post> postList;
    private PostAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);

        postList = new ArrayList<Post>();
        postListView = (ListView) findViewById(R.id.postListView);
        adp = new PostAdapter();
        postListView.setAdapter(adp);
        loadPostList();
        System.out.println("on Create");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //loadPostList();
        System.out.println("on resume");
    }

    private void loadPostList() {

        System.out.println("load post list");
        ParseQuery<ParseObject> q = ParseQuery.getQuery("Fotos");
        q.orderByDescending("createdAt");
        q.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> li, ParseException e)
            {
                if (li != null && li.size() > 0)
                {
                    for (int i = li.size() - 1; i >= 0; i--)
                    {
                        ParseObject po = li.get(i);
                        Post c = new Post(po.getString("titulo"), po.getString("informacion"), po.getParseFile("imagen"));
                        postList.add(c);
                        adp.notifyDataSetChanged();
                    }
                }
            }
        });

    }

    private class PostAdapter extends BaseAdapter {


        @Override
        public int getCount()
        {
            return postList.size();
        }

        @Override
        public Post getItem(int arg0)
        {
            return postList.get(arg0);
        }


        @Override
        public long getItemId(int arg0)
        {
            return arg0;
        }


        @Override
        public View getView(int pos, View v, ViewGroup arg2) {
            Post c = getItem(pos);
            v = getLayoutInflater().inflate(R.layout.post, null);
            TextView titulo = (TextView) v.findViewById(R.id.tituloPostTextView);
            titulo.setText(c.getTitulo());
            TextView informacion = (TextView) v.findViewById(R.id.informacionPostTextView);
            informacion.setText(c.getInformacion());
            final ImageView imagenPost = (ImageView) v.findViewById(R.id.imagenPost);
            ParseFile fileObject = (ParseFile) c.getImagen();
            fileObject.getDataInBackground(new GetDataCallback() {
                public void done(byte[] data,
                                 ParseException e) {
                    if (e == null) {
                        Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                        imagenPost.setImageBitmap(bmp);
                    } else {
                        Log.d("test", "There was a problem downloading the data.");
                    }
                }
            });



            return v;
        }

    }

}
