package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611814);
        a = 8;
    }

    public h() {
        super(107, 108);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration107To108", "数据库发生迁移，107-108，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN create_time INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN user_creator_type INTEGER");
    }
}
