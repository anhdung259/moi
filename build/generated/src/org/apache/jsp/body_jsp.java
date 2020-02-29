package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class body_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<marquee  color=\"red\">\n");
      out.write("Enter \"VNVD\" or \"VIETNAMVODICH\" code to get 50% discount\n");
      out.write("\n");
      out.write("</marquee>\n");
      out.write("<div class=\"container\">    \n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">SUPER PROMOTIONS</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"image\\2.jpg\" class=\"img-rounded\" width=\"300\" height=\"260\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">Enter \"VNVD\" or \"VIETNAMVODICH\" code to get 50% discount</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-4\"> \n");
      out.write("            <div class=\"panel panel-danger\">\n");
      out.write("                <div class=\"panel-heading\">SUPER PROMOTIONS</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"image/3.jpg\" class=\"img-rounded\" width=\"300\" height=\"260\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">Enter \"VNVD\" or \"VIETNAMVODICH\" code to get 50% discount</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-4\"> \n");
      out.write("            <div class=\"panel panel-success\">\n");
      out.write("                <div class=\"panel-heading\">SUPER PROMOTIONS</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"image/4.jpg\" class=\"img-rounded\" width=\"300\" height=\"260\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">Enter \"VNVD\" or \"VIETNAMVODICH\" code to get 50% discount</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div><br>\n");
      out.write("\n");
      out.write("<div class=\"container\">    \n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-sm-4\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">SUPER PROMOTIONS</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"image/5.jpg\" class=\"img-rounded\" width=\"300\" height=\"260\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">Enter \"VNVD\" or \"VIETNAMVODICH\" code to get 50% discount</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-4\"> \n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">SUPER PROMOTIONS</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"image/6.jpg\" class=\"img-rounded\" width=\"300\" height=\"260\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">Enter \"VNVD\" or \"VIETNAMVODICH\" code to get 50% discount</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-4\"> \n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">SUPER PROMOTIONS</div>\n");
      out.write("                <div class=\"panel-body\"><img src=\"image/8.jpg\" class=\"img-rounded\" width=\"300\" height=\"260\" alt=\"Image\"></div>\n");
      out.write("                <div class=\"panel-footer\">Enter \"VNVD\" or \"VIETNAMVODICH\" code to get 50% discount</div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div><br><br>");
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
