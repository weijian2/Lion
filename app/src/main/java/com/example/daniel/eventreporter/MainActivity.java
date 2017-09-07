package com.example.daniel.eventreporter;


import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements EventFragment.OnItemSelectListener,
        CommentFragment.OnItemSelectListener {
    private EventFragment mListFragment;
    private CommentFragment mGridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Get ListView object from xml. transfer from xml object to java object
//        ListView eventListView = (ListView) findViewById(R.id.event_list);
//
//        // Initialize an adapter.
////        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
////                this,
////                R.layout.event_item,
////                R.id.event_name,
////                getEventNames());
//        EventAdapter adapter = new EventAdapter(this);
//
//        // Assign adapter to ListView.
//        eventListView.setAdapter(adapter);

//        // Show different fragments based on screen size.
//        if (findViewById(R.id.fragment_container) != null) {
//            Fragment fragment = isTablet() ? new  CommentFragment() : new EventFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
//        }

        //add list view
        mListFragment = new EventFragment();
        // add mListFragment to event_container(xml, layout)
        getSupportFragmentManager().beginTransaction().add(R.id.event_container, mListFragment).commit();


        //add Gridview
        if (isTablet()) {
            mGridFragment = new CommentFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.comment_container, mGridFragment).commit();
        }

        Log.e("Life cycle test", "We are at onCreate()");
    }

//    /**
//     * A dummy function to get fake event names.
//     *
//     * @return an array of fake event names.
//     */
//    private String[] getEventNames() {
//        String[] names = {
//                "Event1", "Event2", "Event3",
//                "Event4", "Event5", "Event6",
//                "Event7", "Event8", "Event9",
//                "Event10", "Event11", "Event12"};
//        return names;
//    }
    // template to judge it is a tablet or not
    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }

    @Override
    public void onItemSelected(int position) {
        mGridFragment.onItemSelected(position);
    }

    @Override
    public void onCommentSelected(int position) {
        mListFragment.onItemSelected(position);
    }

}
