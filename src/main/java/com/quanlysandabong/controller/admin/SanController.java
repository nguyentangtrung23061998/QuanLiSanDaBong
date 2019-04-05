package com.quanlysandabong.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.quanlysandabong.model.SanModel;
import com.quanlysandabong.service.ISanService;
import com.quanlysandabong.utils.FormUtil;
import com.quanlysandabong.utils.HttpUtil;

@WebServlet(urlPatterns = { "/admin-san" })
public class SanController extends HttpServlet{

	private static final long serialVersionUID = 2686801510274002166L;
	
	@Inject ISanService sanService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SanModel sanModel = FormUtil.toModel(SanModel.class,request);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		sanModel.setListResult(sanService.findAll());
		mapper.writeValue(response.getOutputStream(), sanModel);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SanModel sanModel = HttpUtil.of(request.getReader()).toModel(SanModel.class);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		sanModel = sanService.save(sanModel);
		mapper.writeValue(response.getOutputStream(), sanModel);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SanModel sanModel = HttpUtil.of(request.getReader()).toModel(SanModel.class);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		sanModel = sanService.update(sanModel);
		mapper.writeValue(response.getOutputStream(), sanModel);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SanModel sanModel = HttpUtil.of(request.getReader()).toModel(SanModel.class);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		sanService.delete(sanModel);
		mapper.writeValue(response.getOutputStream(), "{}");
	}
}
