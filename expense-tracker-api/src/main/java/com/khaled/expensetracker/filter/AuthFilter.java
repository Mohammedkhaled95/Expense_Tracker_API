package com.khaled.expensetracker.filter;

import org.springframework.web.filter.GenericFilterBean;

public class AuthFilter {//extends GenericFilterBean {
/*
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String authHeader = httpRequest.getHeader("Authorization");

		if (authHeader != null) {
			String[] authHeaderArr = authHeader.split("Bearer ");
			if (authHeaderArr.length > 1 && authHeaderArr[1] != null) {

				String token = authHeaderArr[1];
				try {
					Claims claims = Jwts.parser().setSigningKey(Constants.API_SECRET_KEY).parseClaimsJws(token)
							.getBody();
					
					// this will make token available all over our code because it is attached to
					// request
					//System.out.println(claims.get("userId"));
					httpRequest.setAttribute("userId", "555");//claims.get("userId").toString()
				} catch (Exception e) {
					

					httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid/Expired Token");
					return;
				}

			} else {
				// token is not in the correct format
				httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Token must be Bearer [token]");
				return;

			}

		}else {
			//token is not provided from user in the header
			httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Auth Token must be provided");
			return;

		}
		
		

		chain.doFilter(httpRequest, httpResponse);
	}
*/
}
