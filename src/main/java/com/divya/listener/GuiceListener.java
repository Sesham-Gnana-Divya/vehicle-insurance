package com.divya.listener;

import javax.servlet.annotation.WebListener;

import com.divya.controller.GuiceController;
import com.divya.servlets.ForgotUser;
import com.divya.servlets.MainServlet;
import com.divya.servlets.RegisterServlet;
import com.google.inject.Guice;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;


@WebListener
public class GuiceListener extends GuiceServletContextListener {
		
	
	
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new JerseyServletModule() {
			@Override
			protected void configureServlets() {

				serve("/register").with(RegisterServlet.class);
				serve("/main").with(MainServlet.class);
				serve("/forgotuser").with(ForgotUser.class);

				bind(GuiceController.class);
				serve("/google/*").with(GuiceContainer.class);
			}
		});
	}

}


/*
@WebListener
public class GuiceListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		Injector injector = Guice.createInjector(new JerseyServletModule() {
			@Override
			protected void configureServlets() {

				//serve("/").with(GuiceServlet.class);
				serve("/login").with(LoginServlet.class);
				serve("/register").with(RegisterServlet.class);
				serve("/main").with(MainServlet.class);
				serve("/logout").with(LogoutServlet.class);

				bind(GuiceController.class);
				serve("/google/*").with(GuiceContainer.class);
			}
		}, new JpaPersistModule("db_manager"));

		injector.getInstance(JpaInitializer.class);

		return injector;
	}

}

class JpaInitializer {

	@Inject
	public JpaInitializer(PersistService persistService) {
		persistService.start();
	}
}
*/