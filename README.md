# Sauce Demo Automation Framework

<div align="center">

### 🧪 QA Automation Framework | Selenium WebDriver + TestNG + RestAssured

*Java-based UI & API test automation with Page Object Model structure and Allure Reporting*

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/giorgi-kuchava-94bb9b359)
[![Email](https://img.shields.io/badge/Email-Contact-red?style=for-the-badge&logo=gmail)](mailto:giorgikuchava2020@gmail.com)

</div>

---

## 👋 About This Project

This is a Java test automation framework built around **Selenium WebDriver**, **TestNG**, **RestAssured**, **Maven**, and **Allure Reporting**, structured using the **Page Object Model**. It covers both UI and API test suites for the Sauce Demo shop, with CI/CD wired up through GitHub Actions.

---

## 🛠️ Tools & Technologies

- 🌐 **Selenium WebDriver** — UI browser automation
- 🧪 **TestNG** — test execution and suite management
- 🔗 **RestAssured** — API testing
- 📦 **Maven** — build and dependency management
- 📊 **Allure Reporting** — test reporting
- ⚙️ **GitHub Actions** — CI/CD pipelines

---

## 📁 Project Structure

```text
automation-exercise-framework/
├── src/main/java/pages
├── src/main/java/api
├── src/main/java/utils
├── src/test/java/ui
├── src/test/java/api
└── src/test/resources
```

---

## ⚙️ Configuration

Main settings live in `src/test/resources/config.properties`.

```properties
base.url=https://sauce-demo.myshopify.com
api.base.url=https://sauce-demo.myshopify.com
browser=brave
implicit.wait=10
explicit.wait=15
```

---

## ▶️ Run Tests

Run the full suite:

```bash
mvn clean test
```

Run with Safari:

```bash
mvn clean test -Dbrowser=safari
```

Run only UI tests:

```bash
mvn clean test -DsuiteXmlFile=src/test/resources/testng-ui.xml -Dbrowser=safari
```

Run only API tests:

```bash
mvn clean test -DsuiteXmlFile=src/test/resources/testng-api.xml
```

---

## ✅ Current Test Coverage

The suite includes smoke and regression tests for:

- Home page
- Header navigation
- Catalog page
- Product details
- Empty cart
- Continue shopping
- Login page
- Reset password section
- Create account page
- Search page
- Blog page
- About Us page
- Public page API/status checks

---

## 📈 Allure Report

Generate and open the report:

```bash
mvn allure:serve
```

---

## 🔄 CI/CD

This project includes GitHub Actions workflows under `.github/workflows`.

CI automatically checks the project when code is pushed or a pull request is opened. The regular CI workflow:

- Installs Java 17
- Downloads Maven dependencies
- Runs the API test suite
- Uploads TestNG reports
- Uploads Allure result files

**Regular CI workflow:**
```text
.github/workflows/ci.yml
```

UI browser tests run in a separate **manual** workflow since they need a real browser runner. Safari tests specifically require macOS, so they're kept out of the automatic push checks.

**Manual UI workflow:**
```text
.github/workflows/ui-tests.yml
```

### How to Use It on GitHub

1. Push this project to a GitHub repository.
2. Open the repository on GitHub.
3. Go to the **Actions** tab.
4. The `CI` workflow runs automatically on push and pull request.
5. To run browser tests, select `UI Tests`, click **Run workflow**, and choose `safari` or `chrome`.

After a workflow finishes, open the run and download the uploaded artifacts:

- `testng-api-reports`
- `allure-api-results`
- `testng-ui-reports-safari`
- `allure-ui-results-safari`

### CI Commands

API suite:
```bash
mvn -B clean test -DsuiteXmlFile=src/test/resources/testng-api.xml
```

UI suite:
```bash
mvn -B clean test -DsuiteXmlFile=src/test/resources/testng-ui.xml -Dbrowser=safari
```

---

## 🌐 Browser Notes

The default browser is `brave`. Selenium Manager handles driver resolution for Chromium-based browsers. If Brave is installed in a non-standard location, provide the binary path:

```bash
mvn clean test -Dbrave.binary=/path/to/brave
```

---

## 📫 Let's Connect

<div align="center">

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/giorgi-kuchava-94bb9b359)
[![Email](https://img.shields.io/badge/Email-Contact-red?style=for-the-badge&logo=gmail)](mailto:giorgikuchava2020@gmail.com)

</div>