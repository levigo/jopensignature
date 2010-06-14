package org.jopensignature.sign;

/**
 * Basic transport interface to forward additional information or
 * configuration preferences to the signer implementation. 
 *  
 * @author <a href="mailto:c.koehler@levigo.de">Carolin Köhler</a>
 * @author <a href="mailto:f.fernandes@levigo.de">Francois Fernandes</a>
 */
public interface MetaInfoField {
	/**
	 * Returns an unique identifier 
	 *  
	 * @return
	 */
	public String getType();

}