package strathmore.com.movieshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nyama on 30/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "movie_shop";
    public static String TABLE_MOVIE = "movies";
    public static String TABLE_NEWM = "new";

    public static final String KEY_ID = "ID";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_DESCRIPTION = "DESCRIPTION";
    public static final String KEY_GENRE = "GENRE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATE_MOVIE_TABLE = "CREATE TABLE" + TABLE_MOVIE + "("
            + KEY_ID + "INTEGER PRIMARY KEY," + KEY_NAME + "TEXT," + KEY_DESCRIPTION + "TEXT" + KEY_GENRE + "TEXT" + ")";

    private static final String CREATE_NEWM_TABLE = "CREATE TABLE" + TABLE_NEWM + "("
            + KEY_ID + "INTEGER PRIMARY KEY," + KEY_NAME + "TEXT," + KEY_DESCRIPTION + "TEXT" + KEY_GENRE + "TEXT" +  ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MOVIE_TABLE);
        db.execSQL(CREATE_NEWM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_MOVIE);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NEWM);
        OnCreate(db);
    }

    private void OnCreate(SQLiteDatabase db) {
    }

    public void addMovie(Movie movie) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, movie.getName());
        values.put(KEY_DESCRIPTION, movie.get_Description());
        values.put(KEY_GENRE, movie.get_Genre());

        db.insert(TABLE_MOVIE, null, values);
        db.close();
    }

    public Movie getMovie(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MOVIE, new String[]{
                KEY_ID, KEY_NAME,KEY_DESCRIPTION,KEY_GENRE }, KEY_ID + "=+", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Movie movie = new Movie(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return movie;
    }

    public List<Movie> getAllMovies() {

        List<Movie> movieList = new ArrayList<Movie>();
        // select all query
        String selectQuery = "SELECT  *  FROM " + TABLE_MOVIE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Movie movie = new Movie();
                movie.setID(Integer.parseInt(cursor.getString(0)));
                movie.setName(cursor.getString(1));
                movie.set_Description(cursor.getString(2));
                movie.set_Genre(cursor.getString(3));

                // Adding movie to list
                movieList.add(movie);
            } while (cursor.moveToNext());
        }
        // return movie list
        return movieList;
    }

    public int getmovieCount() {
        String countQuery = "SELECT * FROM " + TABLE_MOVIE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();
    }

    public int updateMovie(Movie movie) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, movie.getName());
        values.put(KEY_DESCRIPTION, movie.get_Description());
        values.put(KEY_GENRE, movie.get_Genre());

        // updating row
        return db.update(TABLE_MOVIE, values, KEY_ID + " = ?",
                new String[]{String.valueOf(movie.getID())});
    }

    public void deleteMovie(Movie movie) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MOVIE, KEY_ID + " = ?",
                new String[]{String.valueOf(movie.getID())});
        db.close();
    }

    // creating the new table values
    public void addNewM(NewM newm) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, newm.get_name());
        values.put(KEY_DESCRIPTION, newm.get_description());
        values.put(KEY_GENRE, newm.get_genre());

        db.insert(TABLE_NEWM, null, values);
        db.close();

    }
    public NewM getNewM(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NEWM, new String [] {
                KEY_ID,  KEY_NAME,KEY_DESCRIPTION,KEY_GENRE},  KEY_ID + "=+", new String[] {String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        NewM newm = new NewM(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return newm;
    }

    public List<NewM> getAllNewm() {

        List<NewM> newmList = new ArrayList<NewM>();
        // select all query
        String selectQuery = "SELECT  *  FROM " + TABLE_NEWM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                NewM newm = new NewM();
                newm.set_id(Integer.parseInt(cursor.getString(0)));
                newm.set_name(cursor.getString(1));
                newm.set_description(cursor.getString(2));
                newm.set_genre(cursor.getString(3));

                // Adding movie to list
                newmList.add(newm);
            } while (cursor.moveToNext());
        }
        // return newm list
        return newmList;
    }

    public int getnewmCount() {
        String countQuery = "SELECT * FROM " + TABLE_NEWM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();
    }

    public int updateNewm(NewM newm) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, newm.get_name());
        values.put(KEY_DESCRIPTION, newm.get_description());
        values.put(KEY_GENRE, newm.get_genre());

        // updating row
        return db.update(TABLE_NEWM, values, KEY_ID + " = ?",
                new String[]{String.valueOf(newm.get_id())});
    }

    public void deleteNewm(NewM newm) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NEWM, KEY_ID + " = ?",
                new String[]{String.valueOf(newm.get_id())});
        db.close();
    }
}