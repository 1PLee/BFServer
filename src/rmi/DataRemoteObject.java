package rmi;

import java.awt.Component;
import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import service.ExecuteService;
import service.IOService;
import service.UserService;
import serviceImpl.IOServiceImpl;
import serviceImpl.UserServiceImpl;
import serviceImpl.ExecuteServiceImpl;

public class DataRemoteObject extends UnicastRemoteObject implements IOService, UserService,ExecuteService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4029039744279087114L;
	private IOService iOService;
	private UserService userService;
	private ExecuteService executeService;
	protected DataRemoteObject() throws RemoteException {
		iOService = new IOServiceImpl();
		userService = new UserServiceImpl();
		executeService=new ExecuteServiceImpl();
	}

	@Override
	public boolean writeFile(String file, String username, String fileName) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.writeFile(file, username, fileName);
	}

	@Override
	public String readFile(String username,String filename) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFile(username,filename);
	}

	@Override
	public String[] readFileList(String userId) throws RemoteException{
		// TODO Auto-generated method stub
		return iOService.readFileList(userId);
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.login(username, password);
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.logout(username);
	}
	public String execute(String code, String param) throws RemoteException{
		return executeService.execute(code,param);
	}



	@Override
	public String addUser(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return userService.addUser(username, password);
	}

	@Override
	public String saveFile(String code, String username, String fileName) throws RemoteException {
		// TODO Auto-generated method stub
		return iOService.saveFile(code, username, fileName);
	}

	@Override
	public void creatVersion(String code, String fileAddress) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] readVersionList(String username, String filename) throws RemoteException {
		// TODO Auto-generated method stub
		return iOService.readVersionList(username, filename);
	}

	@Override
	public String readversionFile(String user, String filename, String version) throws RemoteException {
		// TODO Auto-generated method stub
		return iOService.readversionFile(user, filename, version);
	}




}
