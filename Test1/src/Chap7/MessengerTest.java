package Chap7;

public class MessengerTest {
	public static void main(String[] args) {
		IPhoneMessenger iphone = new IPhoneMessenger();
		GalaxyMessenger galaxy = new GalaxyMessenger();

		System.out.println("메신저 최소 문자 크기" + Messenger.MIN_SIZE);
		System.out.println("메신저 최대 문자 크기" + Messenger.MAX_SIZE);

		Messenger.getConnection();
		iphone.setLogin(true);
		System.out.println(iphone.getMessage());	
		iphone.setMEssage("hello");
		iphone.clearMessage();
		iphone.draw_textBox();
		iphone.draw_submitButton();
		galaxy.setLogin(true);
		System.out.println(galaxy.getMessage());
		galaxy.setMEssage("hi");
		galaxy.changeKeyboard();
		galaxy.fileDownload();
		galaxy.fileUpload();
	}
}
