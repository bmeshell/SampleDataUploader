# SampleDataUploader
Java project for uploading .json FHIR instances to an open FHIR server

To use:
1. Put .json files for sample FHIR instances in the `SampleDataUploader/src/upload` folder.
2. Specify `FHIR_SERVER_BASE_URL` in `FhirInstanceUploader.java`
3. Run the application from your IDE of choice (tested with IntelliJ.)

Coming soon: command line execution with the ability to specify upload filepath and FHIR server url as arguments.

Coming much later: a graphical interface.