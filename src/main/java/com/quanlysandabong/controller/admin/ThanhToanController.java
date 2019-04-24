package com.quanlysandabong.controller.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlysandabong.model.ThanhToanModel;
import com.quanlysandabong.service.IThanhTienService;
import com.quanlysandabong.utils.FormUtil;
import com.quanlysandabong.utils.HttpUtil;
import com.sun.xml.internal.ws.api.server.ContainerResolver;
import java.io.PrintWriter;

//text

@WebServlet(name="myservlet	",urlPatterns = { "/admin-thanh-toan" })

public class ThanhToanController extends HttpServlet {

	private static final long serialVersionUID = -7212567614801461066L;
	@Inject
	IThanhTienService ttService;
	protected void setCors(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			// CORS "pre-flight" request
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,OPTIONS");
			// response.addHeader("Access-Control-Allow-Headers", "Authorization");
			response.addHeader("Access-Control-Allow-Headers","Origin,Observe, X-Requested-With, Content-Type, Accept");
			response.addHeader("Access-Control-Max-Age", "1");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			//addCorsHeader(response);
			ThanhToanModel ttModel = FormUtil.toModel(ThanhToanModel.class, request);
			ObjectMapper mapper = new ObjectMapper();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			ttModel.setListResult(ttService.findAll());
			setCors(request,response);
			mapper.writeValue(response.getOutputStream(), ttModel);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ThanhToanModel ttModel = HttpUtil.of(request.getReader()).toModel(ThanhToanModel.class);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ttModel = ttService.save(ttModel);
		mapper.writeValue(response.getOutputStream(), ttModel);
		
	}

	

	


}
