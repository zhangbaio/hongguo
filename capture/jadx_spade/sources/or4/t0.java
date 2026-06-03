package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t0 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611852);
        a = 8;
    }

    public t0() {
        super(36, 37);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：36-37, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_bookshelf ADD COLUMN pinned_time INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_bookshelf ADD COLUMN is_pinned INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_bookshelf ADD COLUMN booklist_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_booklist ADD COLUMN pinned_time INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_booklist ADD COLUMN is_pinned INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_booklist ADD COLUMN real_booklist_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN pinned_time INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN is_pinned INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_dialogue_progress ADD COLUMN chapter_index INTEGER");
        database.execSQL("ALTER TABLE t_dialogue_progress ADD COLUMN chapter_id TEXT");
    }
}
