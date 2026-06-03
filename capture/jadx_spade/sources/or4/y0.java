package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class y0 extends Migration {
    static {
        Covode.recordClassIndex(611857);
    }

    public y0() {
        super(41, 42);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：40-41", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN start_media_index INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN end_media_index INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN start_media_index INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN end_media_index INTEGER NOT NULL DEFAULT 0");
    }
}
