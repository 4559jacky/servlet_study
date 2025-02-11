package com.gn.common;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListener() {
        
    }
    
    // HttpSeessionListener가 가지고 있는 메소드
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("===== 세션 객체 생성 =====");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
        System.out.println("===== 세션 사용 불가능 =====");
    }

    
    // HttpSessionAttributeListener의 메소드
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	System.out.println("세션 속성 추가");
    }
    
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	System.out.println("세션 속성 제거");
    }
    
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("세션 속성 대체");
    }
	
}
