package serviceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import service.IOService;

public class IOServiceImpl implements IOService{
	ArrayList<String>userlist1=new ArrayList<String>();
	
	@Override
	public boolean writeFile(String file, String userId, String fileName) {
		File f = new File(userId + "_" + fileName);
		try {
			FileWriter fw = new FileWriter(f, false);
			fw.write(file);
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void newFile(String userId)throws RemoteException{
		File dir=new File(userId);
		dir.mkdir();
		
	}
	public void addUser(String username)throws RemoteException{
		System.out.println("已进入addUser方法");
		if(userlist1.contains(username)){
				System.out.println("yes");
		}
		else{
			userlist1.add(username);
			System.out.println(2);
			System.out.println(userlist1.get(0));
		}
	}

	@Override
	public String readFile(String userId, String fileName) { 
		// TODO Auto-generated method stub
		return "OK";
	}

	@Override
	public String readFileList(String userId) {
		// TODO Auto-generated method stub
		return "OK";
	}
	
}
