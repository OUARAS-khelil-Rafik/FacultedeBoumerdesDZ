package facultdeboumerdes.umbb.dz;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import android.net.Uri;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ListFacultyActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private DBHandler myDB;
    MyCursorAdapter myCursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_faculty); // Menu Bar
        toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Liste des Facultés"); // Title of Menu Bar
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(android.R.color.white));
        // Add Items of Toogle (Navigation View)
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_list_faculty) {
                    // Handle "Liste des Faculté" menu item click
                    startActivity(new Intent(getApplicationContext(), ListFacultyActivity.class));
                    return true;
                } else if (id == R.id.nav_add_faculty) {
                    // Handle "Ajouter Faculté" menu item click
                    startActivity(new Intent(getApplicationContext(), AddFacultyActivity.class));
                    return true;
                }

                return false;
            }
        });
        myDB = new DBHandler(this); // Ajout de cette ligne pour initialiser myDB
        Cursor r = myDB.readAllData();
        MyCursorAdapter ca = new MyCursorAdapter(this, r);
        ListView list_Faculty = (ListView) findViewById(R.id.list_Faculty);
        list_Faculty.setAdapter(ca);

    }
    public void makeCall(View v){
        Uri uri = Uri.parse("tel: 0662725658");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }
    public void sendSMS(View v){
        Uri uri=Uri.parse("sms: 0662725658");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtra("sms_body", "hjhjkhjkhjkhsk");
        startActivity(intent);
    }
    public void sendEmail(View view){
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        String[] recipients = new String[]{"my@email.com", "",};
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Test");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Message");
        emailIntent.setType("text/plain");
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        finish();
    }
    // Add Action of return in Home (With Botton Icon)
    public void navigateToHome(View view) {
        // Perform navigation to the home (main) screen
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
