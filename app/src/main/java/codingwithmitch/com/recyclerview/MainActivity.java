package codingwithmitch.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://amp.thisisinsider.com/images/57bf2e72b6fa0217008b4611-750-563.jpg");
        mNames.add("Captain America");

        mImageUrls.add("https://geekandsundry.com/wp-content/uploads/2016/08/ironman-cover.jpg");
        mNames.add("Iron Man");

        mImageUrls.add("https://i.ytimg.com/vi/7p7rocHEecE/maxresdefault.jpg");
        mNames.add("Thor");

        mImageUrls.add("https://vignette.wikia.nocookie.net/hulk/images/2/22/Avengers_hulk.jpg/revision/latest?cb=20151118045112");
        mNames.add("Hulk");

        mImageUrls.add("https://www.gamestop.com/gs/images/content-pdp/gameinformer/spidermannewscreen1-610.jpg");
        mNames.add("Spiderman");


        mImageUrls.add("http://img.actucine.com/wp-content/uploads/2015/05/Black-Panther.jpg");
        mNames.add("Black Panther");

        mImageUrls.add("http://www.slashfilm.com/wp/wp-content/images/guardians2-babygroot-dancing-hottoys-frontpage-700x327.jpg");
        mNames.add("Baby Groot");

        mImageUrls.add("https://revengeofthefans.com/wp-content/uploads/2018/04/Thanos-Infinity-Stones-Movie-Future.jpg");
        mNames.add("Thanos");

        mImageUrls.add("https://news.marvel.com/wp-content/uploads/2018/03/AIW_master-960x540.jpg");
        mNames.add("Avengers: Infinity War");

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






















