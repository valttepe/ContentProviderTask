package com.example.valtteri.contentprovidertask;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;

public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
       return null;
    }

    @Override
    public boolean onCreate() {
        Log.i("Does", "it come here");

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        Log.i("did" , "this work somehow");
        President[] press = {
                new President("Stahlberg, Kaarlo Juho", "1919-1925", "First one"),
                new President("Relander, Lauri Kristian", "1925-1931", "Second one"),
                new President("Svinhufvud, Pehr Evind", "1931-1937", "Third one"),
                new President("Kallio, Kyosti", "1937-1940", "Fourth one"),
                new President("Ryti, Risto Heikki", "1940-1944", "Fifth one"),
                new President("Mannerheim, Carl Gustav Emil", "1944-1946", "Sixth one"),
                new President("Paasikivi, Juho Kusti", "1946-1956", "Seventh one"),
                new President("Kekkonen, Urho Kaleva", "1956-1982", "Eighth one"),
                new President("Koivisto, Mauno Henrik", "1982-1994", "Ninth one"),
                new President("Ahtisaari, Martti Oiva Kalevi", "1994-2000", "Tenth one"),
                new President("Halonen, Tarja Kaarina", "2000-2012", "Eleventh one")
        };

        MatrixCursor cursor = new MatrixCursor(new String[]{"_id", "name","years"});
        int test = 0;

        while( press.length > test) {
            Log.i("show", press[test].name);
            cursor.addRow(new Object[]{test, press[test].name, press[test].years});
            test ++;
        }



        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        return 0;
    }
}
