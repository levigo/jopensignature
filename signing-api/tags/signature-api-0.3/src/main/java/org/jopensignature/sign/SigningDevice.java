package org.jopensignature.sign;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Representation of a typically physical signing device.
 */
public interface SigningDevice {

  public static class UnsupportedMessageException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    private final BaseMessage message;

    public UnsupportedMessageException(BaseMessage message) {
      this(message, null);
    }

    public UnsupportedMessageException(BaseMessage message, String msg) {
      super(msg);
      this.message = message;
    }

    @Override
    public String getMessage() {
      String msg = super.getMessage();
      StringBuilder b = new StringBuilder();
      b.append(message.getClass().getName());
      if (msg != null) {
        b.append(":");
        b.append(msg);
      }
      return b.toString();
    }

  }

  /**
   * Returns the device capabilities.
   * 
   * @return
   */
  public SigningDeviceCapabilities getCapabilities();

  /**
   * 
   * @param locale the locale in which the {@link SigningDeviceInfo} shall be returned. If
   *          <code>locale</code> is <code>null</code>, {@link Locale#getDefault()} shall be used.
   *          If there is no matching translation is available, the implementation shall use the
   *          closest substitute. How a substitute is selected is up to the implementation. We
   *          encourage to follow the guidelines of {@link ResourceBundle}.
   */
  public SigningDeviceInfo getInfo(java.util.Locale locale);

  /**
   * Send the given {@link BaseMessage} instance to the device. Some {@link BaseMessage messages}
   * might require replies. Receiving replies may be achieved by sending messages extending
   * {@link ReplyableMessage}.
   * 
   * @param message the {@link BaseMessage message} to be sent
   * @throws IllegalArgumentException if <code>message</code> is <code>null</code>.
   * @throws UnsupportedMessageException if the {@link BaseMessage message} is unsupported. Whether
   *           a {@link BaseMessage message} is supported or not, may be checked using
   *            {@link #getCapabilities() getCapabilities()}.{@link SigningDeviceCapabilities#isMessageSupported(Class) isMessageSupported(Class)} 
   */
  public void send(BaseMessage message) throws UnsupportedMessageException;

}