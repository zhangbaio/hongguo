package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e0 extends Migration {
    static {
        Covode.recordClassIndex(611837);
    }

    public e0() {
        super(21, 22);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：21-22", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_reading_record ADD COLUMN chapter_count INTEGER NOT NULL DEFAULT 0");
    }
}
