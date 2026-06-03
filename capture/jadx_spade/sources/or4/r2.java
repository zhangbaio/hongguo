package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611902);
        a = 8;
    }

    public r2() {
        super(86, 87);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration86To87", "数据库发生迁移操作：86 -> 87, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN is_ugc_video INTEGER NOT NULL DEFAULT 0");
    }
}
