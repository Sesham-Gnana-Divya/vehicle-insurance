package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Guice Application</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("    <link rel=\"icon\" href=\"/images/icons/Logo.png\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"full-page\">\r\n");
      out.write("        <div class=\"navbar\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <a href=\"#\">JOSH Infra Pvt. Ltd.</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- <nav>\r\n");
      out.write("                <ul id=\"MenuItems\">\r\n");
      out.write("                    <li><button class=\"loginbtn\" onclick=\"document.getElementById('login-form').style.display='block'\" style=\"width:auto;\">Login</button></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </nav> -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class='login-page'>\r\n");
      out.write("            <div class=\"form-box\">\r\n");
      out.write("                <div class='button-box'>\r\n");
      out.write("                    <h1>Log In Form</h1>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <form id='login' class='input-group-login' action='login' method='post'>\r\n");
      out.write("                    <span style=\"color:black\">Enter User ID:</span>\r\n");
      out.write("                    <input type='number' class='input-field' id='username' name='username' placeholder='1234567890'\r\n");
      out.write("                        required>\r\n");
      out.write("                    <span style=\"color:black\">Enter Password:</span>\r\n");
      out.write("                    <input type='password' class='input-field' id='password' name='password'\r\n");
      out.write("                        placeholder='Enter Password' required>\r\n");
      out.write("                    <div class=\"miscelaneous\">\r\n");
      out.write("                        <a class=\"miscelaneous-text\" href=\"#\">Forgot Password</a>\r\n");
      out.write("                        <a class=\"miscelaneous-text\" href=\"register\">Register</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button type='submit' class='submit-btn'>Log in</button>\r\n");
      out.write("                    <div class='error-msg'>${Error.message }</div>\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
