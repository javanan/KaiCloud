package cloud.kai.com.kaicloud.com.kaicloud.db.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import cloud.kai.com.kaicloud.com.kaicloud.db.Dao;
import cloud.kai.com.kaicloud.com.kaicloud.db.DaoImpl;

/**
 * Created by Administrator on 2015/10/21.
 */
public class BaseService<T> {
    private Dao dao;

    public BaseService(Context context) {
        dao = new DaoImpl(context);
    }

    public void close() {
        dao.close();
    }

    /**
     * 保存数据
     *
     * @param tableName
     * @param values
     */
    public long save(String tableName, ContentValues values) {

        return dao.save(tableName, values);
    }

    /**
     * 查询操作
     * @param table
     * @param columns
     * @param selection
     * @param selectionArgs
     * @param groupBy
     * @param having
     * @param orderBy
     * @return
     */
    public Cursor select(String table,String[] columns,String selection,String[] selectionArgs,String groupBy,String having,String orderBy){

        return dao.select(table, columns, selection,
                selectionArgs, groupBy, having,
                orderBy);
    }

    /**
     * 更新
     * @param table
     * @param values
     * @param whereClause
     * @param whereArgs
     * @return
     */
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs){
        return dao.update( table,  values,  whereClause,  whereArgs);
    }
}
