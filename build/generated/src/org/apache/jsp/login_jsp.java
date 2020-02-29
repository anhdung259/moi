package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Bootstrap Simple Login Form</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script> \n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .login-form {\n");
      out.write("                width: 340px;\n");
      out.write("                margin: 50px auto;\n");
      out.write("            }\n");
      out.write("            .login-form form {\n");
      out.write("                margin-bottom: 15px;\n");
      out.write("                background: #f7f7f7;\n");
      out.write("                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\n");
      out.write("                padding: 30px;\n");
      out.write("            }\n");
      out.write("            .login-form h2 {\n");
      out.write("                margin: 0 0 15px;\n");
      out.write("            }\n");
      out.write("            .form-control, .btn {\n");
      out.write("                min-height: 38px;\n");
      out.write("                border-radius: 2px;\n");
      out.write("            }\n");
      out.write("            .btn {        \n");
      out.write("                font-size: 15px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    ");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"vn\">\n");
      out.write("<head>\n");
      out.write("  <title>Bootstrap Example</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("  <style>\n");
      out.write("    /* Remove the navbar's default rounded borders and increase the bottom margin */ \n");
      out.write("    .navbar {\n");
      out.write("      margin-bottom: 50px;\n");
      out.write("      border-radius: 0;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    /* Remove the jumbotron's default bottom margin */ \n");
      out.write("     .jumbotron {\n");
      out.write("      margin-bottom: 0;\n");
      out.write("    }\n");
      out.write("   \n");
      out.write("    /* Add a gray background color and some padding to the footer */\n");
      out.write("    footer {\n");
      out.write("      background-color: #f2f2f2;\n");
      out.write("      padding: 25px;\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"jumbotron\">\n");
      out.write("  <div class=\"container text-center\">\n");
      out.write("   <h1>HOMESTAY DaLat</h1>      \n");
      out.write("    <p>Chill and cheap</p>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("      </button>\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">Logo</a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav\">\n");
      out.write("        <li class=\"active\"><a href=\"index.jsp\">Home</a></li>\n");
      out.write("        <li><a href=\"booking.jsp\">Booking</a></li>\n");
      out.write("        <li><a href=\"#\">Service</a></li>\n");
      out.write("        <li><a href=\"#\">Contact</a></li>\n");
      out.write("      </ul>\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">  \n");
      out.write("        <li><a href=\"login.jsp\"><span class=\"glyphicon glyphicon-user\"></span> Login </a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"login-form\">\n");
      out.write("            <font color=\"green\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.OK}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</font>\n");
      out.write("            <form action=\"MainController\" method=\"post\">\n");
      out.write("                <h2 class=\"text-center\">Log in</h2>       \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    Username: <input type =\"text\"  class=\"form-control\" name=\"txtUsername\" placeholder=\"Username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtUsername}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\"/> \n");
      out.write("                    <font color =\"red\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.usernameError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </font>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    Password: <input type =\"password\" class=\"form-control\" placeholder=\"Password\" name=\"txtPassword\" value=\"\" required=\"required\"/>\n");
      out.write("                    <font color =\"red\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.INVALID.passwordError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </font>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-primary btn-block\" value=\"Login\" name=\"action\" /> <br/>  \n");
      out.write("                </div>\n");
      out.write("                <font color=\"red\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.FAIL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </font>\n");
      out.write("            </form>\n");
      out.write("         <p  class=\"text-center\">   Already have an account? <a href=\"register.jsp\">Create an Account</a></p>\n");
      out.write("             \n");
      out.write("        </div>\n");
      out.write("                   \n");
      out.write("    </body>\n");
      out.write("    ");
      out.write("<footer class=\"container-fluid text-center\">\n");
      out.write("  <p>Online Store Copyright</p>  \n");
      out.write("  <form class=\"form-inline\">Get deals:\n");
      out.write("    <input type=\"email\" class=\"form-control\" size=\"50\" placeholder=\"Email Address\">\n");
      out.write("    <button type=\"button\" class=\"btn btn-danger\">Sign Up</button>\n");
      out.write("  </form>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("</html> ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
