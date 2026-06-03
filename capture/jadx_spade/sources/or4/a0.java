package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a0 extends Migration {
    static {
        Covode.recordClassIndex(611833);
    }

    public a0() {
        super(18, 19);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：18-19", new Object[0]);
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_audio_download_status` (`book_id` TEXT, `chapter_id` TEXT NOT NULL, `tone_id` INTEGER NOT NULL, `status` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `create_time` INTEGER NOT NULL, `download_id` INTEGER NOT NULL, `download_url` TEXT, `is_encrypt` INTEGER NOT NULL, `encrypt_key` TEXT, `abs_save_path` TEXT, PRIMARY KEY(`chapter_id`, `tone_id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `t_audio_download_result` (`book_id` TEXT, `chapter_id` TEXT NOT NULL, `tone_id` INTEGER NOT NULL, `download_id` INTEGER NOT NULL, `is_encrypt` INTEGER NOT NULL, `encrypt_key` TEXT, `abs_save_path` TEXT, PRIMARY KEY(`chapter_id`, `tone_id`))");
    }
}
