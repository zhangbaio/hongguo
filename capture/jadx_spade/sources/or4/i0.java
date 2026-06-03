package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class i0 extends Migration {
    static {
        Covode.recordClassIndex(611841);
    }

    public i0() {
        super(25, 26);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：25-26", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_ugc_book_list (`book_list_id` TEXT NOT NULL, `topic_id` TEXT, `topic_title` TEXT, `topic_status` INTEGER NOT NULL DEFAULT 1, `topic_schemes` TEXT, `book_count` INTEGER NOT NULL DEFAULT 0, `subscribe_time` INTEGER NOT NULL, `click_time` INTEGER NOT NULL, `operate_time` INTEGER NOT NULL, `delete_time` INTEGER NOT NULL, `is_sync` INTEGER NOT NULL DEFAULT 1, `is_delete` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`book_list_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_ugc_book_info (`book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL DEFAULT 0, `book_list_id` TEXT NOT NULL, `recommend_count` TEXT, `read_count` TEXT, PRIMARY KEY(`book_id`, `book_type`, `book_list_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `shelf_control_model` (`bookId` TEXT NOT NULL, `date_time` TEXT NOT NULL, `today_show_count` INTEGER NOT NULL, `last_read_count` INTEGER NOT NULL, `read_count` INTEGER NOT NULL, PRIMARY KEY(`bookId`))");
    }
}
