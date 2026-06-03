package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d2 extends Migration {
    static {
        Covode.recordClassIndex(611888);
    }

    public d2() {
        super(72, 73);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：72-73", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN poster_id TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_ugc_book_info ADD COLUMN color_dominate TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN show_update_notify INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN is_vertical INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN platform_book_id TEXT");
    }
}
