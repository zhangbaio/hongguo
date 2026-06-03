package com.xs.fm.player.sdk.play.player.video;

import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class XiguaVideoCover$supportEvents$1 extends ArrayList<Integer> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    XiguaVideoCover$supportEvents$1() {
        add(115);
        add(100);
        add(112);
        add(105);
        add(104);
    }

    public /* bridge */ boolean contains(Integer num) {
        return super.contains((Object) num);
    }

    public /* bridge */ int indexOf(Integer num) {
        return super.indexOf((Object) num);
    }

    public /* bridge */ int lastIndexOf(Integer num) {
        return super.lastIndexOf((Object) num);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ Integer remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ Integer removeAt(int i) {
        return (Integer) super.remove(i);
    }

    public /* bridge */ boolean remove(Integer num) {
        return super.remove((Object) num);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        boolean z;
        if (obj != null) {
            z = obj instanceof Integer;
        } else {
            z = true;
        }
        if (z) {
            return contains((Integer) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        boolean z;
        if (obj != null) {
            z = obj instanceof Integer;
        } else {
            z = true;
        }
        if (z) {
            return indexOf((Integer) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        boolean z;
        if (obj != null) {
            z = obj instanceof Integer;
        } else {
            z = true;
        }
        if (z) {
            return lastIndexOf((Integer) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        boolean z;
        if (obj != null) {
            z = obj instanceof Integer;
        } else {
            z = true;
        }
        if (z) {
            return remove((Integer) obj);
        }
        return false;
    }
}
