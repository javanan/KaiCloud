package cloud.kai.com.kaicloud.com.kaicloud.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/10/18.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "kaicloud.db";
    private static final int version = 1;
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
