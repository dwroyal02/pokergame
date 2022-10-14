import java.util.Arrays;

/*
1. 카드가 셋팅된다.
2. 플레이어가 들어온다, 딜러가 들어온다
3. 딜러가 카드를 섞는다
4. 플레이어가 카드를 받는다.
5. 결과를 출력한다.
* */
public class GameRoom {
    static final int GAME_CARD_AMOUNT = 52;

    static final Card[] GAME_CARDS = new Card[GAME_CARD_AMOUNT];
    Player player1 = new Player();
    Player player2 = new Player();
    Dealer dealer = new Dealer();

    public void run() {
        System.out.println("포커 게임을 시작합니다. 게임을 시작하려면 1번을 누르세요");
        System.out.println("종료를 하시려면 0번을 눌러주세요");
        player1.cards = new Card[]{
                new Card(8, CardType.HEART),
                new Card(8, CardType.HEART),
                new Card(8,CardType.DIAMOND),
                new Card(12, CardType.DIAMOND),
                new Card(11, CardType.HEART)
        };
        player2.cards = new Card[]{ new Card(8, CardType.HEART),
                new Card(8, CardType.HEART),
                new Card(8,CardType.DIAMOND),
                new Card(12, CardType.DIAMOND),
                new Card(11, CardType.HEART)};
        player1.getNumResult();
        player1.getTypeResult();
        System.out.println("player.numResult = " + Arrays.toString(player1.numResult));
        System.out.println("player.typeResult = " + Arrays.toString(player1.typeResult));
        player1.DECK = checkDeck(player1);
        System.out.println(player1.DECK);


    }
    private PokerHand checkDeck(Player player){
            if(hasA(player)){
                if(isMountain(player) && isFlush(player))
                    return PokerHand.ROYAL_STRAIGHT_FLUSH;
                else if(isStraight(player)&& isFlush(player))
                    return PokerHand.BACK_STRAIGHT_FLUSH;
                else if(isFlush(player)==false && isMountain(player) == true)
                    return PokerHand.MOUNTAIN;
                else if(isFlush(player) == false && isStraight(player) == true)
                    return PokerHand.BACK_STRAIGHT;

            }
            if(isStraight(player) && isFlush(player))
                return PokerHand.STRAIGHT_FLUSH;
            else if(isTriple(player) && isTwoPair(player))
                return PokerHand.FULL_HOUSE;
            else if(isStraight(player)== false && isFlush(player)==true)
                return PokerHand.FLUSH;
            else if(isStraight(player)==true && isFlush(player)==false)
                return PokerHand.STRAIGHT;
            else if(isPoker(player))
                return PokerHand.POKER;
            else if(isTriple(player))
                return PokerHand.TRIPLE;
            else if(isTwoPair(player))
                return PokerHand.TWO_PAIR;
            else if(isOnePair(player))
                return PokerHand.ONE_PAIR;

            return PokerHand.NO_PAIR;


        }



    GameRoom() {
        initCards();
    }

    private void initCards(){
        int cardIndex = 0;
        while(cardIndex<GAME_CARD_AMOUNT){
            for(CardType type : CardType.values()) {
                for (int i = 1; i <= Card.MAX_CARD_NUMBER; i++) {
                    GAME_CARDS[cardIndex++] = new Card(i, type);
                }
            }
        }
    }

    private boolean isMountain(Player player){
        if(player.numResult[0] != 1)
            return false;
        for(int i = 9; i < player.numResult.length; i++){
            if(player.numResult[i] != 1)
                return false;
        }
            return true;
    }

    private boolean hasA(Player player) {
        return player.numResult[0] == 1;
    }

    private boolean isFlush(Player player) {
        for(int type : player.typeResult){
            if(type==5){
                return true;
            }
        }
        return false;
    }



    private boolean isStraight(Player player) {
        int oneCount = 0;
        for(int j = 0; j< player.numResult.length; j++) {
            if(player.numResult[j]==1){
                for (int i = j; i < player.numResult.length; i++) {
                    if (player.numResult[i] == 0)
                        return false;
                    oneCount++;
                    if (oneCount == 5)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean isPoker(Player player) {
        for(int i : player.numResult)
            if(i ==4)
                return true;
        return false;
    }

    private boolean isOnePair(Player player) {
        for(int i : player.numResult)
            if(i == 2)
                return true;
        return false;
    }

    private boolean isTwoPair(Player player) {
        int pairCount = 0;
        for(int i : player.numResult)
            if(i == 2)
                pairCount++;
        if(pairCount ==1)
            return true;
        return false;
    }

    private boolean isTriple(Player player) {
        for(int i : player.numResult)
            if(i == 3)
                return true;
        return false;
    }

}




