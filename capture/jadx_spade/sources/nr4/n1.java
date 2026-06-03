package nr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.IMParticipant;
import com.dragon.read.local.db.interfaces.IIMParticipantDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n1 implements IIMParticipantDao {
    public static final int b;
    private final IIMParticipantDao a;

    static {
        Covode.recordClassIndex(611699);
        b = 8;
    }

    public n1(IIMParticipantDao iIMParticipantDao) {
        Intrinsics.checkNotNullParameter(iIMParticipantDao, "iIMParticipantDao");
        this.a = iIMParticipantDao;
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void insertOrReplaceParticipant(IMParticipant iMParticipant) {
        if (iMParticipant == null) {
            return;
        }
        this.a.insertOrReplaceParticipant(iMParticipant);
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void deleteAllParticipant(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        this.a.deleteAllParticipant(str);
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public List<IMParticipant> queryAllParticipant(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        return this.a.queryAllParticipant(str);
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void insertOrReplaceParticipant(List<IMParticipant> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
        while (it2.hasNext()) {
            this.a.insertOrReplaceParticipant((List<IMParticipant>) it2.next());
        }
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void deleteParticipant(String str, String str2) {
        boolean z;
        boolean z2 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (str2 == null || str2.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                this.a.deleteParticipant(str, str2);
            }
        }
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public IMParticipant queryParticipant(String str, String str2) {
        boolean z;
        boolean z2 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (str2 == null || str2.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                return this.a.queryParticipant(str, str2);
            }
            return null;
        }
        return null;
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public void deleteParticipant(String str, List<String> list) {
        boolean z;
        boolean z2 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (list == null || list.isEmpty()) {
                z2 = true;
            }
            if (!z2) {
                Iterator it2 = com.dragon.read.local.db.e.a(list).iterator();
                while (it2.hasNext()) {
                    this.a.deleteParticipant(str, (List<String>) it2.next());
                }
            }
        }
    }

    @Override // com.dragon.read.local.db.interfaces.IIMParticipantDao
    public List<IMParticipant> queryParticipant(String str, List<String> list) {
        boolean z;
        boolean z2 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (list == null || list.isEmpty()) {
                z2 = true;
            }
            if (!z2) {
                List a = com.dragon.read.local.db.e.a(list);
                ArrayList arrayList = new ArrayList();
                Iterator it2 = a.iterator();
                while (it2.hasNext()) {
                    List<IMParticipant> queryParticipant = this.a.queryParticipant(str, (List<String>) it2.next());
                    if (queryParticipant != null) {
                        arrayList.addAll(queryParticipant);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }
}
