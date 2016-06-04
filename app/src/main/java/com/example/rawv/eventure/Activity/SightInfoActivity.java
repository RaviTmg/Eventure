package com.example.rawv.eventure.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.rawv.eventure.AnimatImg;
import com.example.rawv.eventure.Fragments.MainObject;
import com.example.rawv.eventure.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SightInfoActivity extends AppCompatActivity {

    int[] comment = {R.string.comm1, R.string.comm2, R.string.comm3};
    String[] name = {"Ravi tamang", "Nimus Shrestha", "Madhav", "kiran tiwari"};
    String[] date = {"1 hrs ago", "1 day ago", "2 days ago", "2 days ago"};

    public List<CommentObject> getObjectList() {
        List<CommentObject> objectAdvenList = new ArrayList<>();
        for (int i = 0; i < comment.length; i++) {
            objectAdvenList.add(new CommentObject(comment[i], name[i], date[i]));
        }
        return objectAdvenList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String name_of_place = null;
        int img_of_place = 0;
        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle == null) {
                name_of_place = null;
                img_of_place = 0;
            } else {
                name_of_place = bundle.getString("NAME_OF_PLACE");
                img_of_place = bundle.getInt("IMAGE_OF_PLACE");
            }
        }
        if (toolbar != null) {
            getSupportActionBar().setTitle(name_of_place);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Add to visit list?", Snackbar.LENGTH_LONG)
                            .setAction("ok", null).show();
                }
            });
        }

        AnimatImg imageSight = (AnimatImg) findViewById(R.id.img_sight_info);
        assert imageSight != null;
        imageSight.setResourceIds(img_of_place, img_of_place);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_comment);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager grd = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(grd);
        recyclerView.setAdapter(new CommentAdapter(getObjectList(), getApplicationContext()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_info_share:
                Toast.makeText(getApplicationContext(), "Share :)", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
