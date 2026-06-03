package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class f2 extends Migration {
    static {
        Covode.recordClassIndex(611890);
    }

    public f2() {
        super(74, 75);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：74-75", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN series_cover TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN pay_type INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN pay_type INTEGER NOT NULL DEFAULT 0");
    }
}
