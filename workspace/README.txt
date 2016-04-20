I. DEVELOPMENT ENVIRONMENT:
- Eclipse (Mars) for J2EE
- Tomcat Server 8.0
- MySQL (WAMPServer)
- Selenium for JAVA


II. Website Demo info

Project Name: myTime
Description:
- Simple login page with success or error page result, depending on user input.
--- uses JSP files for displaying web pages, JAVA servlets for flow control, and mySQL backend for the database.

Limitations:
- No register function from the website. Sample database table (jlogin_users.sql) with 2 entries is used.


TODO:
1. Add register page and possibly additional user_info tables in database
2. Add more complex web elements to webpage views
3. Source code comments!!!
4. Check if possible to dynamically set database for testing/debug vs actual database
5. Update to use IDs for web elements

III. Test Automation Demo info

Project Name: myTimeAutomation
Description:
- Automates testing of myTime Login page and resulting success or error pages using selenium.

TODO:
1. Source code comments!!!
2. Use inheritance for Pages, since there are common functions needed (ex. LoginPage extends BasePage() )
3. Add error handling, check proper use of try-catch-finally
4. Add test suites
5. Update config class to correctly parse user-define format of *.properties files
6. Move strings from test code to config files (i.e. loginpage.properties will contain element IDs and expected strings for LoginPage)
7. Update database test cases (i.e. create temporary database for testing; so that we have complete control over database contents)
8. Add checkpoints and cleanup/reset or web page, so that next test suites can still proceed even if expected page/web element is not available.
9. Add proper Reporting and Logging (using files instead of console output)
10. Extend Test Driver capability for Chrome, Safari, others