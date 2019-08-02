package com.zx.bank.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zx.bank.entity.Account;
import com.zx.bank.entity.Trade;
import com.zx.bank.service.TradeService;
import com.zx.bank.service.impl.TradeServiceImpl;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Account user = (Account) session.getAttribute("user");
		if(user != null) {
			req.getRequestDispatcher("/WEB-INF/pages/info.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "您还没有登录,请登录！");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String startTime = req.getParameter("start_time");
		String endTime = req.getParameter("end_time");
		
		HttpSession session = req.getSession();
		Account user = (Account) session.getAttribute("user");
		
		TradeService tradeService = new TradeServiceImpl();
		List<Trade> trades = tradeService.getTradeList(startTime, endTime, user.getAccountId());
		req.setAttribute("trades", trades);
		req.getRequestDispatcher("/WEB-INF/pages/infolist.jsp").forward(req, resp);
	}

	private static final long serialVersionUID = 1L;

}
