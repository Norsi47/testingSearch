package onye.testingSearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.file.Paths;

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

        //needed to make search button work when pressed
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //adding database, search db when clicked
                SQLiteDatabase liteDatabase = getApplicationContext().openOrCreateDatabase(
                        "testingName.db", Context.MODE_PRIVATE, null
                );
                //adding sql query to search db
                //cursor is how the code moves in db
                Cursor cursor = liteDatabase.rawQuery("SELECT * FROM T1" , null);
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(),"No Record Found", Toast.LENGTH_LONG).show();
                    return;
                }

                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    stringBuffer.append("Name" +cursor.getString(0) + "\n");
                    stringBuffer.append("Mobile" +cursor.getString(1) + "\n");
                    stringBuffer.append("Email" +cursor.getString(2) + "\n");
                }
                Toast.makeText(getApplicationContext(), "Result \n" +stringBuffer.toString(),Toast.LENGTH_SHORT);


            }
        });

    }
}
