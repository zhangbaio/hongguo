package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class m1 extends Migration {
    static {
        Covode.recordClassIndex(611871);
    }

    public m1() {
        super(55, 56);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：55-56", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_local_book_underline ADD COLUMN chapter_index INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_local_book_bookmark ADD COLUMN chapter_index INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_underline_local ADD COLUMN chapter_index INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_underline_remote ADD COLUMN chapter_index INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN chapter_index INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN chapter_index INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_note_book_data (`book_id` TEXT NOT NULL,`bookmark_num` INTEGER NOT NULL DEFAULT 0,`underline_num` INTEGER NOT NULL DEFAULT 0, `update_time` INTEGER NOT NULL DEFAULT 0,`book_name` TEXT NOT NULL,`cover_url` TEXT NOT NULL,`status` TEXT,`color` TEXT,`is_local` INTEGER NOT NULL DEFAULT 0,`file_path` TEXT,PRIMARY KEY(`book_id`))");
    }
}
