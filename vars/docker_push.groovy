def call(String projectImage, String imageTag, String dockerHubRepo) {
    echo "Pushing the Image to Docker Hub Initiated: ${dockerHubRepo}/${projectImage}:${imageTag}"
    
    // We use a different name for the credential variables to avoid shadowing function parameters
    withCredentials([usernamePassword(credentialsId: 'DockerHubCred', 
                                      usernameVariable: 'DOCKER_USER', 
                                      passwordVariable: 'DOCKER_PASS')]) {
        
        // Log in using the credentials from Jenkins
        sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
        
        // 1. Tag the local image with the remote repository name and the specific version tag
        sh "docker tag ${projectImage}:latest ${dockerHubRepo}/${projectImage}:${imageTag}"
        
        // 2. Push both tags
        sh "docker push ${dockerHubRepo}/${projectImage}:${imageTag}"
        
        echo '@@@ Image Pushed to Docker-Hub Successfully @@@'
    }
}





