package pl.shop.mvc.interceptors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuditingInterceptor extends HandlerInterceptorAdapter {	//we extends class that have implemented interface "HandlerInterceptor"
	private static final Logger logger = Logger.getLogger("auditLogger");	//get logger that is defined in "log4j.properties"
	private String user;
	private String productId;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (request.getRequestURI().endsWith("/products/add") && request.getMethod().equals("POST")) {
			user = request.getRemoteUser();
			productId = request.getParameterValues("id")[0];
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		if (request.getRequestURI().endsWith("/products/add") && response.getStatus() == 302) {
			logger.info(String.format("New product [%s] added by %s at %s", productId, user, getCurrentTime()));
		}
	}
	
	private String getCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateNow = LocalDateTime.now();
		return dateNow.format(formatter);
	}
}
