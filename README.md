# iSantePlus FHIR Workflows Module

## Overview
This module provides support for FHIR-based communication for iSantePlus using the OpenMRS FHIR2 module. This module
implements the required custom mappings between the iSantePlus data model and FHIR resources in places where the iSantePlus
and OpenMRS data models diverge.

## Building and Deploying

1. Build and create `.omod` file:
```shell
mvn clean package
```

2. Use omod file as part of an OpenMRS distribution. 
