package org.openmrs.module.labonfhir;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class iSantePlusOnFhirConfig {
	public static final String GP_TEST_ORDER_CONCEPT_UUID = "labonfhir.testsOrderedConceptUuid";

	public static final String GP_ORDER_DESTINATION_CONCEPT_UUID = "labonfhir.orderDestinationConceptUuid";

	private static final String GP_DIAGNOSTIC_REPORT_CONCEPT_UUID = "labonfhir.diagnosticReportConceptUuid";

	private static Log log = LogFactory.getLog(iSantePlusOnFhirConfig.class);

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
