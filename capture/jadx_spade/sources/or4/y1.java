package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class y1 extends Migration {
    static {
        Covode.recordClassIndex(611883);
    }

    public y1() {
        super(67, 68);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：67-68", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_history_record ADD COLUMN update_tag TEXT NOT NULL DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN update_tag TEXT NOT NULL DEFAULT ''");
    }
}
