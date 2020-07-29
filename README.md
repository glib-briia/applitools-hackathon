## Applitools UFG Hackathon 

- Test framework: TestNG 
- Browser automation framework: Selenium Java
- Build tool: Gradle
- Visual AI automation tool: Applitools

## Prerequisites

- JDK 8+
- Applitools API Key to be set as environment variable e.g. 
  - Mac/linux : `export APPLITOOLS_API_KEY=<API KEY>`
  - Windows (Powershell/cmd): `set APPLITOOLS_API_KEY=<API KEY>`
- For local run Chrome, Firefox and Microsoft Edge should be installed
- The app was tested on the following browser versions (locally):

| Browser       | Version       |
| ------------- | ------------- |
| Chrome        | 83.0.4103.97  |
| Firefox       | 77.0.1        |
| Edge          | 83.0.478.50   |


## Getting Started

1. Clone the repository - `git clone https://github.com/glib-briia/applitools-ufg-hackathon.git`
2. Open terminal and run `cd applitools-hackathon`

### Run tests:

- Traditional tests against APP V1: `gradlew clean traditionalTests -PAPP_VERSION=V1`
- Traditional tests against APP V2: `gradlew clean traditionalTests -PAPP_VERSION=V2`
- Modern tests against APP V1: `gradlew clean modernTests -PAPP_VERSION=V1`
- Modern tests against APP V2: `gradlew clean modernTests -PAPP_VERSION=V2`

- Specific hackathon task use the commands above appending `-Ptask=task_number` where task number can be either 1, 2 or 3

### Eyes Batch Results URL

 - [Test results](https://eyes.applitools.com/app/test-results/00000251809621932489)
 
### Traditional tests results
- [Traditional-V1-TestResults.txt](Traditional-V1-TestResults.txt)
- [Traditional-V2-TestResults.txt](Traditional-V2-TestResults.txt)

### Implementation notes

- For traditional tests browsers and viewports combinations and concurrency level are controlled in TestNG suites files [TraditionalTestsV1](src/test/resources/TraditionalTestsV1.xml) and [TraditionalTestsV2](src/test/resources/TraditionalTestsV2.xml).
- For modern tests concurrency lever for VisualGridRunner and batch name are controlled in TestNG suites files [ModernTestsV1](src/test/resources/ModernTestsV1.xml) and [ModernTestsV2](src/test/resources/ModernTestsV2.xml).
- In Traditional approach in order to determine weather the check is applicable for device test groups were used e.g. ``groups = {Laptop, Tablet, iPhone_X}`` 
- By default Selenium doesnt allow to set viewport size, it only allows to set window size which significantly larger that the actual viewport. In order to calculate window size based on required viewport the following formula was used 
   
   ```window width = window.outerWidth - window.innerWidth  + desired viewport width```
   
   ```window height = window.outerHeight - window.innerHeight + desired viewport height```
   
   in [DriverFactory.setViewportSize](/src/main/java/utilities/DriverFactory.java)
- Eyes Batch Results URL above is for the latest run. In total there were 3 runs (baseline against V1, then run against V2 which was resolved with 'bug regions' and the third one against V2 again to try 'Automatically Marking Future Tests as Failed' functionality)
