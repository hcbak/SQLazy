package huichan.kr.main.query;

import java.io.File;

public class Show {
    public static void query(String type) {
        switch (type.toUpperCase()) {
            case "DATABASES":
                File[] fileList = new File("database").listFiles();
                if (fileList == null)
                    System.out.println("데이터베이스가 없습니다.");
                else
                    for (File value : fileList) { System.out.println(value.getName()); }
                break;
        
            default:
                break;
        }
    }
}
