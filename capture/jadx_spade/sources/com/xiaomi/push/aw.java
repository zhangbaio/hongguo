package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.util.LinkedList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class aw {
    private LinkedList<a> a = new LinkedList<>();

    static {
        Covode.recordClassIndex(655363);
    }

    public static class a {
        private static final aw a;

        /* renamed from: a, reason: collision with other field name */
        public int f133a;

        /* renamed from: a, reason: collision with other field name */
        public Object f134a;

        /* renamed from: a, reason: collision with other field name */
        public String f135a;

        static {
            Covode.recordClassIndex(655364);
            a = new aw();
        }

        a(int i, Object obj) {
            this.f133a = i;
            this.f134a = obj;
        }
    }

    public static aw a() {
        return a.a;
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m162a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized int m163a() {
        return this.a.size();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m164a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m162a();
    }
}
