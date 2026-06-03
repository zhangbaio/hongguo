package bm6;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.zhihu.matisse.internal.entity.IncapableCause;
import com.zhihu.matisse.internal.entity.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    private final Context a;
    private Set<Item> b;
    public int c = 0;

    static {
        Covode.recordClassIndex(656130);
    }

    public List<Item> b() {
        return new ArrayList(this.b);
    }

    public int e() {
        return this.b.size();
    }

    public boolean j() {
        if (this.b.size() == f()) {
            return true;
        }
        return false;
    }

    private int f() {
        com.zhihu.matisse.internal.entity.a b = com.zhihu.matisse.internal.entity.a.b();
        int i = b.g;
        if (i > 0) {
            return i;
        }
        int i2 = this.c;
        if (i2 == 1) {
            return b.h;
        }
        if (i2 == 2) {
            return b.i;
        }
        return i;
    }

    public List<Uri> c() {
        ArrayList arrayList = new ArrayList();
        Iterator<Item> it2 = this.b.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getContentUri());
        }
        return arrayList;
    }

    public Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("state_selection", new ArrayList<>(this.b));
        bundle.putInt("state_collection_type", this.c);
        return bundle;
    }

    private void n() {
        boolean z = false;
        boolean z2 = false;
        for (Item item : this.b) {
            if (item.isImage() && !z) {
                z = true;
            }
            if (item.isVideo() && !z2) {
                z2 = true;
            }
        }
        if (z && z2) {
            this.c = 3;
        } else if (z) {
            this.c = 1;
        } else if (z2) {
            this.c = 2;
        }
    }

    public boolean i(Item item) {
        return this.b.contains(item);
    }

    public c(Context context) {
        this.a = context;
    }

    public int d(Item item) {
        int indexOf = new ArrayList(this.b).indexOf(item);
        if (indexOf == -1) {
            return Integer.MIN_VALUE;
        }
        return indexOf + 1;
    }

    public void l(Bundle bundle) {
        bundle.putParcelableArrayList("state_selection", new ArrayList<>(this.b));
        bundle.putInt("state_collection_type", this.c);
    }

    public boolean o(Item item) {
        boolean remove = this.b.remove(item);
        if (remove) {
            if (this.b.size() == 0) {
                this.c = 0;
            } else if (this.c == 3) {
                n();
            }
        }
        return remove;
    }

    public IncapableCause h(Item item) {
        if (j()) {
            f();
            return new IncapableCause("图片或视频超过最大选择数量");
        }
        if (p(item)) {
            return new IncapableCause(this.a.getString(2131104511));
        }
        return em6.c.e(this.a, item);
    }

    public void k(Bundle bundle) {
        if (bundle == null) {
            this.b = new LinkedHashSet();
        } else {
            this.b = new LinkedHashSet(bundle.getParcelableArrayList("state_selection"));
            this.c = bundle.getInt("state_collection_type", 0);
        }
    }

    public boolean p(Item item) {
        int i;
        int i2;
        if (com.zhihu.matisse.internal.entity.a.b().b) {
            if (item.isImage() && ((i2 = this.c) == 2 || i2 == 3)) {
                return true;
            }
            if (item.isVideo() && ((i = this.c) == 1 || i == 3)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Item item) {
        if (!p(item)) {
            boolean add = this.b.add(item);
            if (add) {
                int i = this.c;
                if (i == 0) {
                    if (item.isImage()) {
                        this.c = 1;
                    } else if (item.isVideo()) {
                        this.c = 2;
                    }
                } else if (i == 1) {
                    if (item.isVideo()) {
                        this.c = 3;
                    }
                } else if (i == 2 && item.isImage()) {
                    this.c = 3;
                }
            }
            return add;
        }
        throw new IllegalArgumentException("Can't select images and videos at the same time.");
    }

    public void m(ArrayList<Item> arrayList, int i) {
        if (arrayList.size() == 0) {
            this.c = 0;
        } else {
            this.c = i;
        }
        this.b.clear();
        this.b.addAll(arrayList);
    }
}
