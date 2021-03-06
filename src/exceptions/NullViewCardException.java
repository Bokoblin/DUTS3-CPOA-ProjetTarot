package exceptions;

import app.model.CardUpdate;

/**
 * Exception class on card update
 *
 * @author Alexandre
 * @version v1.0.0
 * @since v0.5
 */
public class NullViewCardException extends Exception
{
    public NullViewCardException(CardUpdate cardUpdate, boolean existExcepted)
    {
        super(createMessage(cardUpdate, existExcepted));
    }

    private static String createMessage(CardUpdate cardUpdate, boolean existExcepted)
    {
        String message;
        if (cardUpdate.getCard() != null) {
            message = "Error when updating the card " + cardUpdate.getCard().getName() + "(" + cardUpdate.getType().toString() + "), the related View Card was excepted to ";
        } else  {
            message = "Error when updating a card (" + cardUpdate.getType().toString() + "), the related View Card was excepted to ";
        }
        if (existExcepted)
        {
            message += "exist.";
        } else {
            message += "not exist.";
        }
        return message;
    }
}
