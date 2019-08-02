package com.zx.bank.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zx.bank.entity.Account;
import com.zx.bank.exception.BaseInfoException;
import com.zx.bank.service.TradeService;
import com.zx.bank.service.impl.TradeServiceImpl;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Account user = (Account) session.getAttribute("user");
		if (user != null) {
			req.getRequestDispatcher("/WEB-INF/pages/transfer.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "您还没有登录,请登录！");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String receiveAccount = req.getParameter("receive_account");
		String receiveMoney = req.getParameter("receive_money");
		
		HttpSession session = req.getSession();
		Account user = (Account) session.getAttribute("user");
		
		TradeService tradeService = new TradeServiceImpl();
		
		try {
			tradeService.transferAccount(receiveAccount, new BigDecimal(receiveMoney), user.getAccountId());
			req.setAttribute("msg", "你已成功将￥["+receiveMoney+"]转入到["+receiveAccount+"账号]！");
			req.getRequestDispatcher("/WEB-INF/pages/transferok.jsp").forward(req, resp);
		}catch(BaseInfoException e) {
			req.setAttribute("msg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/pages/transfer.jsp").forward(req, resp);
		}
		
		
	}

}
