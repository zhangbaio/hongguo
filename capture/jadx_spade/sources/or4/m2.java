package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m2 extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611897);
        a = 8;
    }

    public m2() {
        super(81, 82);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.i("数据库发生迁移操作：81-82, path=" + database.getPath() + ",version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_font_config ADD COLUMN is_variable_font INTEGER NOT NULL DEFAULT 0");
        database.execSQL("ALTER TABLE t_font_config ADD COLUMN medium_file_name TEXT");
        database.execSQL("ALTER TABLE t_font_config ADD COLUMN bold_file_name TEXT");
        database.execSQL("ALTER TABLE t_font_config ADD COLUMN medium_name TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN celebrities TEXT");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN category_schema TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN series_intro TEXT NOT NULL DEFAULT ''");
        database.execSQL("ALTER TABLE t_video_serial_like ADD COLUMN series_play_cnt INTEGER NOT NULL DEFAULT 0");
    }
}
