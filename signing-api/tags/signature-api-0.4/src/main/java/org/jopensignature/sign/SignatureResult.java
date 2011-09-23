package org.jopensignature.sign;

/**
 * The final signature result object defining the outcome of the signing
 * process.
 * 
 * @author <a href="mailto:c.koehler@levigo.de">Carolin Köhler</a>
 * @author <a href="mailto:f.fernandes@levigo.de">Francois Fernandes</a>
 */
public class SignatureResult {
	
	public static enum State {
		DONE, FAILED, CANCEL
	}

	private final SignatureData data;
	private final State state;

	// FIXME: Do we need a state message? Esp. for the FAILED case?
	// private String stateDisplayMessage;

	/**
	 * Construct a final signature result object.
	 * 
	 * @param state
	 *            One of {@link State}
	 * @param result
	 *            a <b>required</b> {@link SignatureData} object in the case of
	 *            {@link State#DONE}, optional (null) otherwise.
	 */
	public SignatureResult(State state, SignatureData result) {
		super();
		if (state == null)
			throw new IllegalArgumentException("state may not be null");

		if (state == State.DONE && result == null)
			throw new IllegalArgumentException(
					"data may not be null with state: " + State.DONE.name());

		this.data = result;
		this.state = state;
	}

	/**
	 * Returns the associated {@link SignatureData data} object for the
	 * completed signing process. The value will be non null if the
	 * {@link #getState() state} is {@link State#DONE}. For the states
	 * {@link State#FAILED} and {@link State#CANCEL} implementations may choose
	 * to provide a result object but are not enforced to.
	 * 
	 * @return the {@link SignatureData result} for the signing process.
	 */
	public SignatureData getData() {
		return data;
	}

	/**
	 * Returns the final state of the signature process. The resulting value
	 * defines the outcome of the signing process. For details about the
	 * specific states see the documentation of {@link State}.
	 * 
	 * @return the final state of the signature process.
	 */
	public State getState() {
		return state;
	}

}