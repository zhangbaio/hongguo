package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class o0 extends Migration {
    static {
        Covode.recordClassIndex(611847);
    }

    public o0() {
        super(31, 32);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：31-32", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_video_history_record ( `author_name` TEXT, `author_id` TEXT, `book_name` TEXT, `book_id` TEXT, `series_id` TEXT NOT NULL DEFAULT '0', `series_name` TEXT, `current_episode_id` TEXT, `episodes_list_count_text` TEXT, `current_video_title` TEXT, `cover_url` TEXT, `vid` TEXT NOT NULL, `content_type` INTEGER NOT NULL DEFAULT 0, `total_time` TEXT, `current_play_position` TEXT, `player_accumulate_total_time` TEXT, `current_video_total_time` TEXT, `last_video_vid` TEXT, `record_index` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`series_id`,`vid`))");
    }
}
