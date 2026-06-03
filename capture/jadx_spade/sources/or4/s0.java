package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s0 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611851);
        a = 8;
    }

    public s0() {
        super(35, 36);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：35-36, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_book_progress ADD COLUMN paragraph_id INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_book_progress ADD COLUMN line_in_paragraph_offset INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN recommend_text TEXT");
    }
}
