package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class t1 extends Migration {
    static {
        Covode.recordClassIndex(611878);
    }

    public t1() {
        super(62, 63);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：62-63", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookshelf ADD COLUMN add_bookshelf_time_sec INTEGER NOT NULL DEFAULT 0");
    }
}
