package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class x1 extends Migration {
    static {
        Covode.recordClassIndex(611882);
    }

    public x1() {
        super(66, 67);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：66-67", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_video_serial_like ( `vid` TEXT NOT NULL DEFAULT '', `cover` TEXT NOT NULL DEFAULT '', `duration` INTEGER NOT NULL DEFAULT 0, `title` TEXT NOT NULL DEFAULT '', `video_desc` TEXT NOT NULL DEFAULT '', `series_id` TEXT NOT NULL DEFAULT '', `digged_count` INTEGER NOT NULL DEFAULT 0, `user_digg` INTEGER NOT NULL DEFAULT 0, `followed` INTEGER NOT NULL DEFAULT 0, `sub_title` TEXT NOT NULL DEFAULT '', `episode_cnt` INTEGER NOT NULL DEFAULT 0, `time` INTEGER NOT NULL DEFAULT 0, `video_width` INTEGER NOT NULL DEFAULT 0, `video_height` INTEGER NOT NULL DEFAULT 0, `user_digg_timestamp_ms` INTEGER NOT NULL DEFAULT 0, `color_dominate` TEXT NOT NULL DEFAULT '', `followed_cnt` INTEGER NOT NULL DEFAULT 0, `episodes_status` INTEGER NOT NULL DEFAULT 0, `series_title` TEXT NOT NULL DEFAULT '', `vid_index` INTEGER NOT NULL DEFAULT -2, `video_platform_type` INTEGER NOT NULL DEFAULT -2, PRIMARY KEY(`vid`))");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_bookshelf ADD COLUMN is_preheat_book_pinned INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_local_book_underline ADD COLUMN line_type INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_underline_local ADD COLUMN line_type INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_underline_remote ADD COLUMN line_type INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN video_content_type INTEGER NOT NULL DEFAULT -2");
    }
}
