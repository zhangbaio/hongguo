package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c1 extends Migration {
    static {
        Covode.recordClassIndex(611861);
    }

    public c1() {
        super(45, 46);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：45-46", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_book_chapter_progress(`book_id` TEXT NOT NULL DEFAULT '', `chapter_id` TEXT NOT NULL DEFAULT '', `para_id` INTEGER NOT NULL DEFAULT 0, `para_offset` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`chapter_id`))");
    }
}
