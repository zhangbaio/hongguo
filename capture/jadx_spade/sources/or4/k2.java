package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611895);
        a = 8;
    }

    public k2() {
        super(79, 80);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：79-80, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_video_history_record ADD COLUMN stayed_video_ids TEXT");
        database.execSQL("ALTER TABLE t_book_progress ADD COLUMN channel_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_book_progress ADD COLUMN cur_channel_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_progress ADD COLUMN channel_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_video_serial_progress ADD COLUMN cur_channel_id INTEGER NOT NULL DEFAULT 0");
        database.execSQL("CREATE TABLE IF NOT EXISTS t_ugc_video_info (`video_list_id` TEXT NOT NULL DEFAULT '',`series_id` TEXT NOT NULL DEFAULT '',`series_cover` TEXT NOT NULL DEFAULT '',`series_title` TEXT NOT NULL DEFAULT '',`v_index` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`video_list_id`,`series_id`))");
        database.execSQL("CREATE TABLE IF NOT EXISTS t_ugc_video_list_info (`video_list_id` TEXT NOT NULL DEFAULT '',`post_title` TEXT NOT NULL DEFAULT '',`subscribe_time` INTEGER NOT NULL DEFAULT 0,`operate_time` INTEGER NOT NULL DEFAULT 0,`delete_time` INTEGER NOT NULL DEFAULT 0,`is_delete` INTEGER NOT NULL DEFAULT 0,`has_sync` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`video_list_id`))");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN is_trailer INTEGER NOT NULL DEFAULT 0");
    }
}
