package org.jopensignature.sign;

import javax.imageio.stream.ImageInputStream;

/**
 * This is main signer interface which provides the functionalities for signing
 * processes. It represents a bridge between signing service consumer
 * applications and third party signing solutions.
 * 
 * @author <a href="mailto:c.koehler@levigo.de">Carolin Köhler</a>
 * @author <a href="mailto:f.fernandes@levigo.de">Francois Fernandes</a>
 */
public interface Signer {

	/**
	 * This method should be called to finish the work with this signer
	 * instance. Within the close method the {@link Signer} instance frees and
	 * releases all its resources.
	 * <p>
	 * After a call of this method, it is recommended to continue signing
	 * processes with a new signer instance retrieved by a call of
	 * {@link SignatureServiceProvider#createSigner()}.
	 * <p>
	 * The reusability of the {@link Signer} instance after a call to this
	 * method is not a warranted characteristic.
	 */
	public void close();

	/**
	 * Returns an array of {@link Signature} found in the document given by the
	 * parameterized document stream.
	 * 
	 * @param documentStream The document, provided as input stream, to be
	 *          analyzed for embedded signatures. The document stream have to be
	 *          not <code>null</code> and readable.
	 * @return an array of found {@link Signature}s. If the document contains no
	 *         {@link Signature}s, the returned array is of length 0. Its
	 *         recommend that the returned array is not <code>null</code>.
	 * 
	 * @throws IllegalArgumentException if the document stream is
	 *           <code>null</code> or document format is unsupported
	 */
	public Signature[] getSignatures(ImageInputStream documentStream);

	/**
	 * Returns a {@link SigningDevice} information provided by this
	 * {@link Signer}. The {@link SigningDevice} allows to retrieve informations
	 * about the device the signer use to retrieve signatures.
	 * 
	 * @return a {@link SigningDevice} instance to provide informations about
	 *         the device used to retrieve the signatures.
	 */
	public SigningDevice getSigningDevice();

	/**
	 * This method will be called to initiate a signature retrieval.
	 * <p>
	 * The given {@link SignatureContext} parameter accompanies the signature
	 * request, providing necessary informations for the signing process, like
	 * the document to sign on, signature properties and so on. Therefore the
	 * {@link SignatureContext} have to be present, not <code>null</code> and
	 * should provide the necessary informations for a signature retrieval.
	 * <p>
	 * The {@link SignatureListener} is a callback mechanism to notify the
	 * calling application about signing progress and its result. For detailed
	 * informations see the javadoc of the {@link SignatureListener} interface.
	 * <p>
	 * <b>NOTE:</b><br/>
	 * Implementations of this method will be blocking until the signing 
	 * processes has been finished.  
	 * 
	 * @param context
	 *            the {@link SignatureContext} providing necessary informations
	 *            for the signing process
	 * @param listener
	 *            a {@link SignatureListener} to be notified about the signing
	 *            process and to get informations about the signing result.
	 * @throws IllegalArgumentException
	 *             if the {@link SignatureContext} parameter is
	 *             <code>null</code> or does not provide the informations need
	 *             to start a signing request.
	 */
	public void startSigning(SignatureContext context,
			SignatureListener listener);

	/**
	 * Returns a indicator whether this signer supports given
	 * {@link MetaInfoField} class type.
	 * <p>
	 * <b>NOTE:</b><br/>
	 * Implementations of this method will assure the following conditions:
	 * <ul>
	 * <li>the execution of this method will be as fast as possible.</li>
	 * <li>the returning value does not change if this method will be called twice
	 * or more times</li>
	 * </ul>
	 * 
	 * @param fieldType the {@link MetaInfoField} class type the support is asked
	 *          for
	 * @return <code>true</code> if this {@link MetaInfoField} class type is
	 *         supported, otherwise <code>false</code> will be returned.
	 * @throws IllegalArgumentException if the parameter fieldType is <code>null</code>        
	 */
	public boolean isMetaInfoFieldSupported(Class<? extends MetaInfoField> fieldType);
	
	/**
	 * Returns a indicator whether this signer supports signing service for the given
	 * document stream.
	 * <p>
	 * <b>NOTE:</b><br/>
	 * Implementations of this method will assure the following conditions:
	 * <ul>
	 * <li>the execution of this method will be as fast as possible.</li>
	 * <li>will <b>not</b> close the document stream.</li>
	 * <li>the returning value does not change if this method will be called 
	 * twice or more times on the same document stream or content.</li>
	 * </ul> 
	 * 
	 * @param documentStream the document the signing support is asked for
	 * @return <code>true</code> if this signer supports signing service for this document type 
	 * otherwise <code>false</code> will be returned.
	 * @throws IllegalArgumentException
	 *             if the document stream is <code>null</code> or closed
	 */
	public boolean isSigningSupportedFor(ImageInputStream documentStream);
}