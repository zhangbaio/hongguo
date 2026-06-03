package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class q1 extends Migration {
    static {
        Covode.recordClassIndex(611875);
    }

    public q1() {
        super(59, 60);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：59-60", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_search_record_book_comment (`book_id` TEXT NOT NULL, `search_record` TEXT NOT NULL, PRIMARY KEY(`book_id`))");
    }
}
