package cloud.kai.com.kaicloud.com.kaicloud.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;
import java.util.Objects;

import cloud.kai.com.kaicloud.com.kaicloud.utils.L;

/**
 * Created by Administrator on 2015/10/20.
 */
public class  DaoImpl implements Dao {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public DaoImpl(Context context) {
        dbHelper = new DBHelper(context);

    }

    public void close() {
        if(db!=null) {

            db.close();
            L.i("db close success");
        }
        if(dbHelper!=null){
            dbHelper.close();
            L.i("DaoImpl","dbHelper close success");
        }
    }

    public void Transaction(){
        db = dbHelper.getWritableDatabase();
        db.beginTransaction();//事启事务
        try{

            db.setTransactionSuccessful();//设置事务标志为成功，当结束事务时就会提交事务
        }finally{
            db.endTransaction();
        }
    }

    @Override
    public long save(String tableName, ContentValues values) {
        db = dbHelper.getWritableDatabase();
       return db.insert(tableName,null,values);

    }

    @Override
    public Cursor select(String table,String[] columns,String selection,String[] selectionArgs,String groupBy,String having,String orderBy){
        db=dbHelper.getReadableDatabase();
        return db.query(table, columns, selection,
                selectionArgs, groupBy, having,
                orderBy);
    }

    @Override
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs){
         db =dbHelper.getWritableDatabase();
       return  db.update(table,values,whereClause,whereArgs);
    }

    public void delete(Integer id){
        /*SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from person where personid=?", new Object[]{id.toString()});*/
    }

    public Objects find(Integer id){
        //如果只对数据进行读取，建议使用此方法
  /*     db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from person where personid=?", new String[]{id.toString()});//得到游标
        if(cursor.moveToFirst()){
            int personid = cursor.getInt(cursor.getColumnIndex("personid"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int amount = cursor.getInt(cursor.getColumnIndex("amount"));
            T person = new Person(personid, name);
            person.setAmount(amount);
            return person;
        }*/
        return null;
    }

    public List<Objects> getScrollData(Integer offset, Integer maxResult){
       /* List<Person> persons = new ArrayList<Person>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from person limit ?,?",
                new String[]{offset.toString(), maxResult.toString()});
        while(cursor.moveToNext()){
            int personid = cursor.getInt(cursor.getColumnIndex("personid"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int amount = cursor.getInt(cursor.getColumnIndex("amount"));
            Person person = new Person(personid, name);
            person.setAmount(amount);
            persons.add(person);
        }
        cursor.close();
        return persons;*/
        return null;
}

    public Cursor getCursorScrollData(Integer offset, Integer maxResult){
       /* SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("select personid as _id, name, amount from person limit ?,?",
                new String[]{offset.toString(), maxResult.toString()});*/
        return null;
    }

    public long getCount() {
       /* SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(*) from person", null);
        cursor.moveToFirst();
        return cursor.getLong(0);*/
        return 1;
    }
}
