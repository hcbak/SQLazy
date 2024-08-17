package huichan.kr.main.query;

import java.io.File;

public class Create {
    public static void query(String[] query, String useDB) {
        try {
            File fileDir = new File("database\\" + query[2]);

            switch (query[1].toUpperCase()) {
                case "DATABASE":
                    System.out.println(fileDir.mkdirs() ? "데이터베이스가 생성되었습니다." : "이미 존재하는 데이터베이스입니다.");
                    break;
                default:
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) { System.out.println("명령어가 완성되지 않았습니다."); }


    }
}
