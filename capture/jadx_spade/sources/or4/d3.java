package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d3 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611914);
        a = 8;
    }

    public d3() {
        super(98, 99);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration98To99", "数据库发生迁移操作：98-99，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_book ADD COLUMN small_cover_url TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN sub_title_list TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN main_creator_users TEXT NOT NULL DEFAULT ''");
    }
}
