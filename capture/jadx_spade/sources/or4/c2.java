package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c2 extends Migration {
    static {
        Covode.recordClassIndex(611887);
    }

    public c2() {
        super(71, 72);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：71-72", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN book_short_name TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_history_record ADD COLUMN update_status INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN update_status INTEGER NOT NULL DEFAULT -1");
    }
}
