package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class x0 extends Migration {
    static {
        Covode.recordClassIndex(611856);
    }

    public x0() {
        super(40, 41);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：40-41, path=%s,version=%s,", new Object[]{supportSQLiteDatabase.getPath(), Integer.valueOf(supportSQLiteDatabase.getVersion())});
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_history_record ADD COLUMN video_platform INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_reading_record ADD COLUMN popup_count_for_chase_comment INTEGER NOT NULL DEFAULT 0");
    }
}
