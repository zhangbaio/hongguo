package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611910);
        a = 8;
    }

    public z2() {
        super(94, 95);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration94To95", "数据库发生迁移操作：94-> 95, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_local_book ADD COLUMN paragraph_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_local_book ADD COLUMN line_in_paragraph_offset INTEGER NOT NULL DEFAULT 0");
    }
}
