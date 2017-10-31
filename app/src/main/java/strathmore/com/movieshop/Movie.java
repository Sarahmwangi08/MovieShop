package strathmore.com.movieshop;

/**
 * Created by nyama on 30/10/2017.
 */

public class Movie {
    int _id;
    String _name;
    String _description;
    String _genre;

    Movie() {}



    public Movie (int id, String name, String description, String genre) {
        this._id = id;
        this._name = name;
        this._description = description;
        this._genre = genre;

    }

    public Movie(String name, String _description, String _genre) {
        this._name = name;
        this._description = _description;
        this._genre = _genre;

    }

    //getting ID
    public int getID() {
        return this._id;
    }

    // setting ID
    public void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getName() {
        return this._name;
    }

    // setting Name
    public void setName(String name) {
        this._name = name;
    }

    // getting description
    public String get_Description() {
        return this._description;
    }

    //setting description
    public void set_Description(String _description) {
        this._description = _description;
    }

    // getting genre
    public String get_Genre() {
        return this._genre;
    }

    //setting genre
    public void set_Genre(String _genre) {
        this._genre = _genre;
    }
}
