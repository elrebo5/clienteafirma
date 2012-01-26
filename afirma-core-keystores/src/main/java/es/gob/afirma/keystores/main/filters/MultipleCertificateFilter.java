package es.gob.afirma.keystores.main.filters;

import java.security.cert.X509Certificate;

import es.gob.afirma.keystores.main.common.AOKeyStoreManager;
import es.gob.afirma.keystores.main.filters.CertificateFilter;

/**
 * Clase que engloba m&uacute;ltiples filtros de certificados, de tal forma que
 * s&oacute;lo pasar&acute;n por el filtro aquellos que cumplan con todos los filtros
 * individualmente.
 */
public class MultipleCertificateFilter extends CertificateFilter {

	/** Listado de filtros que se desean aplicar sobre los certificados. */
	final CertificateFilter[] filters;

	/**
	 * Crea un filtro m&uacute;ltiple a partir de un listado de filtros.
	 * @param filters Listado de filtros.
	 */
	public MultipleCertificateFilter(final CertificateFilter[] filters) {
		if (filters == null) {
			throw new NullPointerException("Listado nulo de filtros de certificados"); //$NON-NLS-1$
		}
		this.filters = filters;
	}

	@Override
	public boolean matches(final X509Certificate cert) {

		for (final CertificateFilter filter : this.filters) {
			if (!filter.matches(cert)) {
				return false;
			}
		}
		return true;
	}

    @Override
	public String[] matches(final String[] aliases, final AOKeyStoreManager ksm) {

    	String[] filteredAliases = aliases.clone();
    	for (final CertificateFilter filter : this.filters) {
    		filteredAliases = filter.matches(filteredAliases, ksm);
		}
		return filteredAliases;
    }
}
