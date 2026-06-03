package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class n1 extends Migration {
    static {
        Covode.recordClassIndex(611872);
    }

    public n1() {
        super(56, 57);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：56-57", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_comic_read_progress_record ADD COLUMN read_progress INTEGER NOT NULL DEFAULT -1");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_comic_read_progress_record ADD COLUMN catalog_order TEXT NOT NULL DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_comic_read_progress_record ADD COLUMN last_update_time TEXT NOT NULL DEFAULT ''");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_comic_detail_info (`book_id` TEXT NOT NULL, `horizontal_cover_url` TEXT ,`book_name` TEXT NOT NULL,`vertical_cover_url` TEXT, `last_update_time` TEXT, `update_status` TEXT, `author` TEXT, `create_time` TEXT, `abstraction` TEXT, `read_count` TEXT, `score` TEXT, `creation_status` TEXT, `authorize_type` TEXT, `first_chapter_id` TEXT , `category_scheme` TEXT , `source` TEXT , `serial_count` TEXT , `last_chapter_id` TEXT , `tags` TEXT , `color_dominate` TEXT, `content_chapter_count` INTEGER NOT NULL DEFAULT 0, `book_content_length` INTEGER NOT NULL DEFAULT 0, `consume_ad` TEXT NOT NULL, `horizontal_cover_path` TEXT NOT NULL, `book_type` TEXT, `vertical_cover_path` TEXT NOT NULL, `directory_sub_info` TEXT NOT NULL, `last_download_success_time` TEXT NOT NULL DEFAULT '0', PRIMARY KEY(`book_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_comic_download_chapter_info (`chapter_id` TEXT NOT NULL, `book_id` TEXT NOT NULL,`book_name` TEXT NOT NULL,`chapter_thumb_url` TEXT NOT NULL,`publish_time` TEXT NOT NULL, `chapter_name` TEXT NOT NULL, `version` TEXT NOT NULL, `content` TEXT NOT NULL, `key_version` INTEGER NOT NULL DEFAULT 0, `content_md5` TEXT NOT NULL, `chapter_order` INTEGER NOT NULL DEFAULT 0, `book_chapter_count` INTEGER NOT NULL DEFAULT 0, `first_pass_time` TEXT NOT NULL, `volume_name` TEXT NOT NULL, `thumb_abs_path` TEXT NOT NULL, `content_key` TEXT NOT NULL, `consume_ad` INTEGER NOT NULL DEFAULT 0, `download_status` INTEGER NOT NULL DEFAULT 0, `content_length` INTEGER NOT NULL DEFAULT 0, `download_task_id` INTEGER NOT NULL DEFAULT 0, `download_chapter_path` TEXT NOT NULL, `download_progress` INTEGER NOT NULL DEFAULT 0, `download_start_time` INTEGER NOT NULL DEFAULT 0, `catalog_abandon` INTEGER NOT NULL DEFAULT 0, `compress_status` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`chapter_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_comic_download_item_info (`chapter_id` TEXT NOT NULL, `book_id` TEXT NOT NULL,`md5` TEXT NOT NULL DEFAULT '', `abs_save_path` TEXT NOT NULL DEFAULT'', `download_create_time` INTEGER NOT NULL DEFAULT -1, `content_order` INTEGER NOT NULL DEFAULT -1, `download_status` INTEGER NOT NULL DEFAULT -1, `content_length` TEXT NOT NULL DEFAULT '-1', `download_sdk_task_id` TEXT NOT NULL DEFAULT '-1', `download_task_id` INTEGER NOT NULL DEFAULT -1, PRIMARY KEY(`book_id`,`chapter_id`,`md5`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_shelf_search_record (`search_record` TEXT NOT NULL, `update_time` INTEGER NOT NULL, PRIMARY KEY(`search_record`))");
    }
}
