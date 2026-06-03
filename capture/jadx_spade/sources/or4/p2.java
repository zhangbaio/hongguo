package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611900);
        a = 8;
    }

    public p2() {
        super(84, 85);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：84 -> 85, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN video_series_id_type INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN user_avatar TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN user_name TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN user_id TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN post_title TEXT NOT NULL DEFAULT ''");
    }
}
