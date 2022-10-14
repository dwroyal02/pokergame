import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GameRoomTest {
    Card[] cards = {
            new Card(1, CardType.HEART),
            new Card(2,CardType.HEART),
            new Card(3,CardType.HEART),
            new Card(4,CardType.HEART),
            new Card(5,CardType.HEART),
    };
    int[] numResult = new int[14]; // 인덱스 0~12
    int[] typeResult = new int[4];

    @BeforeEach
    void beforeEach() {
//
//        for (int i = 0; i < cards.length; i++) {
//            numResult[cards[i].NUM()]++;
//            typeResult[cards[i].TYPE().ordinal()]++;
//        }
        System.out.println(Arrays.toString(numResult));
        System.out.println(Arrays.toString(typeResult));
    }

    @Test
    void straightTest(){
//        String result = PokerGame.checkStraight(numResult);
//        assertEquals("Straight", result);
    }

    @Test
    void flushTest(){
        int[] arr = new int[4];
        int num = 5;
        for(int i=0; i<1000; i++ ) {
            int random = (int)(Math.random()*4);
            arr[random] = 5;
//            assertEquals("Flush", PokerGame.checkFlush(arr));
        }
    }
}