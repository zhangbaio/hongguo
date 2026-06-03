package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611821);
        a = 8;
    }

    public o() {
        super(113, 114);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration113To114", "数据库发生迁移操作：113-114，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN related_series_title TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN related_series_title TEXT NOT NULL DEFAULT ''");
    }
}
