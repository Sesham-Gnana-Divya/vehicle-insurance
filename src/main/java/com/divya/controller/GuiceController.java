package com.divya.controller;

import java.io.IOException;
import java.net.URI;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.divya.service.UserService;
import com.divya.utils.UriUtils;
import com.google.inject.Inject;

@Path("/app")
public class GuiceController {
	
	HTMLConstant htmlConstant = new HTMLConstant();

	@Inject
	UserService userService;

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_HTML)
	public Response sayHello(@Context ServletContext servletContext, @Context UriInfo uriInfo) {

		String message = "This is a text response";

	    return Response
	      .status(Response.Status.OK)
	      .entity(message)
	      .build();
	}
	
	@GET
	@Path("/logout")
	@Produces(MediaType.TEXT_HTML)
	public Response logout(@Context ServletContext servletContext, @Context UriInfo uriInfo) {

		URI contextPath = UriUtils.getFullServletContextPath(servletContext, uriInfo);

		UriBuilder uriBuilder = UriBuilder.fromUri(contextPath);
		uriBuilder.path("/");

		return Response.seeOther(uriBuilder.build()).build();
	}
	
	@GET
	@Path("/main")
	@Produces(MediaType.TEXT_HTML)
	public Response mainpage(@Context ServletContext servletContext, @Context UriInfo uriInfo) {

		URI contextPath = UriUtils.getFullServletContextPath(servletContext, uriInfo);

		UriBuilder uriBuilder = UriBuilder.fromUri(contextPath);
		uriBuilder.path("main");

		return Response.seeOther(uriBuilder.build()).build();
	}

	@GET
	@Path("/login")
	@Produces(MediaType.TEXT_HTML)
	public Response authenticate(@QueryParam("userid") String userid, @QueryParam("password") String password) throws JSONException, ServletException, IOException {
		System.out.println("------------------------------------");
		System.out.println("Login Attempt");
		System.out.println("User ID: " + userid);
		System.out.println("Password: " + password);
		
		int message = userService.authenticate(userid, password);
		
		
		if(message != 0) {
			
			String response = htmlConstant.head();
			
			response += "<h1>Login Failed</h1><br>";
			response += "<span style=\"color: red\">Error: ";
			
			if(message == 1) {
				response += "user not found";
			}
			else if(message == 2) {
				response += "authentication failed";
			}
			
			response += "</span><br>";
			response += "<a href=\"logout\">return</a>";
			response += htmlConstant.tail();
			
			return Response.status(Response.Status.OK).entity(response).build();
			
			
		}

		UriBuilder uriBuilder = UriBuilder.fromUri("http://localhost:8080/google-guice-web");
		uriBuilder.path("main");
		
		System.out.println("------------------------------------");

		return Response.seeOther(uriBuilder.build()).build();
	}

	@GET
	@Path("/register")
	@Produces(MediaType.TEXT_HTML)
	public String register(@QueryParam("userid") String userid, @QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("confirm_password") String confirm_password) throws JSONException {
		System.out.println("------------------------------------");
		System.out.println("Registration Attempt");
		System.out.println("User ID: " + userid);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Confirm Password: " + confirm_password);
		
		String response = htmlConstant.head();

		int message = userService.save(userid, confirm_password, password, confirm_password);
		if(message != 0) {
			response += "<h1>Registration Failed</h1><br>";
			response += "<span style=\"color: red\">Error: ";
			if(message == 1) {
				response += "password mismatch";
			}
			else if(message == 2) {
				response += "userid already existing";
			}
			else {
				response += "unknown error";
			}
			response += "</span><br>";
			response += "<a href=\"/google-guice-web/register\">return</a>";
		}
		else {
			response += "<h1>Registration Successful</h1><br>";
			response += "User ID: "+ userid +"<br>";
			response += "User Name: "+ username +"<br>";
			response += "Password: "+ password +"<br>";
			response += "<a href=\"main\">Go to HomePage</a>";

		}
		
		response += htmlConstant.tail();
		System.out.println("------------------------------------");
		return response;
	}
	
	@GET
	@Path("/forgotuser")
	@Produces(MediaType.TEXT_HTML)
	public Response retrieve(@QueryParam("userid") String userid) throws JSONException, ServletException, IOException {
		System.out.println("------------------------------------");
		System.out.println("Forgot User Attempt");
		System.out.println("User ID: " + userid);
		
		JSONObject jsonObject = userService.retrieve(userid);
		
		String response = htmlConstant.head();
		
		
		if(jsonObject == null) {			
			response += "<h1>Operation Failed</h1><br>";
			response += "<span style=\"color: red\">Error: user not found</span><br>";
		} else {
			response += "<h1>User Details Found</h1><br>";
			response += "User ID: "+ jsonObject.getString("userid") +"<br>";
			response += "User Name: "+ jsonObject.getString("username") +"<br>";
			response += "Password: "+ jsonObject.getString("password") +"<br>";
		}
		
		
		System.out.println("------------------------------------");
		response += "<a href=\"/google-guice-web/forgotuser\">return</a>";
		response += htmlConstant.tail();

		return Response.status(Response.Status.OK).entity(response).build();
	}

}


class HTMLConstant{
	
	String head() {
		return "<html>"
				+ "<head>"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Guice Application</title>\r\n"
				+ "</head>"
				+ "<body>";
	}
	
	String tail() {
		return "</body>"
				+ "</html>";
	}
}
