package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611896);
        a = 8;
    }

    public l2() {
        super(80, 81);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：80-81, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_local_book_underline ADD COLUMN underline_type INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN underline_type INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN underline_type INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_local_book_underline ADD COLUMN notes TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN notes  TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN notes  TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_note_book_data ADD COLUMN note_num INTEGER NOT NULL DEFAULT 0");
    }
}
