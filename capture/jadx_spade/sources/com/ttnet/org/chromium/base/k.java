package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class k<E> implements Iterable<E> {
    private int c;
    private int d;
    private boolean e;
    public final List<E> a = new ArrayList();
    private boolean f = true;
    private final ThreadUtils.a b = new ThreadUtils.a();

    public void s() {
        this.f = false;
    }

    private class b implements Iterator {
        private int a;
        private int b;
        private boolean c;

        static {
            Covode.recordClassIndex(654235);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void b() {
            if (!this.c) {
                this.c = true;
                k.this.r();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (k.this.f) {
                k.this.b.a();
            }
            int i = this.b;
            while (i < this.a && k.this.t(i) == null) {
                i++;
            }
            if (i < this.a) {
                return true;
            }
            b();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (k.this.f) {
                k.this.b.a();
            }
            while (true) {
                int i = this.b;
                if (i >= this.a || k.this.t(i) != null) {
                    break;
                }
                this.b++;
            }
            int i2 = this.b;
            if (i2 < this.a) {
                k kVar = k.this;
                this.b = i2 + 1;
                return (E) kVar.t(i2);
            }
            b();
            throw new NoSuchElementException();
        }

        private b() {
            k.this.v();
            this.a = k.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p() {
        return this.a.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.c++;
    }

    static {
        Covode.recordClassIndex(654234);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.f) {
            this.b.a();
        }
        return new b();
    }

    private void q() {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            if (this.a.get(size) == null) {
                this.a.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        int i = this.c - 1;
        this.c = i;
        if (i > 0 || !this.e) {
            return;
        }
        this.e = false;
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E t(int i) {
        return this.a.get(i);
    }

    public boolean o(E e) {
        if (this.f) {
            this.b.a();
        }
        if (e != null && !this.a.contains(e)) {
            this.a.add(e);
            this.d++;
            return true;
        }
        return false;
    }

    public boolean w(E e) {
        int indexOf;
        if (this.f) {
            this.b.a();
        }
        if (e == null || (indexOf = this.a.indexOf(e)) == -1) {
            return false;
        }
        if (this.c == 0) {
            this.a.remove(indexOf);
        } else {
            this.e = true;
            this.a.set(indexOf, null);
        }
        this.d--;
        return true;
    }
}
