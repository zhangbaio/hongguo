package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class n0 extends Migration {
    static {
        Covode.recordClassIndex(611846);
    }

    public n0() {
        super(30, 31);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        LogWrapper.i("数据库发生迁移操作：30-31, path=%s,version=%s,", new Object[]{supportSQLiteDatabase.getPath(), Integer.valueOf(supportSQLiteDatabase.getVersion())});
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_result ADD COLUMN duration INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE t_audio_download_status ADD COLUMN duration INTEGER NOT NULL DEFAULT 0");
    }
}
