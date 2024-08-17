package huichan.kr.main.query;

import java.io.File;

public class Use {
    public static void query(String[] query, Query q) {
        File[] fileList = new File("database").listFiles();

        try {
            for (int i = 0; i < fileList.length; i++) {
                if (query[1].equals(fileList[i].getName())) {
                    q.useDB = query[1];
                    System.out.println(q.useDB + " 데이터베이스를 열었습니다.");
                    break;
                }
            }
            if (!query[1].equals(q.useDB)) { System.out.println("데이터베이스를 찾을 수 없습니다."); }
        } catch (ArrayIndexOutOfBoundsException e) { System.out.println("명령어가 완성되지 않았습니다."); }
    }
}
