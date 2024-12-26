# Project Description
This project consists of three automated test cases using Java, Selenium, and JUnit:

**Webform Automation for Digital Unite**
- Automating the form submission process, including file upload (≤ 2 MB) and validating the success message.

**Guest Registration Automation for WP Everest**
- Automating the guest registration form by filling out mandatory fields, submitting the form, and verifying successful registration.

**Web Scraping for DSEBD Stock Prices**
- Scraping stock market table data, printing all cell values, and storing them in a text file for further reference.

# Prerequisites
To execute these automated scripts, ensure the following setup:

**Development Environment:**
- Java Development Kit (JDK) 8 or above.
- IntelliJ IDEA or Eclipse IDE configured with Java..

**Libraries/Dependencies:**
- Selenium WebDriver.
- JUnit framework.

**Browser and Driver:**
- ChromeDriver, FireFoxDriver, or any compatible browser driver.

Test Data:
- A valid file for upload (≤ 2 MB).
- Sample registration data for the guest form.

# What I Have Done
## Webform Automation for Digital Unite
- Automated field inputs.
- Implemented file upload functionality.
- Asserted the expected success message: "Thank you for your submission!".

**Report**

![image](https://github.com/user-attachments/assets/f749c97f-c3c6-4cd5-8327-6d1d7cd1d3eb)


## Guest Registration Automation for WP Everest
- Automated field inputs for First Name, Last Name, Email, Password, Gender, DOB, Nationality, Phone, Country, and acceptance of Terms & Conditions.
- Asserted successful registration upon submission.

**Report**

![image](https://github.com/user-attachments/assets/0875c022-ff5d-4462-9415-71c5b6b16a65)


## Web Scraping for DSEBD Stock Prices
- Scraped table data from the provided webpage using Selenium.
- Printed all table cell values in the console.
- Stored the scraped data into a text file for reference.

**Report**

![image](https://github.com/user-attachments/assets/fb67c177-9d6b-4e57-aa71-7d25b5c231d1)

**Text File**

![image](https://github.com/user-attachments/assets/538b9b85-d773-4c3c-ac41-4a78d68fdb69)


# How to Run the Tests
**Setup and Configuration**
- Install JDK and set up your IDE (Eclipse/IntelliJ IDEA).
- Add Selenium and JUnit libraries to your project build path.
- Ensure the browser driver (e.g., ChromeDriver) is installed and set in your PATH.

**Running the Tests**
- Clone or download the project files to your local machine.
- Open the respective Java test class for the automation task:
  - ```Task01WebFormSubmission.java```
  - ```Task02UserRegistration.java```
  - ```Task03ScrapTableData.java```
- Run the test classes from the IDE or using the terminal command:

**Verification**
- For the web forms:
  - Check the assertion logs for success or failure messages.
- For the table scraping:
  - Verify the console output and the generated text file (e.g., store.txt).

**Output Files**
- Logs: Test results and execution details are logged in the console.
- Text File: Scraped table data is stored in ```store.txt```.
