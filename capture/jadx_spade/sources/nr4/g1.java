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
public final class g1 implements e1 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.y> b;
    private final EntityDeletionOrUpdateAdapter<lr4.y> c;
    private final SharedSQLiteStatement d;

    static {
        Covode.recordClassIndex(611691);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public g1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    class a extends EntityInsertionAdapter<lr4.y> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_dialogue_record` (`book_id`,`book_name`,`cover_url`,`category`,`book_status`,`update_time`) VALUES (?,?,?,?,?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.y yVar) {
            String str = yVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            String str2 = yVar.b;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str2);
            }
            String str3 = yVar.c;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str3);
            }
            String str4 = yVar.d;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str4);
            }
            String str5 = yVar.e;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str5);
            }
            supportSQLiteStatement.bindLong(6, yVar.f);
        }
    }

    class b extends EntityDeletionOrUpdateAdapter<lr4.y> {
        public String createQuery() {
            return "DELETE FROM `t_dialogue_record` WHERE `book_id` = ?";
        }

        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.y yVar) {
            String str = yVar.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
        }
    }

    class c extends SharedSQLiteStatement {
        public String createQuery() {
            return "DELETE FROM t_dialogue_record";
        }

        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }
    }
}
