package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611810);
        a = 8;
    }

    public d() {
        super(103, 104);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration103To104", "数据库发生迁移，103-104，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_book ADD COLUMN valid_in_cn_region INTEGER NOT NULL DEFAULT 0");
    }
}
