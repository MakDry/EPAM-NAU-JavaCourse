package ua.advanced.practice6.strategy.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> stack = dealer(deck, players, 2);

            List<Card> communityStack = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                communityStack.add(deck.dealCard());
            }
            stack.put("Community", communityStack);
            stack.put("Remaining", deck.restCards());

            return stack;
        };
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> stack = dealer(deck, players, 5);
            stack.put("Remaining", deck.restCards());
            return stack;
        };
    }

        public static CardDealingStrategy bridgeCardDealingStrategy() {
            return (deck, players) -> {
                return dealer(deck, players, 13);
            };
        }

        public static CardDealingStrategy foolCardDealingStrategy() {
            return (deck, players) -> {
                Map<String, List<Card>> stack = dealer(deck, players, 6);

                List<Card> trumpCard = new ArrayList<>();
                trumpCard.add(deck.dealCard());
                stack.put("Trump card", trumpCard);

                stack.put("Remaining", deck.restCards());
                return stack;
            };
        }

    private static Map<String, List<Card>> dealer(Deck deck, int players, int requiredCards) {
        Map<String, List<Card>> stack = new TreeMap<>();
        for (int i = 0; i < players; i++) {
            List<Card> cards = new ArrayList<>();
            stack.put("Player " + (i + 1), cards);
        }
        for (int i = 0; i < requiredCards; i++) {
            for (int j = 0; j < players; j++) {
                stack.get("Player " + (j + 1)).add(deck.dealCard());
            }
        }
        return stack;
    }
}
