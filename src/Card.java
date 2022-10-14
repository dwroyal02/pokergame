/*
속성
카드 번호
카드 타입

기능
*/

class Card {
    final int NUM;
    final CardType TYPE;
    static final int MAX_CARD_NUMBER = 13;
    static final int MAX_CARD_TYPE = 4;



    public Card(int num, CardType type) {
        this.NUM = num;
        this.TYPE = type;
    }

    @Override
    public String toString() {
        if(this.NUM == 1)
            return "(" +
                    "A" +
                    "," + TYPE + ")";
        if(this.NUM == 11)
            return "(" +
                    "J" +
                    "," + TYPE + ")";
        if(this.NUM == 12)
            return "(" +
                    "Q" +
                    "," + TYPE + ")";
        if(this.NUM == 13)
            return "(" +
                    "K" +
                    "," + TYPE + ")";
        return ("< " + TYPE + "," + NUM + " >").replace("[","").replace("]","");
    }
}
