package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class b1 extends Migration {
    static {
        Covode.recordClassIndex(611860);
    }

    public b1() {
        super(44, 45);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：44-45", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_reading_record ADD COLUMN today_read_time Integer DEFAULT 0 NOT NULL");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_reading_record ADD COLUMN today_time_stamp Integer DEFAULT 0 NOT NULL");
    }
}
