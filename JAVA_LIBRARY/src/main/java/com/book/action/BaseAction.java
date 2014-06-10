package com.book.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSON;
import com.book.model.Librarian;
import com.book.model.Reader;

@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public void writeJson(Object object) {
		ServletWrite(JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
	}

	public void writeJsonObj(Object object) {
		ServletWrite(JSON.toJSON(object).toString());
	}

	public void setLibrarianSession(Object librarian) {
		request.getSession().setAttribute("libraryInfo", librarian);
	}

	public void setReaderSession(Object reader) {
		request.getSession().setAttribute("readerInfo", reader);
	}

	public Librarian getLibrarianSession() {
		return (Librarian) request.getSession().getAttribute("libraryInfo");
	}

	public Reader getReaderSession() {
		return (Reader) request.getSession().getAttribute("readerInfo");
	}

	private void ServletWrite(String json) {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

}
