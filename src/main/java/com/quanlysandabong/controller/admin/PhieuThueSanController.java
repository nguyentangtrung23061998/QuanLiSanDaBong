package com.quanlysandabong.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlysandabong.model.PhieuThueModel;
import com.quanlysandabong.model.SanModel;
import com.quanlysandabong.service.IPhieuThueService;
import com.quanlysandabong.utils.FormUtil;
import com.quanlysandabong.utils.HttpUtil;

@WebServlet(urlPatterns = { "/admin-phieu-thue" })
public class PhieuThueSanController extends HttpServlet{

	@Inject IPhieuThueService ptSV;
	private static final long serialVersionUID = -295861685542460270L;
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
		PhieuThueModel ptModel = FormUtil.toModel(PhieuThueModel.class,request);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ptModel.setListResult(ptSV.findAll());
		setCors(request,response);
		mapper.writeValue(response.getOutputStream(), ptModel);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PhieuThueModel ptModel =  HttpUtil.of(request.getReader()).toModel(PhieuThueModel.class);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ptModel = ptSV.save(ptModel);
		mapper.writeValue(response.getOutputStream(), ptModel);
	}
}
