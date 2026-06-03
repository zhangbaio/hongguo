package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class k extends Migration {
    static {
        Covode.recordClassIndex(611817);
    }

    public k() {
        super(10, 11);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：10-11", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_progress ADD COLUMN progress_rate REAL NOT NULL DEFAULT 0");
    }
}
