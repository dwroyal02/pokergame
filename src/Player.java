/*
속성
이름
카드
돈

메서드

*/




class Player {
    static final int MAX_CARD_AMOUNT = 5;
    Card[] cards = new Card[MAX_CARD_AMOUNT];
    int[] typeResult =  new int[Card.MAX_CARD_TYPE];
    int[] numResult = new int[Card.MAX_CARD_NUMBER];
    PokerHand DECK;
    int rank;
    int No;
    String name;



     void getTypeResult() {
        int[] typeResult = new int[Card.MAX_CARD_TYPE];
        for(int i = 0; i< cards.length; i++){
            typeResult[cards[i].TYPE.ordinal()]++;
        }
        this.typeResult = typeResult;
    }

     void getNumResult() {
        int[] numResult = new int[Card.MAX_CARD_NUMBER];
        for(int i = 0; i< cards.length; i++){
            numResult[cards[i].NUM-1]++;
        }
        this.numResult = numResult;
    }



}
