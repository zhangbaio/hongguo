package or4;

import android.util.Log;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class x extends Migration {
    static {
        Covode.recordClassIndex(611830);
    }

    public x() {
        super(15, 16);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：15-16", new Object[0]);
        try {
            supportSQLiteDatabase.execSQL("CREATE TABLE t_backup(`add_type` INTEGER NOT NULL, `book_id` TEXT NOT NULL, `create_time` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `book_type` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`book_id`, `book_type`))");
            supportSQLiteDatabase.execSQL("INSERT INTO t_backup(`add_type`, `book_id`, `create_time`, `update_time`) SELECT `add_type`, `book_id`, `create_time`, `update_time` FROM t_bookshelf");
            supportSQLiteDatabase.execSQL("DROP TABLE t_bookshelf");
            supportSQLiteDatabase.execSQL("ALTER TABLE t_backup RENAME TO t_bookshelf");
            supportSQLiteDatabase.execSQL("CREATE TABLE `t_backup` (`author_name` TEXT, `book_id` TEXT NOT NULL, `book_name` TEXT, `cover_url` TEXT, `genre_type` INTEGER NOT NULL, `tts_status` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `book_type` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`book_id`, `book_type`))");
            supportSQLiteDatabase.execSQL("INSERT INTO t_backup(`author_name`, `book_id`, `book_name`, `cover_url`, `genre_type`, `tts_status`, `update_time`) SELECT `author_name`, `book_id`, `book_name`, `cover_url`, `genre_type`, `tts_status`, `update_time` FROM t_book_record");
            supportSQLiteDatabase.execSQL("DROP TABLE t_book_record");
            supportSQLiteDatabase.execSQL("ALTER TABLE t_backup RENAME TO t_book_record");
            supportSQLiteDatabase.execSQL("CREATE TABLE `t_backup` (`book_id` TEXT NOT NULL, `chapter_id` TEXT, `chapter_index` INTEGER NOT NULL, `chapter_title` TEXT, `page_index` INTEGER NOT NULL, `progress_rate` REAL NOT NULL, `sync` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `book_type` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`book_id`, `book_type`))");
            supportSQLiteDatabase.execSQL("INSERT INTO t_backup(`book_id`, `chapter_id`, `chapter_index`, `chapter_title`, `page_index`, `progress_rate`, `sync`, `update_time`) SELECT `book_id`, `chapter_id`, `chapter_index`, `chapter_title`, `page_index`, `progress_rate`, `sync`, `update_time` FROM t_book_progress");
            supportSQLiteDatabase.execSQL("DROP TABLE t_book_progress");
            supportSQLiteDatabase.execSQL("ALTER TABLE t_backup RENAME TO t_book_progress");
            supportSQLiteDatabase.execSQL("ALTER TABLE `t_book` ADD COLUMN book_status TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE `t_book` ADD COLUMN listen_bookshelf_name TEXT");
            supportSQLiteDatabase.execSQL("CREATE TABLE t_relative_book_id(`id` TEXT NOT NULL, `book_type` INTEGER NOT NULL, `relative_novel_book_id` TEXT, `relative_audio_book_id_set` TEXT, PRIMARY KEY(`id`,`book_type`))");
        } catch (Throwable th) {
            LogWrapper.error("Migration15To16", Log.getStackTraceString(th), new Object[0]);
        }
    }
}
