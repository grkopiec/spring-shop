package pl.shop.mvc.interceptors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PerformanceInterceptor implements HandlerInterceptor {
	private static final Logger logger = Logger.getLogger(PerformanceInterceptor.class);
	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);
		logger.info("Processing request to path: " + getUrlPath(request) + ", started at: " + getCurrentTime());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("Processing request to path: " + getUrlPath(request) + ", finished at: " + getCurrentTime());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		StopWatch stopWatch = stopWatchLocal.get();
		stopWatch.stop();
		logger.info("Total time of request processing: " + stopWatch.getTotalTimeMillis() + " ms");
		stopWatchLocal.set(null);
	}
	
	private String getUrlPath(HttpServletRequest request) {
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		return currentPath + queryString;
	}
	
	private String getCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime dateNow = LocalDateTime.now();
		return dateNow.format(formatter);
	}
}
