package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class k0 extends Migration {
    static {
        Covode.recordClassIndex(611843);
    }

    public k0() {
        super(27, 28);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：27-28, path=%s,version=%s,", new Object[]{supportSQLiteDatabase.getPath(), Integer.valueOf(supportSQLiteDatabase.getVersion())});
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_result ADD COLUMN create_time INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_result ADD COLUMN current_length REAL NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_result ADD COLUMN total_length REAL NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_result ADD COLUMN chapter_name TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_result ADD COLUMN book_name TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_status ADD COLUMN book_name TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_status ADD COLUMN chapter_name TEXT");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_status ADD COLUMN current_length REAL NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_status ADD COLUMN total_length REAL NOT NULL DEFAULT 0");
    }
}
