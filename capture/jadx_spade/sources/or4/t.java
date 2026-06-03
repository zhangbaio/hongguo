package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class t extends Migration {
    static {
        Covode.recordClassIndex(611826);
    }

    public t() {
        super(11, 12);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：11-12", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN genre_type INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN tts_status INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN genre_type INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN tts_status INTEGER NOT NULL DEFAULT 0");
    }
}
