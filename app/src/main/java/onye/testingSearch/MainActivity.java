package onye.testingSearch;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //need to make new how to search current one does not work

    // List View object
    ListView listView;

    // Define array adapter for ListView
    ArrayAdapter<String> adapter;

    // Define array List for List View data
    ArrayList<String> mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //not sure where this came from
        setContentView(R.layout.activity_main);

        // initialise ListView with id
//        listView = findViewById(R.id.listView);

        // Add items to Array List
        mylist = new ArrayList<>();
        mylist.add("C");
        mylist.add("C++");
        mylist.add("C#");
        mylist.add("Java");
        mylist.add("Advanced java");
        mylist.add("Interview prep with c++");
        mylist.add("Interview prep with java");
        mylist.add("data structures with c");
        mylist.add("data structures with java");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {


            // Inflate menu with items using MenuInflator
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);

            // Initialise menu item search bar
            // with id and take its object
            MenuItem searchViewItem
                    = menu.findItem(R.id.search_bar);
            SearchView searchView
                    = (SearchView) MenuItemCompat
                    .getActionView(searchViewItem);

            // attach setOnQueryTextListener
            // to search view defined above
            searchView.setOnQueryTextListener(
                    new SearchView.OnQueryTextListener() {

                        // Override onQueryTextSubmit method
                        // which is call
                        // when submitquery is searched

                        @Override
                        public boolean onQueryTextSubmit(String query) {
                            // If the list contains the search query
                            // than filter the adapter
                            // using the filter method
                            // with the query as its argument
                            if (mylist.contains(query)) {
                                adapter.getFilter().filter(query);
                            } else {
                                // Search query not found in List View
                                Toast
                                        .makeText(MainActivity.this,
                                                "Not found",
                                                Toast.LENGTH_LONG)
                                        .show();
                            }
                            return false;
                        }

                        // This method is overridden to filter
                        // the adapter according to a search query
                        // when the user is typing search
                        @Override
                        public boolean onQueryTextChange(String newText) {
                            adapter.getFilter().filter(newText);
                            return false;
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.onCreateOptionsMenu(menu);
    }


}