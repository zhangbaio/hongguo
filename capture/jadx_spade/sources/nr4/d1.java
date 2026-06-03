package nr4;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d1 implements b1 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.x> b;
    private final EntityDeletionOrUpdateAdapter<lr4.x> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611688);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public d1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    class a extends EntityInsertionAdapter<lr4.x> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_dialogue_progress` (`book_id`,`progress`,`chapter_name`,`chapter_index`,`chapter_id`,`update_time`) VALUES (?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.x xVar) {
            String str = xVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = xVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = xVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            if (xVar.d == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindLong(4, r0.intValue());
            }
            String str4 = xVar.e;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str4);
            }
            supportSQLiteStatement.bindLong(6, xVar.f);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.x> {
        public String createQuery() {
            return "DELETE FROM `t_dialogue_progress` WHERE `book_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.x xVar) {
            String str = xVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_dialogue_progress";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
