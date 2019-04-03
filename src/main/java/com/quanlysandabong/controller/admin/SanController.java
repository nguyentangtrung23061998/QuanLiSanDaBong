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

@WebServlet(urlPatterns = { "/admin-san" })
public class SanController extends HttpServlet{

	private static final long serialVersionUID = -2503144502374419550L;
	@Inject ISanService sanService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SanModel sanModel = FormUtil.toModel(SanModel.class,request);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		//sanModel.setListResult(sanService.findAll());
		System.out.println(sanModel);
		sanModel.setListResult(sanService.findAll());
		//mapper.writeValue(response.getOutputStream(), sanModel);
		System.out.println(sanModel);
	}
}
