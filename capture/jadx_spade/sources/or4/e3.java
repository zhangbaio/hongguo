package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e3 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611915);
        a = 8;
    }

    public e3() {
        super(99, 100);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration99To100", "数据库发生迁移，99-100，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN is_multi_season INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN season_index INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN is_multi_season INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN season_index INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN relate_video_content_type INTEGER NOT NULL DEFAULT -2");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN recommend_info TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN recommend_group_id TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN support_listen INTEGER NOT NULL DEFAULT 0");
    }
}
