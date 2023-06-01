package handle;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileHandler {
	private static Logger log = LoggerFactory.getLogger(FileHandler.class);
	
	//파일이름과 정보를 받아서 파일을 삭제하는 메서드
	// 리턴타입:int = 삭제되었는지 확인하는 isOk 
	public int deleteFile(String imageFileName, String savePath) {
		
		boolean isDel = false;
		log.info(">>>deleteFile method 접근");
		log.info(">>>imageFileName? : " + imageFileName);
		//파일삭제시 리턴값이 boolean으로 와여
		
		File fileDir = new File(savePath); //경로를 담은 파일
		File removeFile = new File(fileDir + File.separator + imageFileName); 
		File removeThumbFile = new File(fileDir + File.separator + "th_" + imageFileName);
		
		//파일이 있는지(존재하는지) 확인 -> 있으면 삭제
		if(removeFile.exists() || removeThumbFile.exists()) { //있다면
			isDel = removeFile.delete(); //리턴형태 boolean으로 나옴
			log.info(">>> removeFile 값이 삭제되었는가? " + (isDel ? "OK" : "Fail"));
			
			if(isDel) { //removFile이 없어졌다면 removeThumbFile도 삭제
				isDel = removeThumbFile.delete();
				log.info(">>> removeThumbFile 값이 삭제되었는가? " + (isDel ? "OK" : "Fail"));
			}
		}
		
		log.info(">>>FileHandler remove OK! ");
		return isDel? 1 : 0; //true면 1 아니면 0을 리턴
	}

}
