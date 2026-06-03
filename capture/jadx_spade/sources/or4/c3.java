package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c3 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611913);
        a = 8;
    }

    public c3() {
        super(97, 98);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration97To98", "数据库发生迁移操作：97-98，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN digged_count INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN user_digg INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN pugc_user_name TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN pugc_user_avatar TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN digged_count INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN is_user_digg INTEGER NOT NULL DEFAULT 0");
    }
}
