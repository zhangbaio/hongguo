package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611812);
        a = 8;
    }

    public f() {
        super(105, 106);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration105To106", "数据库发生迁移，105-106，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN relate_book_id TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN relate_post_id TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN relate_genre_type TEXT");
    }
}
