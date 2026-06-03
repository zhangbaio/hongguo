package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class z0 extends Migration {
    static {
        Covode.recordClassIndex(611858);
    }

    public z0() {
        super(42, 43);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：42-43", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN wordNumber INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN gender TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN is_in_bookshelf INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN category TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN authorId TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN abstraction TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN readCount TEXT DEFAULT '0'");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN score TEXT DEFAULT '0'");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN creationStatus INTEGER DEFAULT -1 NOT NULL");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN authorizeType TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN firstChapterId TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN bookRankInfoList TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN categorySchema TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN titlePageTags TEXT DEFAULT ''");
    }
}
