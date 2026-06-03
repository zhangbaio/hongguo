package or4;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class v1 extends Migration {
    static {
        Covode.recordClassIndex(611880);
    }

    public v1() {
        super(64, 65);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean z = false;
        LogWrapper.i("数据库发生迁移操作：64-65", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_ugc_book_list ADD COLUMN secondary_info TEXT");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_video_serial_collection ( `series_id` TEXT NOT NULL DEFAULT '', `series_name` TEXT NOT NULL DEFAULT '', `cover_url` TEXT NOT NULL DEFAULT '', `series_color_hex` TEXT NOT NULL DEFAULT '', `last_update_time` INTEGER NOT NULL DEFAULT 0, `is_delete` INTEGER NOT NULL DEFAULT 0, `is_sync` INTEGER NOT NULL DEFAULT 0, `series_status` INTEGER NOT NULL DEFAULT 1, PRIMARY KEY(`series_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_video_serial_progress ( `series_id` TEXT NOT NULL DEFAULT '', `series_name` TEXT NOT NULL DEFAULT '', `series_cnt` INTEGER NOT NULL DEFAULT 0, `current_play_video_index` INTEGER NOT NULL DEFAULT 0, `current_play_video_id` TEXT NOT NULL DEFAULT '', `current_video_title` TEXT NOT NULL DEFAULT '', `total_time` TEXT NOT NULL DEFAULT '', `relative_book_id` TEXT NOT NULL DEFAULT '', `current_play_position` TEXT NOT NULL DEFAULT '0', `current_video_total_time` TEXT NOT NULL DEFAULT '0', `last_video_vid` TEXT NOT NULL DEFAULT '', `update_time` INTEGER NOT NULL DEFAULT 0, `video_width` INTEGER NOT NULL DEFAULT 0, `video_height` INTEGER NOT NULL DEFAULT 0, `is_sync` INTEGER NOT NULL DEFAULT 0, `player_accumulate_total_time` TEXT NOT NULL DEFAULT '0', PRIMARY KEY(`series_id`))");
        Cursor query = supportSQLiteDatabase.query("SELECT * FROM sqlite_master WHERE type='table' AND name='t_video_history_record'");
        if (query != null) {
            if (query.moveToFirst()) {
                z = query.getString(query.getColumnIndex("sql")).contains("episode_cnt");
            }
            query.close();
        }
        if (!z) {
            supportSQLiteDatabase.execSQL("ALTER TABLE t_video_history_record ADD COLUMN episode_cnt INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE t_video_history_record ADD COLUMN video_height INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE t_video_history_record ADD COLUMN video_width INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE t_video_history_record ADD COLUMN current_episode_index INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE t_video_history_record ADD COLUMN series_color_hex TEXT NOT NULL DEFAULT ''");
        }
    }
}
