package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611807);
        a = 8;
    }

    public a() {
        super(100, 101);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration100To101", "数据库发生迁移，100-101，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN video_tag_info TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN secondary_info TEXT NOT NULL DEFAULT ''");
    }
}
