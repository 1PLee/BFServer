//�벻Ҫ�޸ı��ļ���
package serviceImpl;

import java.rmi.RemoteException;

import service.ExecuteService;
import service.UserService;

public class ExecuteServiceImpl implements ExecuteService {

	/**
	 * 请实现该方法
	 */
	@Override
	public String execute(String code, String param) throws RemoteException {
		// TODO Auto-generated method stub
		 int[] datas = new int[500];//״̬����
		 int p = 0;//״̬�����ָ��
		 int pc = 0;//�����ָ��
		 String result="";
		
			
		
			char[] temp1=new char[param.length()];
			
			temp1=param.toCharArray();
			int i=temp1.length;
			int a=0;
			char[] cmds = code.toCharArray();
			while(true){
				switch(cmds[pc]){
				case '>':
					p++;
					break;
				case '<':
					p--;
					break;
				case '+':
					datas[p]++;
					break;
				case '-':
					datas[p]--;
					break;
				case '.':
					result=result+String.valueOf((char)datas[p]);
					break;
					
				case ',':
				   if(a<i)datas[p]=temp1[a];
				   a++;
					break;
				case '[':
					if(datas[p] == 0){
						int flag=0;
						while(true){
							pc++;
							if(cmds[pc]=='['){
								flag++;
							}
							else if(cmds[pc]==']'&&flag!=0){
								flag--;
							}
							else if(cmds[pc]==']'&&flag==0){
								break;
							}
						}
					}
					break;
				case ']':
					if(datas[p]!=0){
						int flag=0;
						while(true){
							pc--;
							if(cmds[pc]==']'){
								flag++;
							}
							else if(cmds[pc]=='['&&flag!=0){
								flag--;
		
							}
							else if(cmds[pc]=='['&&flag==0){
								break;
							}
						}
					}
					break;
				}
				
				pc++;
				if(pc > cmds.length - 1){
				
					break;
				}
				
				
			}
		
				return result;
		
	}

}
