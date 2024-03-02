package facultdeboumerdes.umbb.dz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1; // Database Version
    private static final String DATABASE_NAME = "dbfaculty.db"; // Database Name
    private Context context;
    private EditText nameFac, nameDoyen, telFax, mail, siteWeb, adresse;
    DBHandler myDB;

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE faculty (_id INTEGER PRIMARY KEY, nameFac TEXT, nameDoyen TEXT, telFax INTEGER, mail TEXT, siteWeb TEXT, adresse TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS faculty");
        onCreate(db);
    }


    public void addFaculty(Faculty faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nameFac", faculty.getNameFac());
        values.put("nameDoyen", faculty.getNameDoyen());
        values.put("telFax", faculty.getTelFax());
        values.put("mail", faculty.getMail());
        values.put("siteWeb", faculty.getSiteWeb());
        values.put("adresse", faculty.getAdresse());

        long result = db.insert("faculty", null, values);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Faculty Successful", Toast.LENGTH_SHORT).show();
        }
    }
    public int updateFaculty(Faculty faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nameFac", faculty.getNameFac());
        values.put("nameDoyen", faculty.getNameDoyen());
        values.put("telFax", faculty.getTelFax());
        values.put("mail", faculty.getMail());
        values.put("siteWeb", faculty.getSiteWeb());
        values.put("adresse", faculty.getAdresse());
        return db.update("faculty", values, "nameFac = ?", new String[]{faculty.getNameFac()});
    }
    public void deleteFaculty(Faculty faculty) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("faculty", "nameFac = ?", new String[] { faculty.getNameFac()});
        db.close();
    }
    Cursor readAllData(){
        String SELECT_TABLE = "SELECT * FROM faculty";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(SELECT_TABLE, null);
        }
        return cursor;
    }
}
