package org.phoenix.basic.utils;

import org.hibernate.Session;

/**
 * Created by Kemi on 2017/10/26.
 * Description:
 */
public class PerThreadSessionUtil {
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();
    public static Session getSession(){
        if(sessionThreadLocal.get()!= null){
            return sessionThreadLocal.get();
        }
        return null;
    }
    public static Session addSession(Session session){
        sessionThreadLocal.set(session);
        return session;
    }
    public static void closeSession(){
        Session session = sessionThreadLocal.get();
        if(session != null){
            sessionThreadLocal.remove();
            synchronized (session){
                if(session.isOpen()){
                    session.close();
                }
            }
            sessionThreadLocal.set(null);
        }
    }

}
