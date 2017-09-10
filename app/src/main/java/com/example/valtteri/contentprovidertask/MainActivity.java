package com.example.valtteri.contentprovidertask;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    SimpleCursorAdapter myAdapter;
    MyCursorAdapter mApapter;
    static final String[] PROJECTION = new String[] { "_id", "name", "years" };
    static final String SELECTION = "";
    static final Uri my_URI = Uri.parse("content://com.example.valtteri.contentprovidertask.presidents");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     /*   String[] fromColumns = new String[]{"name", "years"};
        int[] toViews = new int[]{R.id.president_name, R.id.president_years};

        myAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, null,
                fromColumns, toViews, 1);*/

        mApapter = new MyCursorAdapter(MainActivity.this, null, 1);



        getSupportLoaderManager().initLoader(0, null, this);


    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.i("TEST", "DOES IT CALL THIS");
        return new CursorLoader(this, my_URI,
                PROJECTION, SELECTION, null, null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mApapter.swapCursor(data);
        //myAdapter.swapCursor(data);
        Log.i("Test", data.getColumnName(1));
        ListView lv = (ListView)findViewById(android.R.id.list);
        lv.setAdapter(mApapter);
        //lv.setAdapter(myAdapter);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mApapter.swapCursor(null);
        //myAdapter.swapCursor(null);
    }

    public class MyCursorAdapter extends CursorAdapter {
        private LayoutInflater cursorInflater;

        // Default constructor
        public MyCursorAdapter(Context context, Cursor cursor, int flags) {
            super(context, cursor, flags);
            cursorInflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
        }

        public void bindView(View view, Context context, Cursor cursor) {
            TextView textViewTitle = (TextView) view.findViewById(R.id.president_name);
            TextView textYears = (TextView)view.findViewById(R.id.president_years);
            String name = cursor.getString( cursor.getColumnIndex( "name" ) );
            String year = cursor.getString(cursor.getColumnIndex("years"));
            textViewTitle.setText(name);
            textYears.setText(year);
        }

        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            // R.layout.list_row is your xml layout for each row
            return cursorInflater.inflate(R.layout.list_row, parent, false);
        }
    }


}
