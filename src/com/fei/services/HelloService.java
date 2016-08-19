package com.fei.services;

import java.util.ArrayList;
import java.util.List;

import com.fei.beans.User;
import com.fei.beans.UserInfo;

public class HelloService {

	
	public HelloService() {
		
	}
	public String sayHello1(User user) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<h2><font color=blue>");
		sb.append("Hello " + user.getName() + " with age " + user.getAge() + ", welcome to JavaEE!");
		sb.append("</font></h2>");
		sb.append("</body></html>");
		return sb.toString();
	}
	
	public String sayHello2(User user) {
		return "Hello " + user.getName() + "(" + user.getAge() + "), welcome to JavaEE!";
	}
	
	public UserInfo process(User user) {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setMsg(this.sayHello2(user));
		List<User> res = new ArrayList<User>();
		User newUser = new User();
		newUser.setAge(18);
		newUser.setName("fei");
		res.add(newUser);
		userInfo.setUsers(res);
		return userInfo;
	}
}
