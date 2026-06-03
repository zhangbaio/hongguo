package nr4;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d2 implements b2 {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<lr4.m0> b;

    static {
        Covode.recordClassIndex(611715);
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    public d2(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
    }

    @Override // nr4.b2
    public Long[] a(lr4.m0... m0VarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.b.insertAndReturnIdsArrayBox(m0VarArr);
            this.a.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.a.endTransaction();
        }
    }

    class a extends EntityInsertionAdapter<lr4.m0> {
        public String createQuery() {
            return "INSERT OR REPLACE INTO `t_read_chapter_progress_upload_record` (`book_id`,`ms_timestamp`) VALUES (?,?)";
        }

        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, lr4.m0 m0Var) {
            String str = m0Var.a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, m0Var.b);
        }
    }
}
