package or4;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends Migration {
    public static final int a;

    static {
        Covode.recordClassIndex(611811);
        a = 8;
    }

    public e() {
        super(104, 105);
    }

    public void migrate(SupportSQLiteDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        LogWrapper.info("Migration104To105", "数据库发生迁移，104-105，path=" + database.getPath() + ", version=" + database.getVersion(), new Object[0]);
        database.execSQL("ALTER TABLE t_font_config ADD COLUMN fanti_font_pic TEXT");
        database.execSQL("ALTER TABLE t_font_config ADD COLUMN ui_key TEXT");
    }
}
