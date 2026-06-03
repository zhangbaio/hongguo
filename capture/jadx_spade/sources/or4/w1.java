package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class w1 extends Migration {
    static {
        Covode.recordClassIndex(611881);
    }

    public w1() {
        super(65, 66);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：65-66", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_progress ADD COLUMN tone_id_after_v579 INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_forum_session_data ( `book_id` TEXT NOT NULL DEFAULT '', `session_data` TEXT NOT NULL DEFAULT '', PRIMARY KEY(`book_id`))");
    }
}
