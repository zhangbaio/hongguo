package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class v0 extends Migration {
    static {
        Covode.recordClassIndex(611854);
    }

    public v0() {
        super(38, 39);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：38-39", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_underline_remote (`mark_id` Integer NOT NULL,`mark_type` Integer NOT NULL,`book_id` TEXT NOT NULL,`chapter_id` TEXT NOT NULL,`start_para_id` Integer NOT NULL,`start_offset_in_para` Integer NOT NULL,`end_para_id` Integer NOT NULL,`end_offset_in_para` Integer NOT NULL,`chapter_version` TEXT NOT NULL,`content` TEXT NOT NULL,`chapter_title` TEXT NOT NULL,`volume_name` TEXT NOT NULL,`is_deleted` Integer NOT NULL,PRIMARY KEY(`mark_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_underline_local (`id` Integer NOT NULL,`mark_type` Integer NOT NULL,`book_id` TEXT NOT NULL,`chapter_id` TEXT NOT NULL,`start_para_id` Integer NOT NULL,`start_offset_in_para` Integer NOT NULL,`end_para_id` Integer NOT NULL,`end_offset_in_para` Integer NOT NULL,`chapter_version` TEXT NOT NULL,`content` TEXT NOT NULL,`chapter_title` TEXT NOT NULL,`volume_name` TEXT NOT NULL,PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_local_book_underline (`id` Integer NOT NULL,`mark_type` Integer NOT NULL,`book_id` TEXT NOT NULL,`chapter_id` TEXT NOT NULL,`start_para_id` Integer NOT NULL,`start_offset_in_para` Integer NOT NULL,`end_para_id` Integer NOT NULL,`end_offset_in_para` Integer NOT NULL,`chapter_version` TEXT NOT NULL,`content` TEXT NOT NULL,`chapter_title` TEXT NOT NULL,`volume_name` TEXT NOT NULL,PRIMARY KEY(`id`))");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN end_paragraph_id INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN end_paragraph_id INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_local_book_bookmark ADD COLUMN end_paragraph_id INTEGER NOT NULL DEFAULT -1");
    }
}
