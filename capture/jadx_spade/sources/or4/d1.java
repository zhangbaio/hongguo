package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d1 extends Migration {
    static {
        Covode.recordClassIndex(611862);
    }

    public d1() {
        super(46, 47);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：46-47", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_bookshelf_panel (`book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL DEFAULT 0, `add_book_time` INTEGER NOT NULL, `listening_and_reading_time` INTEGER NOT NULL, PRIMARY KEY(`book_id`, `book_type`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_audio_bookshelf_guide_info` (`book_id` TEXT NOT NULL,`player_accumulate_total_time` INTEGER NOT NULL,`last_show_time_ms` INTEGER NOT NULL,PRIMARY KEY(`book_id`))");
    }
}
