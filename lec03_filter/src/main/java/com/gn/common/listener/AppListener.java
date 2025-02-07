package com.gn.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener
public class AppListener implements ServletContextListener {
	public AppListener() {}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("===== 웹 애플리케이션 종료 =====");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("===== 웹 애플리케이션 시작 =====");
	}
	
}
