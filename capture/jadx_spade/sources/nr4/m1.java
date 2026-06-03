package nr4;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m1 implements k1 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.b0> b;
    private final SharedSQLiteStatement c;

    static {
        Covode.recordClassIndex(611697);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public m1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    class a extends EntityInsertionAdapter<lr4.b0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_forum_session_data` (`book_id`,`session_data`) VALUES (?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.b0 b0Var) {
            String str = b0Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = b0Var.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
        }
    }

    class b extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_forum_session_data WHERE book_id = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
