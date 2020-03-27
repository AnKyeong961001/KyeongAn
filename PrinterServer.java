import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class PrinterServer {
	private ServerSocket serverSocket=null;
	private BufferedReader sin = null;
	private Socket cSocket;
	private boolean loop;
	public PrinterServer() {
		loop = false;
		try {
			serverSocket = new ServerSocket(9000);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void serverStart() {
		try {
			System.out.println("프린터기 대기");
			cSocket = serverSocket.accept();
			System.out.println("프린터기 연동 완료.");
			
			sin = new BufferedReader(
					new InputStreamReader(cSocket.getInputStream()));
			while(true) {
				String str = sin.readLine();
				System.out.println(str);
				System.out.println(cSocket.getInetAddress().getHostName()+" 님이 나가셨습니다.");
				break;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean getLoop() {
		return loop;
	}
	public static void main(String[] args) {
		PrinterServer server = new PrinterServer();
		while(true) {
			server.serverStart();
		}
	}
}
