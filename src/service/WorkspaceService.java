package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WorkspaceService extends Remote{
	public boolean renameProject(String userName, String oldProjectName, String newProjectName) throws RemoteException;

	public boolean removeProject(String userName, String projectName) throws RemoteException;

	public boolean addProject(String userName, String newProjectName) throws RemoteException;
}
