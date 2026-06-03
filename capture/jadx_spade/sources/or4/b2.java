package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b2 extends Migration {
    static {
        Covode.recordClassIndex(611886);
    }

    public b2() {
        super(70, 71);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：70-71", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN content_type INTEGER NOT NULL DEFAULT -1");
    }
}
