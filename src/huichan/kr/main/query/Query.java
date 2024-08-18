package huichan.kr.main.query;

public class Query {
    private String[] query;
    public String useDB;

    public Query() {
        System.out.println("\n\t혁명적으로 게으른 DBMS, SQLazy가 인사올립니다.\n\t명령을 내려주십시오.\n");
    }

    public void insertQuery (String query) {
        this.query = query.split(" ");
    }
    
    public String getHead() {
        return query[0];
    }

    public void send() {
        long before = System.currentTimeMillis();
        
        switch (this.query[0].toUpperCase()) {
            case "SHOW": Show.query(this.query[1]); break;
            case "CREATE": Create.query(this.query, this.useDB); break;
            case "USE": Use.query(this.query, this); break;
            case "SELECT": Select.query(this.query, this.useDB); break;
            default:
                System.out.println("SQLazy에서 지원하지 않는 쿼리입니다.");
                break;
        }

        double after = (System.currentTimeMillis() - before) / 1000;
        System.out.printf("처리 시간: %.2fs\n\n", after);
    }
}
