package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611898);
        a = 8;
    }

    public n2() {
        super(82, 83);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：82 -> 83, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_book_record ADD COLUMN total_read_time INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_book_record ADD COLUMN exact_read_time INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_book_record ADD COLUMN exact_read_word_num INTEGER NOT NULL DEFAULT 0");
    }
}
