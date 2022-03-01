/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.labonfhir;

import lombok.SneakyThrows;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.DaemonToken;
import org.openmrs.module.DaemonTokenAware;
import org.openmrs.module.labonfhir.api.OpenElisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class iSantePlusLabOnFhirActivator extends BaseModuleActivator implements ApplicationContextAware {

	private static final Logger log = LoggerFactory.getLogger(iSantePlusLabOnFhirActivator.class);

	private static ApplicationContext applicationContext;

	private static DaemonToken daemonToken;

	@Autowired
	private iSantePlusLabOnFhirConfig config;

	@SneakyThrows
	@Override
	public void started() {
		applicationContext.getAutowireCapableBeanFactory().autowireBean(this);

		log.info("iSantePlus Lab on FHIR Module Started!");
	}

	@Override
	public void stopped() {
		log.info("iSantePlus Lab on FHIR Module Shut Down!");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
