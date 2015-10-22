package cloud.kai.com.kaicloud.com.kaicloud.db;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by Administrator on 2015/10/20.
 */
public interface Dao {
    /**
     * 关闭数据库 联接资源
     */
    public void close();
    /**
     * 处理事务
     */
    public void Transaction();

    /**
     * 保存数据
     * @param tableName
     * @param values
     * @return  the row ID of the newly inserted row, or -1 if an error occurred
     */
    public long save(String tableName,ContentValues values);

    /**
     *查询操作
     * @param table
     * @param columns
     * @param selection
     * @param selectionArgs
     * @param groupBy
     * @param having
     * @param orderBy
     * @return
     */
    public Cursor select(String table,String[] columns,String selection,String[] selectionArgs,String groupBy,String having,String orderBy);

    /**
     * 更新
     * @param table
     * @param values
     * @param whereClause
     * @param whereArgs
     * @return
     */
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs);
}
