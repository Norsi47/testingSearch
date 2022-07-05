package onye.testingSearch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {
    EditText editTextName;
    Button searchButton, deleteButton;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this should match xml file for main app UI
        setContentView(R.layout.activity_main);
        //find by id of things added in app
        //not too sure why to add (Button) and so on in
        editTextName = (EditText) findViewById(R.id.insertName);
        searchButton = (Button) findViewById(R.id.searchButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);

    }
}
