package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class p0 extends Migration {
    static {
        Covode.recordClassIndex(611848);
    }

    public p0() {
        super(32, 33);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：31-32, path=%s,version=%s,", new Object[]{supportSQLiteDatabase.getPath(), Integer.valueOf(supportSQLiteDatabase.getVersion())});
        supportSQLiteDatabase.execSQL("CREATE TABLE `t_backup` (`author_name` TEXT, `book_id` TEXT NOT NULL, `book_name` TEXT, `cover_url` TEXT, `genre_type` INTEGER NOT NULL, `tts_status` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `last_update_time` INTEGER NOT NULL, `read_time` INTEGER NOT NULL, `book_type` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`book_id`, `book_type`))");
        supportSQLiteDatabase.execSQL("INSERT INTO t_backup(`author_name`, `book_id`, `book_name`, `book_type`, `cover_url`, `genre_type`, `tts_status`, `update_time`, `last_update_time`, `read_time`) SELECT `author_name`, `book_id`, `book_name`, `book_type`, `cover_url`, `genre_type`, `tts_status`, `update_time`, `update_time`, `update_time` FROM t_book_record");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_backup ADD COLUMN has_sync INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_backup ADD COLUMN is_delete INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("DROP TABLE t_book_record");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_backup RENAME TO t_book_record");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_progress ADD COLUMN pager_progress_rate REAL NOT NULL DEFAULT 0");
    }
}
