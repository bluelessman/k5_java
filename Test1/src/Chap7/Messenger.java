package Chap7;

public interface Messenger {
	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 104857600;
	
	public abstract String getMessage();
	public abstract void setMEssage(String msg);
	public default void setLogin(boolean login) {
		log();
		if(login) {
			getConnection();
			System.out.println("로그인");
		}else {
			System.out.println("로그아웃");
		}
	}
	public static void getConnection() {
		System.out.println("network 연결");
	}
	private void log() {
		System.out.println("start job");
	}
}
