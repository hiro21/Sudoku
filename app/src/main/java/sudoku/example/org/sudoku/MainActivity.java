package sudoku.example.org.sudoku;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);

        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);

        View newButton = findViewById(R.id.new_button);
        newButton.setOnClickListener(this);

        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (R.id.setting == id) {
            startActivity(new Intent(this, Prefs.class));
            return true;
        }
        return false;
    }

    private void setOnclickListener(View v) {
        v.setOnClickListener(this);
    }


    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.about_button) {
            Intent i = new Intent(this, About.class);
            startActivity(i);
        } else if (id == R.id.new_button) {
            openNewGameDialog();
        } else if (id == R.id.exit_button) {
            finish();
        }
    }

    private void openNewGameDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game_title)
                .setItems(R.array.difficulty, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startGame(i);
                    }
                })
                .show();
    }

    private static final String TAG = "Sudoku";

    private void startGame(int i) {
        Log.d(TAG, "clicked on " + i);
    }

}
