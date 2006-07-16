package ar.com.espumito.core.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseWrapper extends
		javax.servlet.http.HttpServletResponseWrapper {
	private PrintWriter outWriter;
	
	public HttpServletResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	/**
	 * @see javax.servlet.ServletResponseWrapper#getWriter()
	 */
	public PrintWriter getWriter() throws IOException {
		return this.outWriter != null ? this.outWriter : super.getWriter();
	}

	/**
	 * @param outWriter The outWriter to set.
	 */
	public void setWriter(PrintWriter outWriter) {
		this.outWriter = outWriter;
	}

}
