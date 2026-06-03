package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611815);
        a = 8;
    }

    public i() {
        super(108, 109);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration108To109", "数据库发生迁移，108-109，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("CREATE TABLE IF NOT EXISTS t_task_comment_publish_record (comment_id TEXT NOT NULL DEFAULT '' PRIMARY KEY, timestamp INTEGER NOT NULL DEFAULT 0, type INTEGER NOT NULL DEFAULT 0, word_count INTEGER NOT NULL DEFAULT 0)");
    }
}
