package strathmore.com.movieshop;

/**
 * Created by nyama on 30/10/2017.
 */

public class NewM {
    int _id;
    String _name;
    String _description;
    String _genre;


    NewM() {}

    public NewM (int id, String name, String description, String genre) {
        this._id = id;
        this._name = name;
        this._description = description;
        this._genre = genre;
    }
    public NewM (String name, String _description, String _genre) {
        this._name = name;
        this._description = _description;
        this._genre = _genre;
    }

    public int get_id() {
        return  this._id;
    }

    public void set_id(int id) {
        this._id = id;
    }

    public String get_name() {
      return this._name;
    }

    public void set_name (String name) {
        this._name = name;
    }

    public String get_description () {
        return this._description;
    }

    public void set_description (String description) {
         this._description =description;
    }
    public String get_genre () {
        return this._description;
    }

    public void set_genre (String description) {
        this._description = description;
    }


}
