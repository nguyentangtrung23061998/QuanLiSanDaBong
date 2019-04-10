package com.quanlysandabong.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quanlysandabong.model.KhachHangModel;
import com.quanlysandabong.model.SanModel;
import com.quanlysandabong.service.IKhachHangService;
import com.quanlysandabong.utils.FormUtil;
import com.quanlysandabong.utils.HttpUtil;

@WebServlet(urlPatterns = { "/admin-khach-hang" })
public class KhachHangController extends HttpServlet{

	private static final long serialVersionUID = 2878735472038508105L;
	@Inject IKhachHangService khSV;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KhachHangModel khModel = FormUtil.toModel(KhachHangModel.class,request);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		khModel.setListResult(khSV.findAll());
		mapper.writeValue(response.getOutputStream(), khModel);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		KhachHangModel khModel =  HttpUtil.of(request.getReader()).toModel(KhachHangModel.class);
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		khModel = khSV.save(khModel);
		mapper.writeValue(response.getOutputStream(), khModel);
	}
}
