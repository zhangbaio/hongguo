package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class r1 extends Migration {
    static {
        Covode.recordClassIndex(611876);
    }

    public r1() {
        super(60, 61);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：60-61", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN tone_id INTEGER NOT NULL DEFAULT 0");
    }
}
