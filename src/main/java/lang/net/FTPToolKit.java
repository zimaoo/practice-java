package lang.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.net.ftp.*;

public class FTPToolKit {
	private static final int bufferSize = 1024 * 2;
	private static final int dataTimeout = 30 * 1000;
	private String ip;
	private int port;
	private String user;
	private String password;
	private FTPClient client;
	private String rootPath = null;
	/**
	 * @param ip
	 * @param port
	 * @param user
	 * @param password
	 */
	public FTPToolKit(String ip,int port,String user,String password){
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.password = password;
	}
	/**
	 * 获取ftp连接
	 * @return
	 */
	public boolean login(boolean passive){
		boolean isLogin = false;
		FTPClientConfig ftpClientConfig = new FTPClientConfig();
		ftpClientConfig.setServerTimeZoneId(TimeZone.getDefault().getID());
		client = new FTPClient();
		client.setControlEncoding("utf-8");
		client.configure(ftpClientConfig);
		try {
			if (port > 0) {
				client.connect(ip, port);
			} else {
				client.connect(ip);
			}
			// FTP服务器连接回答
			int reply = client.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				client.disconnect();
				return isLogin;
			}
			client.login(this.user, this.password);
			// 设置传输协议
			if(passive){
				client.enterLocalPassiveMode();
			}else{
				client.enterLocalActiveMode();
			}
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			rootPath = client.printWorkingDirectory();
			System.out.println("rootPath: ".concat(rootPath));
			isLogin = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		client.setBufferSize(bufferSize);
		client.setDataTimeout(dataTimeout);
		return isLogin;
	}
	/**
	 * @退出关闭服务器链接
	 * */
	public void ftpLogOut() {
		if (null != client && client.isConnected()) {
			try {
				client.logout();// 退出FTP服务器
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					client.disconnect();// 关闭FTP服务器的连接
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
     * FTP下载文件到本地一个文件夹,如果本地文件夹不存在，则创建必要的目录结构
     *
     * @param remoteFileName  FTP文件 包括目录和文件名,注意不写用户名;
     * @param localFolderPath 存的本地目录
     * 待下载目录必须存在,由于不会自己创建,故会下载失败
     */
	public boolean download(String localFolderPath,String remoteFileName){
			//System.out.println("传入的参数localFolderPath:"+localFolderPath+"||remoteFileName="+remoteFileName);
			localFolderPath = localFolderPath.replace("\\", "/");
			remoteFileName = remoteFileName.replace("\\", "/");
			if(!localFolderPath.endsWith("/"))
				localFolderPath += "/";
			boolean flag = false;
			try {
				client.changeWorkingDirectory(rootPath + remoteFileName.substring(remoteFileName.lastIndexOf('/') + 1));
				System.out.println("ftp转换当前工作目录changeWorkingDirectory为:"+rootPath + remoteFileName);
				//判断文件是否存在
				String filePath = rootPath + remoteFileName;
				flag = true;
				if(flag == false){
					//System.out.println("待下载的文件不存在!");
					System.out.println(filePath+"--该待下载文件不存在!!!");
					return false;
				}else{
					if(client.printWorkingDirectory().endsWith(remoteFileName)){
					//System.out.println("工作路径为待下载文件路径!");
					//System.out.println("FtpToolkit待下载文件路径client.printWorkingDirectory()存在:"+client.printWorkingDirectory());
					FTPFile[] files = client.listFiles();
					localFolderPath = localFolderPath + ((remoteFileName.indexOf('/') != -1) ? remoteFileName.substring(remoteFileName.lastIndexOf('/') + 1):remoteFileName);
					new File(localFolderPath).mkdirs();
					for(FTPFile f : files){
						if(f.isDirectory()){
							download(localFolderPath,remoteFileName + "/" + f.getName());
						}else{
							String fileName = localFolderPath +"/" + f.getName();
							BufferedOutputStream outStream = null;
							boolean success = false;
							try {
								client.changeWorkingDirectory(rootPath + "/" + remoteFileName);
								//System.out.println(client.printWorkingDirectory());
								outStream = new BufferedOutputStream(new FileOutputStream(fileName));
								//System.out.println(remoteFileName +"/"+ f.getName() + "开始下载....");
								success = client.retrieveFile(f.getName(), outStream);
							} catch (Exception e) {
								e.printStackTrace();
							}finally{
								if(outStream != null)
									try{
										outStream.flush();
									}catch(Exception e){
										e.printStackTrace();
									}
								if(outStream != null)
									try{
										outStream.close();
									}catch(Exception e){
										e.printStackTrace();
									}
							}
						}
					}
				}else{
					//System.out.println("工作路径并非是待下载文件路径!!");
					if(remoteFileName.indexOf('/') == -1){
						//System.out.println("如果待下载文件中目录不存在多级目录/--进入到rootPath待下载文件目录=="+rootPath);
						client.changeWorkingDirectory(rootPath);
					}
					else{
						//System.out.println("存在多级目录,进入到remoteFileName中的文件所在目录!!=="+remoteFileName);
						client.changeWorkingDirectory(rootPath + "/" + remoteFileName.substring(0,remoteFileName.lastIndexOf('/')));
						//System.out.println("11111目录!!=="+rootPath + "/" + remoteFileName.substring(0,remoteFileName.lastIndexOf('/')));
					}
					//获取待下载文件名
					// String fileName = remoteFileName.indexOf('/') != -1 ? remoteFileName.substring(remoteFileName.lastIndexOf('/') + 1):remoteFileName;

//					String[] filesIs = client.listNames(filePath);
                    FTPFile[] ftpFiles = client.listFiles(filePath, new FTPFileFilter() {
                        @Override
                        public boolean accept(FTPFile file) {
                            return file.getName().endsWith(".zip");
                        }
                    });
					List<String> filesIs = new ArrayList<>();
					for (FTPFile ftpFile : ftpFiles) {
					    filesIs.add(ftpFile.getName());
                    }
					for (String fileName : filesIs) {
                        System.out.println("FtpToolkit待下载文件名:"+fileName);
                        //构造本地存储路径和文件名
                        String strFileName = localFolderPath + fileName;
                        System.out.println("FtpToolkit本地存储路径和文件名:"+strFileName);
                        BufferedOutputStream outStream = null;
                        boolean success = false;
                        try {
                            outStream = new BufferedOutputStream(new FileOutputStream(strFileName));
                            System.out.println("开始下载.......");
                            //System.out.println(remoteFileName + "开始下载....");
                            client.enterLocalPassiveMode();
                            client.setControlEncoding("UTF-8");
                            //success = client.retrieveFile(new String(remoteFileName.getBytes("UTF-8"), "iso-8859-1"), outStream);
                            success = client.retrieveFile(new String(fileName.getBytes("UTF-8"),"iso-8859-1"), outStream);
                            System.out.println("FtpToolkit方法下载文件是否成功=="+success);
                            if (success == true) {
                                //System.out.println(remoteFileName + "成功下载到" + strFileName);
                                System.out.println("成功下载....将"+remoteFileName+"下载到" + strFileName);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally{
                            if(outStream != null)
                                outStream.flush();
                            if(outStream != null)
                                outStream.close();
                        }
                    }
				}
			}
			}catch (IOException e) {
				e.printStackTrace();
			}
		return true;
	}

	/**
	 * FTP创建目录，如果目录不存在，则会递归创建
	 * @param path
	 */
    public void makeDirectory(String path){

        try {
            //client.makeDirectory(path);
            if(client.changeWorkingDirectory(path)){

            }else{
            	//System.out.println("makeDirectory方法递归创建目录!!");
                String subPath = path.substring(0,path.lastIndexOf(File.separator));
                makeDirectory(subPath);
                client.makeDirectory(path);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	/**
     * FTP上传本地文件到FTP的一个目录下
     *
     * @param localFileName        本地文件路径及名称
     * @param remoteFileName FTP上传目录 ,不包含用户路径以及文件名称;
     * eg:绝对路径为/frt/backup/AGT/AGT_COURT/ctrl/要写成backup/AGT/AGT_COURT/ctrl/
     * 上传到的目的目录必须存在,不会自己创建,故会下载失败
     */
	public boolean upload(String localFileName,String remoteFileName){
		boolean result = false;
		File localFile = new File(localFileName);
		String fileName = localFile.getName();
		System.out.println("待上传文件名称fileName="+fileName);
		makeDirectory(rootPath + "/" +remoteFileName);
		System.out.println("创建目录makeDirectory:"+rootPath + "/" + remoteFileName);
		if(localFile.isDirectory()){
			//System.out.println(remoteFileName + "开始上传....");
			//System.out.println("localFile是个目录,需要创建远程目录:");
			try {
				if(localFileName.indexOf(File.separator) != -1){
					localFileName = localFileName.substring(localFileName.lastIndexOf(File.separator) + 1);
				}
				client.makeDirectory(rootPath + "/" + (remoteFileName = remoteFileName +"/"+ localFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			File[] allFile = localFile.listFiles();
			for (File f : allFile) {
				String srcName = f.getPath().toString();
				upload(srcName, remoteFileName);
			}
			result = true;
		}else{
			//System.out.println("localFile不是个目录,直接上传");
			BufferedInputStream inStream = null;
			try{
				//System.out.println(remoteFileName + "开始上传....");
				client.setFileType(FTPClient.BINARY_FILE_TYPE);
				client.changeWorkingDirectory(rootPath + "/" + remoteFileName);// 改变工作路径
				//System.out.println("上传工作路径:"+rootPath + "/" + remoteFileName);
				inStream = new BufferedInputStream(new FileInputStream(localFile));
				result = client.storeFile(new String(fileName.getBytes("UTF-8")), inStream);
				//System.out.println("FtpToolkit上传工是否成功result:"+result);
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				if(inStream != null)
					try {
						inStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		return result;
	}
	/**
	public static void main(String[] args) {
		String ip = args[0];
		int port = Integer.parseInt(args[1]);
		String user = args[2];
		String password = args[3];
		FtpToolkit ft = new FtpToolkit(ip, port, user, password);
		ft.login(false);
		if("1".equals(args[5])){
			ft.download(args[4], args[5]);
		}else{
			ft.upload(args[4], args[5]);
		}
		ft.ftpLogOut();
	}*/
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = Integer.parseInt("2121");
		String user = "frt";
		String password = "frt";
		FTPToolKit ft = new FTPToolKit(ip, port, user, password);
		ft.login(true);
		if(true){
			ft.download("/Users/wanba/zip", "");
		}else{
			ft.upload("D:\\zip\\1.txt", "backup/AGT/AGT_COURT/hist");
		}
		ft.ftpLogOut();
	}
}
