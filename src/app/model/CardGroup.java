/*
Copyright 2016 Jacquot Alexandre, Jolivet Arthur
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package app.model;


import exceptions.CardGroupNumberException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * The {@code CardGroup} class consists in a group of cards.
 * It extends {@code ArrayList} class of jav.util package
 * @author Arthur
 * @author Alexandre
 * @version v1.0.2
 * @since v0.1
 *
 * @see ArrayList
 */
public class CardGroup extends ArrayList<Card> {
    private final int NB_MAX_CARDS;
    private int id;
    private static int nbInstances = 0;

    /**
     * Constructs a CardGroup
     *
     * @param NB_MAX_CARDS the max number of card a subclass of CardGroup can have
     * @throws CardGroupNumberException if user tries to create too much cardGroup
     * @since v0.1
     */
    public CardGroup(int NB_MAX_CARDS) throws CardGroupNumberException {
        super();
        id = nbInstances++;
        this.NB_MAX_CARDS = NB_MAX_CARDS;
    }

    /**
     * Add a card
     *
     * @param card the card which is added to card list
     * @since v0.1
     */
    @Override
    public boolean add(Card card) {
        if (size() >= NB_MAX_CARDS) {
            return false;
        } else {
            super.add(card);
            return true;
        }
    }

    /**
     * Add all cards
     *
     * @param cardList the cards which are added to card list
     * @since v0.7
     */
    @Override
    public boolean addAll(Collection<? extends Card> cardList) {
        boolean wasAdded = true;
        for (Card card : cardList) {
            if (!add(card)) {
                wasAdded = false;
                break;
            }
        }
        return wasAdded;
    }


    /**
     * Display all the cards of a card group
     *
     * @return a string containing all CardGroup's cards name
     * @since v0.6
     */
    public String cardListToString() {
        StringBuilder result = new StringBuilder();
        for (Card c : this) {
            if (c.isShown())
                result.append(c.getName()).append("; ");
            else
                result.append("?? ; ");
        }
        return result.toString();
    }

    /**
     * Find a card by its name
     *
     * @return a boolean indicating if card has been found
     * @since v0.6
     * @param nameToFind the name searched
     */
    public boolean findInCardsList(String nameToFind) {
        for (Card c : this)
            if (Objects.equals(c.getName(), nameToFind))
                return true;
        return false;
    }

    /**
     * Find a card by its name
     *
     * @return the card if found
     * @since v0.6
     * @param nameToFind the name searched
     */
    public Card getInCardsList(String nameToFind) {
        for (Card c : this)
            if (Objects.equals(c.getName(), nameToFind))
                return c;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CardGroup cards = (CardGroup) o;

        return id == cards.id;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        return result;
    }

    //GETTERS - no documentation needed

    public int getNbMaxCards() {
        return NB_MAX_CARDS;
    }

}