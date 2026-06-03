package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class j0 extends Migration {
    static {
        Covode.recordClassIndex(611842);
    }

    public j0() {
        super(26, 27);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：26-27, path=%s,version=%s,", new Object[]{supportSQLiteDatabase.getPath(), Integer.valueOf(supportSQLiteDatabase.getVersion())});
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_interactive_record (`book_id` TEXT NOT NULL, `book_name` TEXT, `cover_url` TEXT, `category` TEXT, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `book_status` TEXT, `update_time` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`book_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_dialogue_record (`book_id` TEXT NOT NULL, `book_name` TEXT, `cover_url` TEXT, `category` TEXT, `book_status` TEXT, `update_time` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`book_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_dialogue_progress (`book_id` TEXT NOT NULL, `progress` TEXT, `chapter_name` TEXT, `update_time` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`book_id`))");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN genre TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN length_type TEXT");
    }
}
