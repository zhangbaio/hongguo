package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611903);
        a = 8;
    }

    public s2() {
        super(87, 88);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration87To88", "数据库发生迁移操作：87 -> 88, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN update_tag_text TEXT");
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN update_tag_text TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN is_private INTEGER NOT NULL DEFAULT 0");
    }
}
