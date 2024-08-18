package huichan.kr.main.query;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Select {
    public static void query (String[] query, String useDB) {
        try {
            String[] queryStructure = {"SELECT", "FROM"};
            ArrayList<ArrayList<String>> querySplit = new ArrayList<>();
            ArrayList<String> tmp = new ArrayList<>();
            byte point = 0;

            // 쿼리를 구조에 맞게 자른다.
            for (String i : query) {
                if (queryStructure.length == point){
                    tmp.add(i);
                    querySplit.add(tmp);
                    continue;
                } else if (i.toUpperCase().equals(queryStructure[point])) {
                    if (tmp.size() > 0) {
                        querySplit.add(tmp);
                        tmp = new ArrayList<>();
                    }
                    point++;
                    continue;
                }
                tmp.add(i);
            }

            ArrayList<String[]> result = new ArrayList<>();
            int selectCount = querySplit.get(0).size();
            String[] columnTitle = new String[selectCount];
            String[] insertLine = new String[selectCount];
            int[] resultIndex = new int[selectCount];
            int[] resultSize = new int[selectCount];
            
            // 선언한 배열 초기화
            for (int i = 0; i < selectCount; i++) {
                columnTitle[i] = querySplit.get(0).get(i);
                resultSize[i] = columnTitle[i].length() + 2;
                resultIndex[i] = -1;
            }
            result.add(columnTitle);
            
            // 테이블을 열어서 SELECT 뒤에 온 컬럼명 기준으로 재구성한다.
            try (BufferedReader br = new BufferedReader(new FileReader("database\\" + useDB + "\\" + querySplit.get(1).get(0) + ".csv"))) {
                String[] column = br.readLine().split("\t");

                // 쿼리에서 가져온 컬럼명을 테이블의 컬럼명과 비교하여 테이블의 컬럼명 index를 저장한다.
                for (int i = 0; i < selectCount; i++) {
                    for (int j = 0; j < column.length; j++) {
                        if (querySplit.get(0).get(i).equals(column[j])) {
                            resultIndex[i] = j;
                        }
                    }
                }
                
                // 테이블의 데이터를 한 줄 씩 가져와서 요청한 구조에 맞게 재구성하여 결과물을 만든다.
                // 출력할 때 문자열의 길이에 맞게 공간을 잡아야 하므로 컬럼에서 가장 긴 길이를 저장한다.
                String columnLine;
                isNull:
                while ((columnLine = br.readLine()) != null) {
                    column = columnLine.split("\t");
                    for (int i = 0; i < resultIndex.length; i++) {
                        if (resultIndex[i] == -1) {
                            result = null;
                            break isNull;
                        }
                        for (int j = 0; j < column.length; j++) {
                            if (j == resultIndex[i]) {
                                insertLine[i] = column[j];
                                if (column[j].length() + 2 > resultSize[i]) { resultSize[i] = column[j].length() + 2; }
                            }
                        }
                    }
                    result.add(insertLine.clone()); 
                }

                printTable(result, resultSize);
            } catch (IOException e) {
                System.out.println("테이블을 찾을 수 없습니다.");
            } catch (NullPointerException e) {
                System.out.println("컬럼명이 일치하지 않습니다.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("명령어가 완성되지 않았습니다.");
        }
    }

    /**
     * data와 size를 받아 문자열 길이에 맞게 StringBuilder를 사용하여 가공한 후 출력한다.
     * @param data
     * - String[]의 length가 같아야 한다.
     * @param size
     * - data의 String[]과 length가 같아야 한다.
     */ 
    public static void printTable (ArrayList<String[]> data, int[] size) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.size(); i++) {
            if (i == 1) { sb.append("-".repeat(Arrays.stream(size).sum()) + "\n"); }
            for (int j = 0; j < size.length; j++) {
                sb.append(String.format("%-" + size[j] + "s", data.get(i)[j] + " "));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
