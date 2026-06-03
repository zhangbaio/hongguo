package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class s1 extends Migration {
    static {
        Covode.recordClassIndex(611877);
    }

    public s1() {
        super(61, 62);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：61-62", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookshelf ADD COLUMN is_asterisked INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_local_book ADD COLUMN is_asterisked INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_progress ADD COLUMN tone_id INTEGER NOT NULL DEFAULT 0");
    }
}
