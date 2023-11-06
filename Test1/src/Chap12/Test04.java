package Chap12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test04 {

	public static void main(String[] args) {
		byte[] arr = null;
		// TODO Auto-generated method stub
		//in은 a.txt파일의 데이터를 저장하는 버퍼 입력스트림
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("a.txt"));
				//out은 출력스트림 - 출력된 값이 저장되는 매개변수 없으므로 출력스트림(out) 자체에 저장
				ByteArrayOutputStream out = new ByteArrayOutputStream();){
			byte[] buf = new byte[1024];
			int len = 0;
			//in의 데이터를 buf에 저장, len은 저장된 데이터의 길이 - 읽을 데이터가 없으면 -1
			while((len=in.read(buf))!=-1) {
				//buf에 있는 데이터를 0번지부터 len만큼 출력스트림(out)에 출력
				out.write(buf,0,len);
			}
			//출력스트림의 데이터를 byte 배열로 반환
			arr = out.toByteArray();
			//byte 배열을 문자열로 반환
			String s = new String(arr);
			//문자열 출력
			System.out.println(s);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try(BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("a2.txt"))){
			//버퍼 출력스트림 사용 - 문자열 전체를 한 번에 입력
			bo.write(arr);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
