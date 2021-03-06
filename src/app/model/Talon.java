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

/**
 * The {@code Talon} class extends {@code CardGroup},
 * it consists in a group of cards representing the chien
 * and afterward the taker's ecart
 * @author Arthur
 * @version v1.0.0
 * @since v0.1
 *
 * @see CardGroup
 * @see Card
 */
public class Talon extends CardGroup{
    private static boolean exist = false;

    /**
     * Constructs a talon
     * @since v0.1
     * @throws CardGroupNumberException if user tries to create more than one talon
     */
    public Talon() throws CardGroupNumberException {
        super(6); //Max number of cards for this group
        if (exist)
            throw new CardGroupNumberException("Only one Talon is possible.");
        else {
            exist = true;
        }
    }

    /**
     * Reset static field
     * @since v0.5
     */
    public static void resetClass() {
        exist = false;
    }

    /**
     * Return if talon exists
     * @since v0.5
     *
     * @return a boolean indicating if Talon has already been instantiated
     */
    public static boolean exists() {
        return exist;
    }
}
