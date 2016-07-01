package serviceImpl;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import service.IOService;
import javax.swing.JFileChooser;

import rmi.RemoteHelper;
public class IOServiceImpl implements IOService{
	

	@Override
	public boolean writeFile(String code, String username, String fileName) {
		
		ArrayList<String>fileversion=new ArrayList<String>();//根据时间记录每个版本
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = df.format(new Date()).toString(); 
		File versionfile=new File(username+"\\"+fileName+"\\"+date+".bf");
		System.out.println(code);
		if (fileversion.size()<5){
			try {
				FileWriter fw = new FileWriter(versionfile, false);
				fw.write(code);
				fw.flush();
				fw.close();
				fileversion.add(date);
		
			//	saveVersion(userId, fileName, versionInfo);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		else {
		

			try {
				File del = new File (username+"\\"+fileName+"\\"+fileversion.get(0)+".bf");
				del.delete();
				FileWriter fw = new FileWriter(versionfile, false);
				fw.write(code);
				fw.flush();
				fw.close();
				fileversion.remove(0);
				fileversion.add(date);
			//	saveVersion(userId, fileName, versionInfo);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
 

	@Override
	public String readFile(String user,String filename) { 
		// TODO Auto-generated method stub
		String line="";
		File selectfile=new File(user+"\\"+filename);
		File[] files=selectfile.listFiles();
		System.out.println(String.valueOf(files[0]));
		
		try{
			InputStreamReader isr = new InputStreamReader(new FileInputStream(files[0]));
			BufferedReader br = new BufferedReader(isr);
			StringBuilder SB = new StringBuilder();
	
			while ((line=br.readLine())!=null){
				SB.append(line);
				SB.append("\n");
			}
			br.close();
			return SB.toString();
		}catch(IOException e){
			e.printStackTrace();
			return "Fail";
		}
		
	}

	@Override
	public String[] readFileList(String username) {
		// TODO Auto-generated method stub
		String [] user=new String[100];
		File fatherfile = new File(username);
        user=fatherfile.list();
		return user;
	}


	@Override
	public String saveFile(String code, String username, String fileName) throws RemoteException {
		// TODO Auto-generated method stub
		String result="";
		File personFile=new File(username+"\\"+fileName);
		if(personFile.isDirectory()){
			if(writeFile(code,username,fileName)){
				result="文件名已存在 增加版本成功";
			}
			else{
				result="文件名已存在 增加版本失败";
			}
			
		}
		else{
			personFile.mkdirs();
			if(writeFile(code,username,fileName)){
				result="创建成功";
			}
			else{
				result="创建失败";
			}
		}
		
		
		return result;
	}


	@Override
	public void creatVersion(String code, String fileAddress) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String[] readVersionList(String username, String filename) throws RemoteException {
		// TODO Auto-generated method stub
		String [] version=new String[100];
		File sonfile = new File(username+"\\"+filename);
        version=sonfile.list();
		return version;
	}


	@Override
	public String readversionFile(String user, String filename, String version) throws RemoteException {
		// TODO Auto-generated method stub
		String line="";
		File selectversion=new File(user+"\\"+filename+"\\"+version);
		try{
			InputStreamReader isr = new InputStreamReader(new FileInputStream(selectversion));
			BufferedReader br = new BufferedReader(isr);
			StringBuilder SB = new StringBuilder();
	
			while ((line=br.readLine())!=null){
				SB.append(line);
				SB.append("\n");
			}
			br.close();
			return SB.toString();
		}catch(IOException e){
			e.printStackTrace();
			return "Fail";
		}
		
		
	}



	
	
}
