package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ff {
    private static int a;

    /* renamed from: a, reason: collision with other field name */
    private static Vector<String> f445a;
    private static int b;
    private static int c;
    private static int d;

    /* renamed from: a, reason: collision with other method in class */
    public static String m427a() {
        return "3.1.0";
    }

    private ff() {
    }

    public static int a() {
        return b;
    }

    public static int b() {
        return c;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static ClassLoader[] m428a() {
        ClassLoader[] classLoaderArr = {ff.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    static {
        Covode.recordClassIndex(655520);
        a = 5000;
        b = 330000;
        c = 600000;
        d = 330000;
        f445a = new Vector<>();
        try {
            for (ClassLoader classLoader : m428a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        try {
                            inputStream = resources.nextElement().openStream();
                            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, "UTF-8");
                            int eventType = newPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (newPullParser.getName().equals("className")) {
                                        a(newPullParser);
                                    } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                        a = a(newPullParser, a);
                                    } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                        b = a(newPullParser, b);
                                    } else if (newPullParser.getName().equals("mechName")) {
                                        f445a.add(newPullParser.nextText());
                                    }
                                }
                                eventType = newPullParser.next();
                            } while (eventType != 1);
                        } catch (Throwable th) {
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            l3.a.q(nextText);
        } catch (ClassNotFoundException unused) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
        }
    }

    private static int a(XmlPullParser xmlPullParser, int i) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }
}
