// Properties

// Methods
// 카드 섞기, 나눠주기, 결과 평가


class Dealer {
    private int indexToDeal;

     void deal(Player player) {
        for (int i = 0; i < player.MAX_CARD_AMOUNT; i++) {
            player.cards[i] = GameRoom.GAME_CARDS[indexToDeal++];

        }
    }

     void shuffle(Card[] cards) {
        int cycle = 0;
        while (cycle < 1000) {
            for (int i = 0; i < GameRoom.GAME_CARD_AMOUNT; i++) {
                int randomNum = (int) (Math.random() * GameRoom.GAME_CARD_AMOUNT);
                Card tmpCard = cards[randomNum];
                cards[randomNum] = cards[i];
                cards[i] = tmpCard;
            }
            cycle++;
        }
    }

    void resetGame() {
         indexToDeal =0;
         shuffle(GameRoom.GAME_CARDS);
    }


}
