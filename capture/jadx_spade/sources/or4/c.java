package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611809);
        a = 8;
    }

    public c() {
        super(102, 103);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration102To103", "数据库发生迁移，102-103，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN ai_usage_type INTEGER NOT NULL DEFAULT 0");
    }
}
