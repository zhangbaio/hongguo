package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class u1 extends Migration {
    static {
        Covode.recordClassIndex(611879);
    }

    public u1() {
        super(63, 64);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：52-53", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN show_vip_tag INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_local_book_bookmark ADD COLUMN modify_time INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN modify_time INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN modify_time INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_local_book_underline ADD COLUMN modify_time INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_underline_local ADD COLUMN modify_time INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_underline_remote ADD COLUMN modify_time INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_note_book_data ADD COLUMN author TEXT");
    }
}
