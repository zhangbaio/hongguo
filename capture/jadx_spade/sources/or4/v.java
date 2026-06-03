package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class v extends Migration {
    static {
        Covode.recordClassIndex(611828);
    }

    public v() {
        super(13, 14);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：13-14", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN is_exclusive INTEGER NOT NULL DEFAULT 0");
    }
}
