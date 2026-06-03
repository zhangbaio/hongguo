package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e1 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611863);
        a = 8;
    }

    public e1() {
        super(47, 48);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作: 47-48, path = " + database.getPath() + ", version = " + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_ugc_book_info ADD COLUMN book_rank INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN start_container_id INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN start_element_index INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN start_element_offset INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN end_container_id INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN end_element_index INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN end_element_offset INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN start_order INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_local ADD COLUMN end_order INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN start_container_id INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN start_element_index INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN start_element_offset INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN end_container_id INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN end_element_index INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN end_element_offset INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN start_order INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_bookmark_remote ADD COLUMN end_order INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN start_container_id INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN start_element_index INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN start_element_offset INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN end_container_id INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN end_element_index INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN end_element_offset INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN start_order INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_local ADD COLUMN end_order INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN start_container_id INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN start_element_index INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN start_element_offset INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN end_container_id INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN end_element_index INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN end_element_offset INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN start_order INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_underline_remote ADD COLUMN end_order INTEGER NOT NULL DEFAULT -1");
        database.execSQL("ALTER TABLE t_book_chapter_progress ADD COLUMN start_container_id INTEGER NOT NULL DEFAULT -1 ");
        database.execSQL("ALTER TABLE t_book_chapter_progress ADD COLUMN start_element_index INTEGER NOT NULL DEFAULT -1 ");
        database.execSQL("ALTER TABLE t_book_chapter_progress ADD COLUMN start_element_offset INTEGER NOT NULL DEFAULT -1 ");
        database.execSQL("CREATE TABLE IF NOT EXISTS t_bookshelf_panel (`book_id` TEXT NOT NULL, `book_type` INTEGER NOT NULL DEFAULT 0, `add_book_time` INTEGER NOT NULL, `listening_and_reading_time` INTEGER NOT NULL, PRIMARY KEY(`book_id`, `book_type`))");
        database.execSQL("CREATE TABLE IF NOT EXISTS `t_audio_bookshelf_guide_info` (`book_id` TEXT NOT NULL,`player_accumulate_total_time` INTEGER NOT NULL,`last_show_time_ms` INTEGER NOT NULL,PRIMARY KEY(`book_id`))");
    }
}
