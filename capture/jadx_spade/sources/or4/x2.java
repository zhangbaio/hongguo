package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611908);
        a = 8;
    }

    public x2() {
        super(92, 93);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration90To91", "数据库发生迁移操作：91 -> 92, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN bottom_bar_type TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN bottom_bar_group_id TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN bottom_bar_text_list TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN bottom_bar_schema TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN bottom_bar_icon_url TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN related_album_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_progress ADD COLUMN book_type INTEGER NOT NULL DEFAULT 2");
        database.execSQL("ALTER TABLE t_video_serial_progress ADD COLUMN content_type INTEGER NOT NULL DEFAULT 1");
    }
}
