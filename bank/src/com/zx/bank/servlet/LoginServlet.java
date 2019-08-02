package com.zx.bank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zx.bank.entity.Account;
import com.zx.bank.exception.BaseInfoException;
import com.zx.bank.service.AccountService;
import com.zx.bank.service.impl.AccountServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Account user = (Account) session.getAttribute("user");
		if(user != null) {
			req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "您还没有登录,请登录！");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account = req.getParameter("account");
		String pwd = req.getParameter("password");
		
		AccountService accountService = new AccountServiceImpl();
		try {
			Account acc = accountService.getAccount(account, pwd);
			
			HttpSession session = req.getSession();
			session.setAttribute("user", acc);
			req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
		}catch(BaseInfoException e) {
			req.setAttribute("msg", e.getMessage());
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}

}
