package huichan.kr.main.query;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Create {
    public static void query(String[] query, String useDB) {
        try {
            File fileDir = new File("database\\" + query[2]);
            File fileTable = new File("database\\" + useDB + "\\" + query[2] + ".csv");
            StringBuilder tableColumn = new StringBuilder();

            switch (query[1].toUpperCase()) {
                case "DATABASE":
                    System.out.println(fileDir.mkdirs() ? "데이터베이스가 생성되었습니다." : "이미 존재하는 데이터베이스입니다.");
                    break;
                case "TABLE":
                    if(query.length < 4) { System.out.println("컬럼명을 입력해야 테이블이 생성됩니다."); break; }

                    if(fileTable.createNewFile()) {System.out.println("테이블이 생성되었습니다.");}
                    else {System.out.println("이미 존재하는 테이블입니다."); break;}

                    for(int i = 3; i < query.length-1; i++) {
                        tableColumn.append(query[i]).append("\t");}
                    tableColumn.append(query[query.length-1]).append("\n\r");

                    Writer writer = new FileWriter("database\\" + useDB + "\\" + query[2] + ".csv");
                    writer.write(tableColumn.toString());
                    writer.close();
                    break;
                default:
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) { System.out.println("명령어가 완성되지 않았습니다.");
        } catch (IOException e) {System.out.println("데이터베이스가 선택되지 않았습니다.");}
    }
}
