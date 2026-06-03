package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class j1 extends Migration {
    static {
        Covode.recordClassIndex(611868);
    }

    public j1() {
        super(52, 53);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：52-53", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN recent_read_count INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN score TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN source TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN page_info TEXT");
    }
}
