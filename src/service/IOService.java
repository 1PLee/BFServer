//需要客户端的Stub
package service;

import java.awt.Component;
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IOService extends Remote{
	public boolean writeFile(String code, String username, String fileName)throws RemoteException;
	
	public String readFile(String user,String fileName)throws RemoteException;
	
	public String[] readFileList(String username)throws RemoteException;
	
    public String saveFile(String code, String username, String fileName)throws RemoteException;
    
    public void creatVersion(String code, String fileAddress)throws RemoteException;
    
    public String[] readVersionList(String username,String filename)throws RemoteException;
    
    public String readversionFile(String user,String filename,String version)throws RemoteException;
}
