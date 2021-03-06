package es.gob.afirma.triphase.server;

import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Properties;

/** Interfaz para la recuperaci&oacute;n de documentos desde un servidor o repositorio documental.
 * ES OBLIGATORIO, que las clases que implementen esta interfaz dispongan de un constructor que reciba
 * &uacute;nicamente un objeto Properties (java.util.Properties.
 * @author Tom&aacute;s Garc&iacute;a-Mer&aacute;s */
public interface DocumentManager {

	/** Obtiene un documento en base a su identificador.
	 * Si no es posible recuperar el fichero se debe lanzar una excepci&oacute;n. El mensaje se recibir&aacute;
	 * como parte del mensaje de error en el cliente de firma.
	 * @param id Identificador del documento
	 * @param cert Certificado que se usar&aacute; para realizar la firma
	 * @param config Par&aacute;metros para la configuraci&oacute;n de la recuperaci&oacute;n del documento.
	 * @return Documento (en binario)
	 * @throws IOException Cuando ocurre alg&uacute;n problema con la recuperaci&oacute;n */
	byte[] getDocument(String id, X509Certificate cert, Properties config) throws IOException;

	/** Almacena un documento firmado.
	 * Si no es posible almacenar el fichero se debe lanzar una excepci&oacute;n. El mensaje se recibir&aacute;
	 * como parte del mensaje de error en el cliente de firma.
	 * @param id Identificador del documento original no firmado.
	 * @param cert Certificado de firma
	 * @param data Datos firmados.
	 * @param config Par&aacute;metros para la configuraci&oacute;n del guardado del documento.
	 * @return Identificador del nuevo documento codificado en base 64.
	 * @throws IOException Cuando ocurre alg&uacute;n problema con la recuperaci&oacute;n */
	String storeDocument(String id, final X509Certificate cert, byte[] data, Properties config) throws IOException;
}
