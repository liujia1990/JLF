package org.jlf.product.quartz.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.jlf.core.JLFCore;

/**
 * 
 * @ClassName: StartServlet
 * @Description:启动JLF服务
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class StartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init();
		try {
			JLFCore.starts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
