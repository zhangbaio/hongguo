package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g0 extends Migration {
    static {
        Covode.recordClassIndex(611839);
    }

    public g0() {
        super(23, 24);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：23-24", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN icon_tag TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_local_book ADD COLUMN booklist_name TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookshelf ADD COLUMN booklist_name TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookshelf ADD COLUMN booklist_operate_time INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookshelf ADD COLUMN is_sync INTEGER NOT NULL DEFAULT 1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookshelf ADD COLUMN is_delete INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_booklist (`booklist_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `booklist_name` TEXT, `update_time` INTEGER NOT NULL)");
    }
}
