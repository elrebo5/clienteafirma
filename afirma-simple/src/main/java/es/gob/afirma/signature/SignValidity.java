/* Copyright (C) 2011 [Gobierno de Espana]
 * This file is part of "Cliente @Firma".
 * "Cliente @Firma" is free software; you can redistribute it and/or modify it under the terms of:
 *   - the GNU General Public License as published by the Free Software Foundation; 
 *     either version 2 of the License, or (at your option) any later version.
 *   - or The European Software License; either version 1.1 or (at your option) any later version.
 * Date: 11/01/11
 * You may contact the copyright holder at: soporte.afirma5@mpt.es
 */

package es.gob.afirma.signature;

/**
 * Indica si la firma es v&aacute;lida o no.
 * @author Carlos Gamuci
 */
public final class SignValidity {

    /** Tipo del resultado de la firma. */
    public enum SIGN_DETAIL_TYPE {
        /** Firma v&aacute;lida. */
        OK,
        /** Firma inv&aacute;lida. */
        KO,
        /** Validez desconocida. */
        UNKNOWN,
        /** Firma generada en la misma aplicaci&oacute;n, se considera siempre v&aacute;lida. */
        GENERATED
    }

    /** Errores que invalidan una firma o impiden conocer si es v&aacute;lida o no. */
    public enum VALIDITY_ERROR {
        /** Cuando no se puede comprobar la validez por no tener los datos firmados. */
        NO_DATA,
        /** Cuando la informacion contenida en la firma no sea consistente (certificados corruptos,...). */
        CORRUPTED_SIGN,
        /** Cuando la firma no se corresponda con los datos firmados. */
        NO_MATCH_DATA,
        /** Cuando no se encuentra la firma dentro del documento. */
        NO_SIGN,
        /** Cuando no se puede extraer un certificado o este no es v&aacute;lido. */
        CERTIFICATE_PROBLEM,
        /** Cuando existe un certificado de firma caducado. */
        CERTIFICATE_EXPIRED,
        /** Cuando existe un certificado de firma que aun no es v&aacute;lido. */
        CERTIFICATE_NOT_VALID_YET,
        /** Cuando la firma contiene un algoritmo no reconocido o no soportado. */
        ALGORITHM_NOT_SUPPORTED,
        /** Cuando existe alg&uacute;n problema con las CRLs incrustadas en la firma. */
        CRL_PROBLEM,
        /** Cuando se valida un PDF del que no se puede comprobar la validez. */
        UNKOWN_VALIDITY_PDF
    }

    /** Validez de la firma. */
    private final SIGN_DETAIL_TYPE validity;

    /** Error que invalida la firma o hace que la validez sea desconocida. */
    private final VALIDITY_ERROR error;

    /**
     * Identifica la validez de una firma.
     * @param type Validez de la firma.
     * @param error Error que invalida o impide comprobar la firma.
     */
    public SignValidity(final SIGN_DETAIL_TYPE type, final VALIDITY_ERROR error) {
        this.validity = type;
        this.error = error;
    }

    /**
     * Recupera la validez de la firma.
     * @return Validez de la firma.
     */
    public SIGN_DETAIL_TYPE getValidity() {
        return this.validity;
    }

    /**
     * Recupera el error que invalida la firma. Si no existe ning&uacute;n error o este es desconocido,
     * se devolver&aacute; {@code null}.
     * @return Error que invalida la firma o impide comprobar su validez.
     */
    public VALIDITY_ERROR getError() {
        return this.error;
    }
}
