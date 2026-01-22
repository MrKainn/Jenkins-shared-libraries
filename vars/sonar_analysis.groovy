def call(String SonarQubeAPI, String Projectname, String ProjectKey){
  // This is a SonarQube Scanner for Jenkins plugin. It injects the SonarQube server connection details (URL, authentication token, etc.) into the environment variables for the code inside the block.
  // "${SonarQubeAPI}": This interpolates the string variable passed into the function to select the specific server configuration you want to use.
  withSonarQubeEnv("${SonarQubeAPI}"){
    // This assume already set env variable SONAR_CRED pointing to where the scanner is installed.
    // /bin/sonar-scanner: This is the actual executable binary that runs the analysis.
    // -Dsonar.projectName=${Projectname}: The -D flag sets a SonarQube property. This sets the project's display name using the variable passed to the function.
    // -Dsonar.projectKey=${ProjectKey}: This sets the unique project key. This is critical for linking the analysis to the correct project in the SonarQube database.
    // -X: This flag enables Debug logging. It makes the output very verbose, which is helpful for troubleshooting errors but might spam the logs during normal runs.
      sh "$SONAR_CRED/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
  }
}
