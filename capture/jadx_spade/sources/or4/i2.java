package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611893);
        a = 8;
    }

    public i2() {
        super(77, 78);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：77-78, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_book ADD COLUMN relative_post_schema TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN show_record_info INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN record_number TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN secondary_infos TEXT");
    }
}
