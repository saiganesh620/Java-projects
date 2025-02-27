details.html
============
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body bgcolor="cyan" text="blue">
		<pre>
			<h2 align="center" > Sumbit your details </h2>
			<form name="htmlform" action="hurl" method="get"><br>
				 <b> Name  : </b><input type=text   name="pname" size=10 > </br></br>
				 <b> Fname :</b> <input type=text   name="fname" size=10> </br></br>
				 <b> Age   :</b> <input type="text" name="age"   size=3 ></br></br>
				 <input type="submit" value="send">
			</form>
		</pre>
	 </body>
</html>

HtmlServlet.java
================


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HtmlServlet
 */
@WebServlet("/HtmlServlet")
public class HtmlServlet extends HttpServlet {
	public void doPost(HttpServletRequest hreq,HttpServletResponse hres)throws ServletException,IOException
	{
		PrintWriter pw = hres.getWriter();
		hres.setContentType("text/html");//MIME(Multi purpose Internet Mail Extension)
		String name = hreq.getParameter("pname");
		String fname = hreq.getParameter("fname");
		String yourage = hreq.getParameter("age");
		try
		{
			int age = Integer.parseInt(yourage.trim());
			String msg = null;
			
			if(age<=5)
				msg = "welcome Masster. " + name + " you are baby child";
			else if(age<=13)
				msg = "welcome Mr/Miss. " + name + " you are child";
			else if(age<=18) 
			  msg = "welcome Mr/Miss/Mrs. " + name + " you are teenager" ;
			else if(age<=60)
				msg = "welcome Mr/Miss/Mrs. " + name + " you are young man/woman";
			else
				msg = "weclome Mr/Miss/Mrs " + name + " you are old man/woman";

			pw.println("<font color=blue size=6>"+msg+"</font>"); 

		}//try
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("In do Post method");
	}//doPost

	public void doGet(HttpServletRequest hreq,HttpServletResponse hres)throws ServletException,IOException
	{
		try
		{
			doPost(hreq,hres);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("do Get method");

	}//doGet
}

web.xml
=======
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>HTMLwithServlet</display-name>
  <servlet>
       <servlet-name>ABC</servlet-name>
       <servlet-class>HtmlServlet</servlet-class>
   </servlet>

    <servlet-mapping>
        <servlet-name>ABC</servlet-name>
        <url-pattern>/hurl</url-pattern>
    </servlet-mapping>
    
    <welcome-file-list>
    	<welcome-file>details.html</welcome-file>
    </welcome-file-list>
</web-app>