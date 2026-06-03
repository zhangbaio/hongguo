package jr4;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import com.bytedance.covode.number.Covode;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements a {
    private final RoomDatabase a;
    private final EntityDeletionOrUpdateAdapter<c> b;

    static {
        Covode.recordClassIndex(611510);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    @Override // jr4.a
    public void delete(List<c> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // jr4.a
    public void delete(c cVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.handle(cVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }
}
