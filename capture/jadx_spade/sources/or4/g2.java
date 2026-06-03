package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611891);
        a = 8;
    }

    public g2() {
        super(75, 76);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：75-76, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("CREATE TABLE IF NOT EXISTS t_download_book ( `book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL DEFAULT 0,  `book_name` TEXT NOT NULL, `cover_url` TEXT NOT NULL, `status` INTEGER NOT NULL, `genre_type` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `update_time` INTEGER NOT NULL, `percent` REAL NOT NULL, `download_size` INTEGER NOT NULL, `unlock_downloaded_size` INTEGER NOT NULL, `total_file_length` INTEGER NOT NULL,  PRIMARY KEY(`book_id`,`book_type`))");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN is_public INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN hot_line_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN is_public INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN hot_line_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN played_video_ids TEXT");
    }
}
