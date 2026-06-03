package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b3 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611912);
        a = 8;
    }

    public b3() {
        super(96, 97);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration96To97", "数据库发生迁移操作：96 -> 97, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_progress ADD COLUMN video_scene INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN video_scene INTEGER NOT NULL DEFAULT 0");
    }
}
