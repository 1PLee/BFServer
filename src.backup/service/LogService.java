package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface LogService extends Remote{
		public String log(String username,String password)throws RemoteException;//�����ַ������ڴ��������ļ���
}
