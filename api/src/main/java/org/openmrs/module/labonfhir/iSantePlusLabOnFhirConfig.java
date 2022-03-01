package org.openmrs.module.labonfhir;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.function.Predicate;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.hl7.fhir.r4.model.Practitioner;
import org.openmrs.Obs;
import org.openmrs.api.AdministrationService;
import org.openmrs.module.fhir2.api.FhirPractitionerService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class iSantePlusLabOnFhirConfig  {
	public static final String GP_TEST_ORDER_CONCEPT_UUID = "labonfhir.testsOrderedConceptUuid";

	public static final String GP_ORDER_DESTINATION_CONCEPT_UUID = "labonfhir.orderDestinationConceptUuid";

	private static final String GP_DIAGNOSTIC_REPORT_CONCEPT_UUID = "labonfhir.diagnosticReportConceptUuid";

	private static Log log = LogFactory.getLog(iSantePlusLabOnFhirConfig.class);

	@Autowired
	@Qualifier("adminService")
	AdministrationService administrationService;

	public String getTestOrderConceptUuid() {
		return administrationService.getGlobalProperty(GP_TEST_ORDER_CONCEPT_UUID);
	}

	public String getDiagnosticReportConceptUuid() {
		return administrationService.getGlobalProperty(GP_DIAGNOSTIC_REPORT_CONCEPT_UUID);
	}

	public String getOrderDestinationConceptUuid() {
		return administrationService.getGlobalProperty(GP_ORDER_DESTINATION_CONCEPT_UUID);
	}
}
