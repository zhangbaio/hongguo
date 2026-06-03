package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d0 extends Migration {
    static {
        Covode.recordClassIndex(611836);
    }

    public d0() {
        super(20, 21);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：20-21", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_bookmark_remote (`mark_id` Integer NOT NULL,`mark_type` Integer NOT NULL,`book_id` TEXT NOT NULL,`chapter_id` TEXT NOT NULL,`paragraph_id` Integer NOT NULL,`start_offset_in_para` Integer NOT NULL,`end_offset_in_para` Integer NOT NULL,`chapter_version` TEXT,`content` TEXT,`chapter_title` TEXT,`volume_name` TEXT,`is_deleted` Integer NOT NULL,PRIMARY KEY(`mark_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_bookmark_local (`id` Integer NOT NULL,`mark_type` Integer NOT NULL,`book_id` TEXT NOT NULL,`chapter_id` TEXT NOT NULL,`paragraph_id` Integer NOT NULL,`start_offset_in_para` Integer NOT NULL,`end_offset_in_para` Integer NOT NULL,`chapter_version` TEXT,`content` TEXT,`chapter_title` TEXT,`volume_name` TEXT,PRIMARY KEY(`id`))");
    }
}
