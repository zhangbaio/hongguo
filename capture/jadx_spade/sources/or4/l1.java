package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class l1 extends Migration {
    static {
        Covode.recordClassIndex(611870);
    }

    public l1() {
        super(54, 55);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：54-55", new Object[0]);
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book ADD COLUMN color_dominate TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_book_record ADD COLUMN color_dominate TEXT DEFAULT ''");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS t_font_config (`reader_font_id` INTEGER NOT NULL, `font_title` TEXT, `font_vip_type` INTEGER NOT NULL DEFAULT 0, `file_size` TEXT, `is_new_font` INTEGER NOT NULL DEFAULT 0, `file_url` TEXT, `hidden_inreader` INTEGER NOT NULL DEFAULT 0, `font_pic` TEXT, `order` INTEGER NOT NULL DEFAULT 0, `bold_name` TEXT, `download_onlaunch` INTEGER NOT NULL DEFAULT 0, `regular_name` TEXT, `font_family` TEXT, `regular_file_name` TEXT, PRIMARY KEY(`reader_font_id`))");
    }
}
