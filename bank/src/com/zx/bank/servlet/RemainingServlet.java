package com.zx.bank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zx.bank.entity.Account;
import com.zx.bank.service.AccountService;
import com.zx.bank.service.impl.AccountServiceImpl;

@WebServlet("/remaining")
public class RemainingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Account user = (Account) session.getAttribute("user");
		if(user != null) {
			AccountService accountService = new AccountServiceImpl();
			Account account = accountService.getAccountById(user.getAccountId());
			req.setAttribute("remainingMoney", account.getRemaining());
			req.getRequestDispatcher("/WEB-INF/pages/remaining.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "您还没有登录,请登录！");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

}
