package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class y extends Migration {
    static {
        Covode.recordClassIndex(611831);
    }

    public y() {
        super(16, 17);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：16-17", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_reading_record (`book_id` TEXT NOT NULL,`read_time` Integer NOT NULL,`last_popup_time` Integer NOT NULL,`last_popup_read_time` Integer NOT NULL,`read_chapter_count` Integer NOT NULL,`popup_count` Integer NOT NULL,PRIMARY KEY(`book_id`))");
    }
}
