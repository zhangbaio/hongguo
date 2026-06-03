package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g1 extends Migration {
    static {
        Covode.recordClassIndex(611865);
    }

    public g1() {
        super(49, 50);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：49-50", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_progress ADD COLUMN start_container_id INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_progress ADD COLUMN start_element_index INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_progress ADD COLUMN start_element_offset INTEGER NOT NULL DEFAULT -1");
    }
}
