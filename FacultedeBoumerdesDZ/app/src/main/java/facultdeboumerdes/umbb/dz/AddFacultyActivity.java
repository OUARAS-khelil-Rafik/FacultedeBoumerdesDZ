package facultdeboumerdes.umbb.dz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.io.InputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;


import android.os.Build;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.EditText;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.graphics.drawable.ColorDrawable;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;

import com.google.android.material.navigation.NavigationView;

public class AddFacultyActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editNameFac, editNameDoyen, editTelFax, editMail, editSiteWeb, editAdresse;
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PERMISSION_REQUEST_CODE = 2;
    private DrawerLayout drawerLayout;
    private ImageView imageView;
    private EditText nameFac, nameDoyen, telFax, mail, siteWeb, adresse;
    private Button buttonAnnl, buttonAdd;
    private AppCompatButton supprimer, edit;
    private DBHandler myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_faculty);
        toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ajouter une Faculté");
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
        // Add Action of select Image Button (select Image in my phone)
        imageView = findViewById(R.id.imageView);

        Button selectImageButton = findViewById(R.id.selectImageButton);
        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    openFilePicker();
                } else {
                    requestPermission();
                }
            }
        });
        buttonAnnl = findViewById(R.id.buttonAnnuler);
        // Add Action in Button "Annuler"
        buttonAnnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all input fields
                nameFac = findViewById(R.id.nameFac);
                nameDoyen = findViewById(R.id.nameDoyen);
                telFax = findViewById(R.id.telFax);
                mail = findViewById(R.id.mail);
                siteWeb = findViewById(R.id.siteWeb);
                adresse = findViewById(R.id.adresse);

                nameFac.setText("");
                nameDoyen.setText("");
                telFax.setText("");
                mail.setText("");
                siteWeb.setText("");
                adresse.setText("");

                // Clear the image if needed
                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageDrawable(null);
            }
        });


        editNameFac=this.findViewById(R.id.nameFac);
        editNameDoyen=this.findViewById(R.id.nameDoyen);
        editTelFax=this.findViewById(R.id.telFax);
        editMail=this.findViewById(R.id.mail);
        editSiteWeb=this.findViewById(R.id.siteWeb);
        editAdresse=this.findViewById(R.id.adresse);
        buttonAdd=this.findViewById(R.id.buttonAjouter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler myDB = new DBHandler(AddFacultyActivity.this);
                String nameFac = editNameFac.getText().toString().trim();
                String nameDoyen = editNameDoyen.getText().toString().trim();
                String telFax = editTelFax.getText().toString().trim();
                String mail = editMail.getText().toString().trim();
                String siteWeb = editSiteWeb.getText().toString().trim();
                String adresse = editAdresse.getText().toString().trim();

                Faculty faculty = new Faculty(nameFac, nameDoyen, telFax, mail, siteWeb, adresse);
                myDB.addFaculty(faculty);
            }
        });
        supprimer=this.findViewById(R.id.supprimer);
        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler myDB = new DBHandler(AddFacultyActivity.this);
                String nameFac = editNameFac.getText().toString().trim();
                String nameDoyen = editNameDoyen.getText().toString().trim();
                String telFax = editTelFax.getText().toString().trim();
                String mail = editMail.getText().toString().trim();
                String siteWeb = editSiteWeb.getText().toString().trim();
                String adresse = editAdresse.getText().toString().trim();

                Faculty faculty = new Faculty(nameFac, nameDoyen, telFax, mail, siteWeb, adresse);
                myDB.deleteFaculty(faculty);
            }
        });
        edit=this.findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler myDB = new DBHandler(AddFacultyActivity.this);
                String nameFac = editNameFac.getText().toString().trim();
                String nameDoyen = editNameDoyen.getText().toString().trim();
                String telFax = editTelFax.getText().toString().trim();
                String mail = editMail.getText().toString().trim();
                String siteWeb = editSiteWeb.getText().toString().trim();
                String adresse = editAdresse.getText().toString().trim();

                Faculty faculty = new Faculty(nameFac, nameDoyen, telFax, mail, siteWeb, adresse);
                myDB.updateFaculty(faculty);
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
    // Add Action of add Image (select Image in my phone)
    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openFilePicker();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            imageView.setImageURI(selectedImageUri);
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
