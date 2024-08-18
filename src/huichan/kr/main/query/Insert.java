package huichan.kr.main.query;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Insert {
    public static void query(String[] query, String useDB) {
        try {
            File fileTable = new File("database\\" + useDB + "\\" + query[2] + ".csv");
            if(!fileTable.exists()) {throw new NullPointerException();}

            Writer writer = new FileWriter(fileTable, true);
            StringBuilder attributeData = new StringBuilder();

            if (query[1].equalsIgnoreCase("INTO")
                    && query[3].equalsIgnoreCase("VALUES")) {

                for(int i = 4; i < query.length-1; i++) {
                    attributeData.append(query[i]).append("\t");}
                attributeData.append(query[query.length-1]).append("\n");

            } else {throw new Exception();}

            writer.write(attributeData.toString());
            writer.close();

            System.out.println("INSERT 구문이 정상적으로 수행되었습니다.");

        } catch (NullPointerException e){ System.out.println("테이블을 찾을 수 없습니다.");
        } catch (Exception e) {System.out.println("명령어를 잘못 입력하였습니다.");}
    }
}
