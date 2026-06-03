package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611894);
        a = 8;
    }

    public j2() {
        super(78, 79);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：78-79, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN group_name TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN booklist_operate_time INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN collect_time INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN has_sync INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN is_delete INTEGER NOT NULL DEFAULT 0");
    }
}
