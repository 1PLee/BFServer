package serviceImpl;

import java.awt.Component;
import java.rmi.RemoteException;
import java.util.ArrayList;
import service.UserService;

public class UserServiceImpl implements UserService{
	ArrayList<String>userlist=new ArrayList<String>();
	ArrayList<String>passlist=new ArrayList<String>();
	@Override	public String addUser(String username,String password) throws RemoteException{
					String result="";
			
					if(userlist.contains(username)){
						result="该用户已存在 ";
					}
					else{
						userlist.add(username);
						passlist.add(password);
						result="创建成功！";
					}

		return result;
	}
  
	public boolean login(String username, String password) throws RemoteException {
		boolean flag=false;
	
		int flag1=0;
		
		if(userlist.contains(username)){
			System.out.println(3);
			  flag1=userlist.indexOf(username);
			  System.out.println(flag1);
			  if(passlist.get(flag1).equals(password)){
				  System.out.println("密码正确");
				  flag=true;
			  }
		}
		else{
		    flag=false;
		}
	    
		return flag;
	}
	
	@Override
	public boolean logout(String username) throws RemoteException {
		return true;
	}

}
