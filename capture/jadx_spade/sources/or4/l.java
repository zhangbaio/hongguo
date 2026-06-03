package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611818);
        a = 8;
    }

    public l() {
        super(110, TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration110To111", "数据库发生迁移操作：110-111，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN video_tag_info TEXT NOT NULL DEFAULT ''");
    }
}
