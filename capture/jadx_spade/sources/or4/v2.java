package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611906);
        a = 8;
    }

    public v2() {
        super(90, 91);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration90To91", "数据库发生迁移操作：90 -> 91, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_bookshelf ADD COLUMN is_chased_updates INTEGER NOT NULL DEFAULT 0");
    }
}
