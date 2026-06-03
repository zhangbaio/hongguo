package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.TraitObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TraitObjectManager {
    private Map<Integer, TraitObject> mTraitObjects = new HashMap();

    static {
        Covode.recordClassIndex(652373);
    }

    public Map<Integer, TraitObject> getAll() {
        return new HashMap(this.mTraitObjects);
    }

    public void removeAll() {
        if (this.mTraitObjects.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        synchronized (this) {
            hashMap.putAll(this.mTraitObjects);
            this.mTraitObjects.clear();
        }
        Iterator it2 = hashMap.entrySet().iterator();
        while (it2.hasNext()) {
            ((TraitObject) ((Map.Entry) it2.next()).getValue()).release();
        }
    }

    public TraitObject get(int i) {
        return this.mTraitObjects.get(Integer.valueOf(i));
    }

    public int remove(int i) {
        synchronized (this) {
            TraitObject traitObject = this.mTraitObjects.get(Integer.valueOf(i));
            if (traitObject == null) {
                return -1;
            }
            this.mTraitObjects.remove(Integer.valueOf(i));
            traitObject.release();
            return 0;
        }
    }

    public void put(int i, TraitObject traitObject) {
        synchronized (this) {
            TraitObject traitObject2 = this.mTraitObjects.get(Integer.valueOf(i));
            if (traitObject2 == null && traitObject == null) {
                return;
            }
            if (traitObject2 != traitObject && (traitObject2 == null || !traitObject2.sameAs(traitObject))) {
                this.mTraitObjects.put(Integer.valueOf(i), traitObject);
                if (traitObject2 != null) {
                    traitObject2.release();
                }
            }
        }
    }
}
