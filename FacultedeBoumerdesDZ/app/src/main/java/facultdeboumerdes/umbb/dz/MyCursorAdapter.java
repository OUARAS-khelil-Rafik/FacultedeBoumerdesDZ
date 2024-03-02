package facultdeboumerdes.umbb.dz;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {
    public MyCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.my_row, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView faculty_name = (TextView) view.findViewById(R.id.faculty_name);
        TextView faculty_nameDoyen = (TextView) view.findViewById(R.id.faculty_nameDoyen);
        TextView faculty_telFax = (TextView) view.findViewById(R.id.faculty_telFax);
        TextView faculty_mail = (TextView) view.findViewById(R.id.faculty_mail);
        TextView faculty_siteWeb = (TextView) view.findViewById(R.id.faculty_siteWeb);
        TextView faculty_adresse = (TextView) view.findViewById(R.id.faculty_adresse);
        // Extract properties from cursor
        String facultyname = cursor.getString(1);
        String facultynameDoyen = cursor.getString(2);
        String facultytelFax = cursor.getString(3);
        String facultymail = cursor.getString(4);
        String facultysiteWeb = cursor.getString(5);
        String facultyadresse = cursor.getString(6);
        // Populate fields with extracted properties
        faculty_name.setText(facultyname);
        faculty_nameDoyen.setText(facultynameDoyen);
        faculty_telFax.setText(facultytelFax);
        faculty_mail.setText(facultymail);
        faculty_siteWeb.setText(facultysiteWeb);
        faculty_adresse.setText(facultyadresse);
    }
}
