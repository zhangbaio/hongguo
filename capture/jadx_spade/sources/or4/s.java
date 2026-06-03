package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611825);
        a = 8;
    }

    public s() {
        super(117, 118);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration117To118", "数据库发生迁移操作：117-118，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_audio_download_status ADD COLUMN pause_reason INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_download_book ADD COLUMN pause_reason INTEGER NOT NULL DEFAULT -1");
    }
}
