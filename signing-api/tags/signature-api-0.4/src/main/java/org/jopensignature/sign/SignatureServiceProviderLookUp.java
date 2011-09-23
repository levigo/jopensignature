package org.jopensignature.sign;

import java.util.Iterator;

import javax.imageio.spi.ServiceRegistry;

/**
 * This class provides access to defined {@link SignatureServiceProvider}. For
 * detailed informations about {@link SignatureServiceProvider}s and how to
 * register a {@link SignatureServiceProvider} take look at the javadoc of
 * {@link SignatureServiceProvider}.
 * 
 * @author <a href="mailto:c.koehler@levigo.de">Carolin Köhler</a>
 * @author <a href="mailto:f.fernandes@levigo.de">Francois Fernandes</a>
 */
public final class SignatureServiceProviderLookUp {

	/**
	 * Returns the default {@link SignatureServiceProvider} if any registered
	 * instance is available. Otherwise <code>null</code> will be returned.
	 * 
	 * @return the default {@link SignatureServiceProvider} if available,
	 *         otherwise <code>null</code>
	 */
	public static SignatureServiceProvider getDefaultSignatureServiceProvider() {
		Iterator<SignatureServiceProvider> signingServices = getSignatureServiceProviders();
		if (signingServices != null && signingServices.hasNext())
			return (SignatureServiceProvider) signingServices.next();

		return null;
	}
	/**
     * An <code>Iterator</code> that yields for the {@link SignatureServiceProvider} objects, 
     * in some arbitrary order, which are registered and available. 
     * 
	 * @return an iterator of currently registered and available {@link SignatureServiceProvider}
	 */
	public static Iterator<SignatureServiceProvider> getSignatureServiceProviders() {
		return ServiceRegistry.lookupProviders(SignatureServiceProvider.class);
	}
}