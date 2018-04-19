package codingwithmitch.com.recyclerview;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    private  String [] mDrawerTitle = {"History", "Colours and badge", "Stadium", "Support", "Ownership and finances", "Liverpool in popular culture", "Players", "Club officials", "Honours", "References"};
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ListView mListView;
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
        mDrawerLayout = findViewById(R.id.drawer_layout);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
//                mDrawerLayout,
//                R.string.open_drawer,
//                R.string.close_drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,R.string.open_drawer,R.string.close_drawer);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = findViewById(R.id.drawer);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_list_item_1,mDrawerTitle );
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) mListView.getItemAtPosition(position);

                mDrawerLayout.closeDrawers();
                Toast.makeText(getApplicationContext(),
                        "Go" + " to " + itemValue + " !!!!!", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId()) {
            case R.id.mnuNew:
                Toast.makeText(this, "New Profile!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnuOpen:
                Toast.makeText(this, "UEFA Champions League!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnuHelp:
                Toast.makeText(this, "Help!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("http://givemesport.azureedge.net/images/18/02/11/cffd64648da49950386a10dcc6bdf511/960.jpg");
        mNames.add("Loris Karius");

        mImageUrls.add("http://e0.365dm.com/17/12/16-9/20/skysports-premier-league-football-trent-alexander-arnold-trent-alexander-arnold_4192491.jpg?20171226190902");
        mNames.add("Trent Alexander-Arnold");

        mImageUrls.add("https://cdn.images.express.co.uk/img/dynamic/67/590x/Virgil-van-Dijk-904489.jpg");
        mNames.add("Virgil Van Dijk");

        mImageUrls.add("https://d3j2s6hdd6a7rg.cloudfront.net/v2/uploads/media/default/0001/43/thumb_42725_default_news_size_5.jpeg");
        mNames.add("Joël Matip");

        mImageUrls.add("https://cdn.images.dailystar.co.uk/dynamic/58/photos/547000/620x/Andy-Robertson-Liverpool-652850.jpg");
        mNames.add("Andrew Robertson");


        mImageUrls.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2018/02/04/16/henderson.jpg");
        mNames.add("Jordan Henderson");

        mImageUrls.add("https://www.thisisanfield.com/wp-content/uploads/P170913-074-Liverpool_Seville-e1505337388786-600x401.jpg");
        mNames.add("Alex Oxlade-Chamberlain");

        mImageUrls.add("https://i2.wp.com/draftfantasyfootball.co.uk/content/wp-content/uploads/2017/08/jamesmilner-cropped_18qsw5185s9lt1jogq9rvx986d.jpg?resize=1280%2C640&ssl=1");
        mNames.add("James Milner");

        mImageUrls.add("http://givemesport.azureedge.net/images/17/11/21/2df4f758aa8c0dacfa6468a3357be642/960.jpg");
        mNames.add("Mohamed Salah");

        mImageUrls.add("https://img.maximummedia.ie/joe_co_uk/eyJkYXRhIjoie1widXJsXCI6XCJodHRwOlxcXC9cXFwvbWVkaWEtam9lY291ay5tYXhpbXVtbWVkaWEuaWUuczMuYW1hem9uYXdzLmNvbVxcXC93cC1jb250ZW50XFxcL3VwbG9hZHNcXFwvMjAxOFxcXC8wMVxcXC8xNzEzMjIxNVxcXC9HZXR0eUltYWdlcy04OTg3OTA3MTIuanBnXCIsXCJ3aWR0aFwiOjc2NyxcImhlaWdodFwiOjQzMSxcImRlZmF1bHRcIjpcImh0dHBzOlxcXC9cXFwvd3d3LmpvZS5jby51a1xcXC9hc3NldHNcXFwvaW1hZ2VzXFxcL2pvZWNvdWtcXFwvbm8taW1hZ2UucG5nP3Y9NVwifSIsImhhc2giOiI0MTAwNjQ5N2M4NTlkYzAwMWQwOTViYTNmZTJmNGExNWI3YmRjY2U5In0=/gettyimages-898790712.jpg");
        mNames.add("Roberto Firmino");

        mImageUrls.add("http://cdn.empireofthekop.com/wp-content/uploads/2018/02/mane-picture-640x384.jpg");
        mNames.add("Sadio Mané");

        mImageUrls.add("http://e2.365dm.com/18/01/16-9/20/skysports-jurgen-klopp-liverpool-swansea_4212383.jpg?20180122233458");
        mNames.add("Jürgen Klopp");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}






















