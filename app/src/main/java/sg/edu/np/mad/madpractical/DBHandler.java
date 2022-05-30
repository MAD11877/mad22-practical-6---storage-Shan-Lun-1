package sg.edu.np.mad.madpractical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telecom.ConnectionService;
import android.util.Log;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(Context context){
        super(context, "Practical.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE = "CREATE TABLE USER" +
                "(ID            INTEGER     PRIMARY KEY     AUTOINCREMENT," +
                " NAME          TEXT," +
                " DESCRIPTION   TEXT," +
                " FOLLOWED      INTEGER)";
        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertUser(User u){
        int followed = u.followed ? 1:0;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVal = new ContentValues();
        cVal.put("NAME", u.name);
        cVal.put("DESCRIPTION", u.description);
        cVal.put("FOLLOWED", followed);

        db.insert("USER", null, cVal);
    }

    public ArrayList<User> getUsers(){
        SQLiteDatabase db = getWritableDatabase();

        ArrayList<User> userList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM USER", null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            Integer id = cursor.getInt(0);
            String name = cursor.getString(1);
            String desc = cursor.getString(2);
            Boolean followed = cursor.getInt(3) == 1;
            User u = new User(name, desc, id, followed);
            userList.add(u);
        }
        return userList;
    }

    public void updateUser(User u){
        SQLiteDatabase db = getWritableDatabase();

        Integer followed = u.followed ? 1:0;

        ContentValues cVal = new ContentValues();
        cVal.put("NAME", u.name);
        cVal.put("DESCRIPTION", u.description);
        cVal.put("FOLLOWED", followed);

        Integer id = u.id;
        db.update("USER", cVal, "ID=?",new String[]{new Integer(id).toString()});
    }
}
