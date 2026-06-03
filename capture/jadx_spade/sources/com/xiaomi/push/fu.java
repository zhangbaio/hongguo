package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fu {
    private static fu a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, Object> f472a = new ConcurrentHashMap();
    private Map<String, Object> b = new ConcurrentHashMap();

    static {
        Covode.recordClassIndex(655539);
    }

    private fu() {
        m443a();
    }

    public static synchronized fu a() {
        fu fuVar;
        synchronized (fu.class) {
            if (a == null) {
                a = new fu();
            }
            fuVar = a;
        }
        return fuVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    private ClassLoader[] m441a() {
        ClassLoader[] classLoaderArr = {fu.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    /* renamed from: a, reason: collision with other method in class */
    protected void m443a() {
        InputStream inputStream;
        XmlPullParser newPullParser;
        int eventType;
        try {
            for (ClassLoader classLoader : m441a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    try {
                        inputStream = resources.nextElement().openStream();
                        try {
                            newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, "UTF-8");
                            eventType = newPullParser.getEventType();
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                    do {
                        if (eventType == 2) {
                            if (newPullParser.getName().equals("iqProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText2 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText3 = newPullParser.nextText();
                                String a2 = a(nextText, nextText2);
                                if (!this.b.containsKey(a2)) {
                                    try {
                                        Class q = l3.a.q(nextText3);
                                        if (fs.class.isAssignableFrom(q)) {
                                            this.b.put(a2, q.newInstance());
                                        } else if (fl.class.isAssignableFrom(q)) {
                                            this.b.put(a2, q);
                                        }
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (newPullParser.getName().equals("extensionProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText4 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText5 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText6 = newPullParser.nextText();
                                String a3 = a(nextText4, nextText5);
                                if (!this.f472a.containsKey(a3)) {
                                    try {
                                        Class q2 = l3.a.q(nextText6);
                                        if (ft.class.isAssignableFrom(q2)) {
                                            this.f472a.put(a3, q2.newInstance());
                                        } else if (fo.class.isAssignableFrom(q2)) {
                                            this.f472a.put(a3, q2);
                                        }
                                    } catch (ClassNotFoundException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            th = th;
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                        eventType = newPullParser.next();
                    } while (eventType != 1);
                    inputStream.close();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public Object m442a(String str, String str2) {
        return this.f472a.get(a(str, str2));
    }

    private String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        sb.append("/>");
        if (str != null) {
            sb.append("<");
            sb.append(str2);
            sb.append("/>");
        }
        return sb.toString();
    }

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof ft) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f472a.put(a(str, str2), obj);
    }
}
