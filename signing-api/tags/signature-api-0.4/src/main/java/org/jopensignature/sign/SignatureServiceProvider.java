package org.jopensignature.sign;

/**
 * This is the main signing service provider interface which provides access to third party signing
 * services.
 * <p>
 * This interface has to be implemented by the specific signature solution vendors to provide access
 * to their specific customized signing service.
 * <p>
 * The enclosing application expects the signing realization as a JAR archive with a signature
 * service provider, which fulfills this interface and is declared as signature service provider.
 * <p>
 * To declare a signature service provider, a <code>services</code> subdirectory have to be placed
 * within the <code>META-INF</code> directory that is present in every JAR file. This directory
 * should contain a file for signature service providers that has one or more implementation classes
 * present in the JAR file. This file should contain an entry per line for each service provider
 * that has an implementation in the JAR.
 * <p>
 * For example, if the JAR file contained a class named
 * <code>com.mycompany.mysigner.MySignatureServiceProviderImpl</code> which implements this
 * interface, the JAR file must contain a file named
 * <p>
 * 
 * <pre>
 * org.jopensignature.sign.SignatureServiceProvider
 * </pre>
 * 
 * containing the line
 * 
 * <pre>
 * com.mycompany.mysigner.MySignatureServiceProviderImpl
 * </pre>
 * 
 * and have to be located in the JAR file in the following directory
 * 
 * <pre>
 * META-INF/services/
 * </pre>
 * <p>
 * For more details on declaring service providers, and the JAR format in general, see the <a
 * href="http://java.sun.com/products/jdk/1.3/docs/guide/jar/jar.html"> JAR File Specification</a>.
 * 
 * @author <a href="mailto:c.koehler@levigo.de">Carolin Köhler</a>
 * @author <a href="mailto:f.fernandes@levigo.de">Francois Fernandes</a>
 */
public interface SignatureServiceProvider {

  /**
   * Return the provided signer service for a specific {@link SigningDevice}.
   * 
   * @return a {@link Signer} provided by this implementation
   * 
   * @param device the {@link SigningDevice} on which the {@link Signer} shall operate.
   * @throws IllegalArgumentException if device is <code>null</code> or the {@link SigningDevice} is
   *           unsupported.
   */
  public Signer createSigner(SigningDevice device);

  /**
   * Return the provided signer service. This method will return a "default" {@link Signer} which is
   * either liked to a {@link SigningDevice} which the {@link SignatureServiceProvider}
   * implementation has chosen.
   * 
   * @return a {@link Signer} provided by this implementation
   */
  public Signer createSigner();

  /**
   * All to this {@link SignatureServiceProvider} accessible {@link SigningDevice signing devices}.
   * 
   * @return all to this {@link SignatureServiceProvider} accessible {@link SigningDevice signing
   *         devices}.
   */
  public SigningDevice[] getSigningDevices();

  /**
   * Find a specific a {@link SigningDevice} using a {@link SigningDevice#getIdentifier()
   * identifier}. If no such {@link SigningDevice} could be found <code>null</code> will be
   * returned.
   * 
   * @param identifier the {@link SigningDevice#getIdentifier() identifier} of a specific
   *          {@link SigningDevice}
   * @return the {@link SigningDevice} found for the given {@link SigningDevice#getIdentifier()
   *         identifier} or <code>null</code> otherwise.
   */
  public SigningDevice findSigningDevice(String identifier);

  // XXX: the verification logic will be implemented in some future release.
  // Removing the logic temporarily
  // /**
  // * Return the provided verifier service.
  // *
  // * @return a {@link Verifier} provided by this implementation
  // */
  // public Verifier createVerifier();

}