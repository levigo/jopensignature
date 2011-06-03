package org.jopensignature.sign;

/**
 */
public abstract class ReplyableMessage extends BaseMessage {

  private final ReplyReceiver replyReceiver;

  /**
   * @param replyReceiver the {@link ReplyReceiver} that shall receive messages from the
   *          {@link SigningDevice}
   */
  public ReplyableMessage(ReplyReceiver replyReceiver) {
    super();
    if (replyReceiver == null)
      throw new IllegalArgumentException("replyReceiver must not be null");
    this.replyReceiver = replyReceiver;
  }

  public ReplyReceiver getReplyReceiver() {
    return replyReceiver;
  }

}