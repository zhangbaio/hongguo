package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611819);
        a = 8;
    }

    public m() {
        super(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE, 112);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration111To112", "数据库发生迁移操作：111-112，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN is_interactive_game INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN chapter_index INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN video_category_type TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_collection ADD COLUMN video_category_type TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN video_category_type TEXT NOT NULL DEFAULT ''");
    }
}
