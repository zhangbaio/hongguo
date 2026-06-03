package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611816);
        a = 8;
    }

    public j() {
        super(109, 110);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration109To110", "数据库发生迁移，109-110，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN user_avatar_decoration_url TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN user_avatar_decoration_id TEXT");
    }
}
