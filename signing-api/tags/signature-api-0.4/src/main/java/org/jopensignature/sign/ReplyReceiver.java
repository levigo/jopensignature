package org.jopensignature.sign;

/**
 * Callback for {@link ReplyableMessage}s.
 */
public interface ReplyReceiver {

  /**
   * 
   * @param sourceMessage the {@link ReplyableMessage message} that originally initiated the message
   *          exchange.
   * @param reply the reply of the {@link SigningDevice}
   */
  public void receive(ReplyableMessage sourceMessage, BaseMessage reply);

}