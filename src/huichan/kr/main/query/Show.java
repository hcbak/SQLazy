package huichan.kr.main.query;

import java.io.File;

public class Show {
    public static void query(String type, String useDB) {
        switch (type.toUpperCase()) {
            case "DATABASES":
                File[] databaseList = new File("database").listFiles();
                if (databaseList == null)
                    System.out.println("데이터베이스가 없습니다.");
                else
                    for (File value : databaseList) { System.out.println(value.getName()); }
                break;
            case "TABLES":
                File[] tableList = new File("database\\" + useDB).listFiles();
                if (tableList == null)
                    System.out.println("테이블이 없습니다.");
                else
                    for (File value : tableList) { System.out.println(value.getName().substring(0, value.getName().lastIndexOf('.'))); }
                break;
            default:
                System.out.println("지원하지 않는 SHOW 쿼리입니다.");
                break;
        }
    }
}
