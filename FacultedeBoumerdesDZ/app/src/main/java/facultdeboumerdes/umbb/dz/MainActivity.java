package facultdeboumerdes.umbb.dz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.view.View;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.myToolBar); // Menu Bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculté de Boumerdes"); // Title of Menu Bar
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(android.R.color.white)); // Change color of title of Drawer Arrow Drawable
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

    }

    // Add Action of open Navigation Bar (Drawer Layout)
    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
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
