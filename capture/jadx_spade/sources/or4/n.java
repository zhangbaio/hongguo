package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611820);
        a = 8;
    }

    public n() {
        super(112, 113);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration112To113", "数据库发生迁移操作：112-113，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN season_index INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN video_tag_info TEXT DEFAULT ''");
    }
}
