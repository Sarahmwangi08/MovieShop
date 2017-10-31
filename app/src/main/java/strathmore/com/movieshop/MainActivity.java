package strathmore.com.movieshop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        DatabaseHelper db = new DatabaseHelper(this);


        //inserting movies
        Log.d("Insert: ", "Inserting ..");
        db.addMovie(new Movie("Problem Child", "The story of a seven-year-old mischievous orphan boy named Junior. He is hardly a model child; mean-spirited and incorrigible.", "Comedy"));
        db.addMovie(new Movie("Matilda", "Matilda Wormwood is an exquisite and intelligent little girl. Unfortunately, Matilda is misunderstood by her family because she is very different from their ways of life.", "Adventure"));
        db.addMovie(new Movie("Cars", "While traveling to California for the dispute of the final race of the Piston Cup against The King and Chick Hicks, the famous Lightning McQueen accidentally damages the road of the small town Radiator Springs", "Animation"));
        db.addMovie(new Movie("Coraline", "When Coraline moves to an old house, she feels bored and neglected by her parents. She finds a hidden door with a bricked up passage.", "Animation"));

        //Reading all movies
        Log.d("Reading: ", "Reading all movies..");
        List<Movie> movie = db.getAllMovies();

        for (Movie mv : movie) {
            String log = "Id: " + mv.getID() + ",Name: " + mv.getName() + ", Description: " + mv.get_Description() + ", Genre: " + mv.get_Genre();

            // Writing movies on log
            Log.d("Name: ", log);


            // inserting new movies
            Log.e("Insert: ", "Inserting ..");
            db.addNewM(new NewM("Black Panther", "T'Challa, after the death of his father, the King of Wakanda, returns home to the isolated, technologically advanced African nation to succeed to the throne and take his rightful place as king.", "Action"));
            db.addNewM(new NewM("Marvel Infinity War", "The plot is still unknown", "Action"));
            db.addNewM(new NewM("Maze Runner: The Death Cure ", "Young hero Thomas embarks on a mission to find a cure for a deadly disease known as the \"Flare\".", "Action"));
            db.addNewM(new NewM("A Wrinkle in Time", "After the disappearance of her scientist father, three peculiar beings send Meg, her brother, and her friend to space in order to find him.", "Adventure"));

            Log.d("Reading: ", "Reading all movies..");
            List<NewM> newm = db.getAllNewm();

            for (NewM nm : newm) {
                String List = "Id: " + nm.get_id() + ",Name: " + nm.get_name() + ", Description: " + nm.get_description() + ", Genre: " + nm.get_genre();

                Log.e("Name: ", log);
            }


        }


    }
}
