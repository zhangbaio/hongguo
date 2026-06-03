package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class f0 extends Migration {
    static {
        Covode.recordClassIndex(611838);
    }

    public f0() {
        super(22, 23);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：22-23", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE t_local_book(`book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL DEFAULT 0, `bookshelf_update_time` INTEGER NOT NULL, `cover_url` TEXT NOT NULL, `file_path` TEXT NOT NULL, `book_name` TEXT NOT NULL, `last_chapter_id` TEXT, `last_chapter_title` TEXT, `last_page_index` INTEGER NOT NULL, `progress_rate` REAL NOT NULL, `progress_update_time` INTEGER NOT NULL, `is_external` INTEGER NOT NULL,`mime_type` TEXT NOT NULL, PRIMARY KEY(`book_id`,`book_type`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_local_book_bookmark (`id` Integer NOT NULL,`mark_type` Integer NOT NULL,`book_id` TEXT NOT NULL,`chapter_id` TEXT NOT NULL,`paragraph_id` Integer NOT NULL,`start_offset_in_para` Integer NOT NULL,`end_offset_in_para` Integer NOT NULL,`chapter_version` TEXT,`content` TEXT,`chapter_title` TEXT,`volume_name` TEXT,PRIMARY KEY(`id`))");
    }
}
