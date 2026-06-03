package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class i1 extends Migration {
    static {
        Covode.recordClassIndex(611867);
    }

    public i1() {
        super(51, 52);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：51-52", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_book_content_detail (`book_id` TEXT NOT NULL,`book_content` TEXT,`current_chapter_index` INTEGER NOT NULL DEFAULT -1, `content_type` INTEGER NOT NULL DEFAULT 0,`expect_show_next_chapter` INTEGER NOT NULL DEFAULT 0,PRIMARY KEY(`book_id`))");
    }
}
