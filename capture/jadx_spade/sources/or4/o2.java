package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611899);
        a = 8;
    }

    public o2() {
        super(83, 84);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：83-84, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_book ADD COLUMN book_only_tts INTEGER NOT NULL DEFAULT 0");
    }
}
